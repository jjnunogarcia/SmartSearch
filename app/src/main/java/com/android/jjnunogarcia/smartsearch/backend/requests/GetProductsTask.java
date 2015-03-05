package com.android.jjnunogarcia.smartsearch.backend.requests;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.android.jjnunogarcia.smartsearch.R;
import com.android.jjnunogarcia.smartsearch.eventbus.GetProductsTaskResultEvent;
import com.android.jjnunogarcia.smartsearch.model.jsonparsing.ProductsResponse;
import com.google.gson.Gson;
import de.greenrobot.event.EventBus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * User: Jesús
 * Date: 25/02/14
 *
 * @author jjnunogarcia@gmail.com
 */
public class GetProductsTask extends AsyncTask<Void, Void, GetProductsTaskResultEvent> implements ResponseHandler<GetProductsTaskResultEvent> {
  private static final String TAG                = GetProductsTask.class.getSimpleName();
  public static final  int    CONNECTION_TIMEOUT = 10000;
  public static final  int    SERVER_NOT_FOUND   = 404;
  public static final  int    SERVER_SUCCESS     = 200;

  private Context                    context;
  private GetProductsTaskResultEvent getProductsTaskResultEvent;

  public GetProductsTask(Context context) {
    this.context = context;
    getProductsTaskResultEvent = new GetProductsTaskResultEvent(SERVER_NOT_FOUND);
  }

  @Override
  protected GetProductsTaskResultEvent doInBackground(Void... params) {
    String baseUrl = context.getString(R.string.products_url);
    HttpClient httpClient = new DefaultHttpClient();
    HttpConnectionParams.setConnectionTimeout(httpClient.getParams(), CONNECTION_TIMEOUT);

    try {
      HttpUriRequest request = new HttpGet(baseUrl);
      return httpClient.execute(request, this);
    } catch (ClientProtocolException e) {
      Log.e(TAG, "Client Protocol exception", e);
    } catch (IOException e) {
      Log.e(TAG, "Input/Output exception", e);
    }

    return getProductsTaskResultEvent;
  }

  @Override
  public GetProductsTaskResultEvent handleResponse(HttpResponse httpResponse) throws IOException {
    HttpEntity entity = httpResponse.getEntity();
    StatusLine statusLine = httpResponse.getStatusLine();

    if (entity != null && statusLine != null) {
      int statusCode = statusLine.getStatusCode();
      getProductsTaskResultEvent.setServerResponse(statusCode);
      String responseString = EntityUtils.toString(entity);
      getProductsTaskResultEvent.setServerMessage(responseString);
      if (statusCode == SERVER_SUCCESS) {
        Gson gson = new Gson();
        ProductsResponse productsResponse = gson.fromJson(responseString, ProductsResponse.class);
        getProductsTaskResultEvent.setProductsResponse(productsResponse);
      }
    }

    return getProductsTaskResultEvent;
  }

  @Override
  protected void onPostExecute(GetProductsTaskResultEvent getOffersTaskResultEvent) {
    super.onPostExecute(getOffersTaskResultEvent);
    EventBus.getDefault().post(getOffersTaskResultEvent);
  }
}
