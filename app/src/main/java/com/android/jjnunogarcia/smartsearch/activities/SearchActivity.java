package com.android.jjnunogarcia.smartsearch.activities;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.android.jjnunogarcia.smartsearch.R;
import com.android.jjnunogarcia.smartsearch.backend.BackendEndPoint;
import com.android.jjnunogarcia.smartsearch.backend.requests.GetProductsTask;
import com.android.jjnunogarcia.smartsearch.eventbus.GetProductsTaskResultEvent;
import de.greenrobot.event.EventBus;


public class SearchActivity extends ActionBarActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);

    BackendEndPoint.getProductsTask(getApplicationContext());
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.menu_search, menu);

    MenuItem searchItem = menu.findItem(R.id.activity_search_menu_search);

    SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

    SearchView searchView = null;
    if (searchItem != null) {
      searchView = (SearchView) searchItem.getActionView();
    }
    if (searchView != null) {
      searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
    }
    return super.onCreateOptionsMenu(menu);
  }
  
  public void onEvent(GetProductsTaskResultEvent getProductsTaskResultEvent) {
    if (getProductsTaskResultEvent.getServerResponse() == GetProductsTask.SERVER_SUCCESS) {

    } else {
      
    }
  }

//  @Override
//  public boolean onOptionsItemSelected(MenuItem item) {
//    // Handle action bar item clicks here. The action bar will
//    // automatically handle clicks on the Home/Up button, so long
//    // as you specify a parent activity in AndroidManifest.xml.
//    int id = item.getItemId();
//
//    //noinspection SimplifiableIfStatement
//    if (id == R.id.activity_search_menu_search) {
//      return true;
//    }
//
//    return super.onOptionsItemSelected(item);
//  }

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
