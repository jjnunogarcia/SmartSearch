package com.android.jjnunogarcia.smartsearch.activities;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.android.jjnunogarcia.smartsearch.R;
import com.android.jjnunogarcia.smartsearch.SmartSearchApplication;
import com.android.jjnunogarcia.smartsearch.adapters.ProductArrayAdapter;
import com.android.jjnunogarcia.smartsearch.backend.BackendEndPoint;
import com.android.jjnunogarcia.smartsearch.backend.requests.GetProductsTask;
import com.android.jjnunogarcia.smartsearch.eventbus.GetProductsTaskResultEvent;
import com.android.jjnunogarcia.smartsearch.helpers.PicassoUrlCallback;
import com.android.jjnunogarcia.smartsearch.model.jsonparsing.Product;
import com.android.jjnunogarcia.smartsearch.views.CustomAutoCompleteTextView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import de.greenrobot.event.EventBus;

import java.util.ArrayList;

/**
 * User: jesus
 * Date: 06/03/15
 *
 * @author jjnunogarcia@gmail.com
 */
public class SearchActivity extends ActionBarActivity implements TextWatcher, TextView.OnEditorActionListener, AdapterView.OnItemClickListener {
  public static final String TAG  = SearchActivity.class.getSimpleName();
  public static final String FONT = "fonts/DroidSerif-Regular.ttf";

  @InjectView(R.id.activity_search_toolbar)
  Toolbar                    toolbar;
  @InjectView(R.id.activity_search_toolbar_autocomplete_text_view)
  CustomAutoCompleteTextView searchTextView;
  @InjectView(R.id.activity_search_toolbar_autocomplete_progress_bar)
  ProgressBar                searchProgressBar;
  @InjectView(R.id.activity_search_location_container)
  LinearLayout               locationContainer;
  @InjectView(R.id.activity_search_location_text_view)
  TextView                   locationText;
  @InjectView(R.id.activity_search_details_container)
  LinearLayout               detailsContainer;
  @InjectView(R.id.activity_search_details_name_text_view)
  TextView                   detailsNameText;
  @InjectView(R.id.activity_search_details_name_image_view)
  ImageView                  detailsImage;
  @InjectView(R.id.activity_search_details_name_image_view_progress_bar)
  ProgressBar                detailsImageProgressBar;
  @InjectView(R.id.activity_search_details_location_text_view)
  TextView                   detailsLocationText;

  private ProductArrayAdapter productArrayAdapter;
  private ArrayList<Product>  products;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);
    ButterKnife.inject(this);
    setSupportActionBar(toolbar);
    setFonts();

    products = new ArrayList<>();
    searchTextView.addTextChangedListener(this);
    searchTextView.setOnEditorActionListener(this);
    searchTextView.setOnItemClickListener(this);
    searchTextView.setThreshold(1);
    productArrayAdapter = new ProductArrayAdapter(getApplicationContext(), new ArrayList<Product>());
    searchTextView.setAdapter(productArrayAdapter);
  }

  private void setFonts() {
    Typeface typeface = Typeface.createFromAsset(getAssets(), FONT);
    searchTextView.setTypeface(typeface);
    locationText.setTypeface(typeface);
    detailsNameText.setTypeface(typeface);
    detailsLocationText.setTypeface(typeface);
  }

  public void onEvent(GetProductsTaskResultEvent getProductsTaskResultEvent) {
    searchProgressBar.setVisibility(View.INVISIBLE);
    if (getProductsTaskResultEvent.getServerResponse() == GetProductsTask.SERVER_SUCCESS) {
      products = getProductsTaskResultEvent.getProductsResponse().getProducts();
      productArrayAdapter.setContent(products);
      productArrayAdapter.getFilter().filter(searchTextView.getText().toString().trim());
    } else {
      Toast.makeText(getApplicationContext(), getString(R.string.activity_search_get_products_error), Toast.LENGTH_SHORT).show();
    }
  }

  private void displayLocationCount() {
    locationContainer.setVisibility(View.VISIBLE);
    int count = 0;

    for (Product product : productArrayAdapter.getSuggestions()) {
      count += product.getLocations().size();
    }

    locationText.setText(String.format(getString(R.string.activity_search_location_text_view), count));
  }

  private void displayDetailsLocationCount(Product product) {
    detailsContainer.setVisibility(View.VISIBLE);
    detailsLocationText.setText(String.format(getString(R.string.activity_search_details_location_text_view), product.getLocations().size()));
  }

  @Override
  public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

  @Override
  public void onTextChanged(CharSequence s, int start, int before, int count) {
    locationContainer.setVisibility(View.GONE);
    detailsContainer.setVisibility(View.GONE);

    if (s.length() > 0 && before == 0) { // Call endpoint only if user is adding more text, not deleting
      searchProgressBar.setVisibility(View.VISIBLE);
      productArrayAdapter.clear();
      BackendEndPoint.getProductsTask(getApplicationContext());
    } else {
      productArrayAdapter.getFilter().filter(searchTextView.getText().toString().trim());
    }
  }

  @Override
  public void afterTextChanged(Editable s) {}

  @Override
  public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
    if (textView.getId() == R.id.activity_search_toolbar_autocomplete_text_view && (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL)) {
      searchTextView.dismissDropDown();
      hideKeyboard();
      displayLocationCount();
      return true;
    }

    return false;
  }

  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    searchTextView.dismissDropDown();
    setItemDetails(productArrayAdapter.getItem(position));
  }

  private void setItemDetails(Product product) {
    if (product.getImages() != null && !product.getImages().isEmpty()) {
      Picasso picasso = ((SmartSearchApplication) getApplication()).getPicasso();
      Callback picassoCallback = new PicassoUrlCallback(detailsImage, detailsImageProgressBar);
      String imageUrl = product.getImages().get(0).getImage();
      int imageSize = (int) getResources().getDimension(R.dimen.activity_search_details_image_size);
      picasso.load(imageUrl).resize(imageSize, imageSize).centerInside().into(detailsImage, picassoCallback);
    }

    detailsNameText.setText(product.getName());
    displayDetailsLocationCount(product);
  }

  private void hideKeyboard() {
    searchTextView.clearFocus();
    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(searchTextView.getWindowToken(), 0);
  }

  @Override
  protected void onResume() {
    super.onResume();
    EventBus.getDefault().registerSticky(this);
  }

  @Override
  protected void onPause() {
    super.onPause();
    EventBus.getDefault().unregister(this);
  }
}
