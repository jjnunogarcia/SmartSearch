package com.android.jjnunogarcia.smartsearch.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.android.jjnunogarcia.smartsearch.R;
import com.android.jjnunogarcia.smartsearch.model.jsonparsing.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: jesus
 * Date: 05/03/15
 *
 * @author j.nuno@klara.com
 */
public class ProductArrayAdapter extends BaseAdapter implements Filterable {
  private final String TAG = ProductArrayAdapter.class.getSimpleName();

  private Context            context;
  private ArrayList<Product> products;
  private ArrayList<Product> allProducts;
  private ArrayList<Product> suggestions;
  private Filter             nameFilter;

  public ProductArrayAdapter(Context context, ArrayList<Product> products) {
    this.context = context;
    this.products = products;
    allProducts = (ArrayList<Product>) products.clone();
    suggestions = new ArrayList<>();
    nameFilter = new ProductFilter();
  }

  public void setContent(ArrayList<Product> products) {
    this.products = products;
    allProducts = (ArrayList<Product>) products.clone();
    suggestions = new ArrayList<>();
    notifyDataSetChanged();
  }

  public void clear() {
    products.clear();
    allProducts.clear();
    suggestions.clear();
    notifyDataSetChanged();
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View view = convertView;

    if (view == null) {
      LayoutInflater vi = LayoutInflater.from(context);
      view = vi.inflate(R.layout.autocomplete_drop_down_item, parent, false);
    }

    Product product = products.get(position);
    TextView productName = (TextView) view.findViewById(R.id.autocomplete_drop_down_item_text);
    productName.setText(product.getName());

    return view;
  }

  @Override
  public int getCount() {
    return products.size();
  }

  @Override
  public Product getItem(int position) {
    return products.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public Filter getFilter() {
    return nameFilter;
  }

  public List<Product> getSuggestions() {
    return Collections.unmodifiableList(suggestions);
  }

  private class ProductFilter extends Filter {

    @Override
    public String convertResultToString(Object resultValue) {
      return ((Product) resultValue).getName();
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
      FilterResults filterResults = new FilterResults();
      if (constraint != null) {
        suggestions.clear();

        for (Product product : allProducts) {
          if (product.getName().toLowerCase().startsWith(constraint.toString().toLowerCase())) {
            suggestions.add(product);
          }
        }

        products = suggestions;
        filterResults.values = suggestions;
        filterResults.count = suggestions.size();
      }

      return filterResults;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
      if (results != null && results.count > 0) {
        notifyDataSetChanged();
      } else {
        notifyDataSetInvalidated();
      }
    }
  }
}
