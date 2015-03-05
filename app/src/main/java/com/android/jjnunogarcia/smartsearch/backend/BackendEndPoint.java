package com.android.jjnunogarcia.smartsearch.backend;

import android.content.Context;
import android.os.AsyncTask;
import com.android.jjnunogarcia.smartsearch.backend.requests.GetProductsTask;

/**
 * User: jesus
 * Date: 05/03/15
 *
 * @author jjnunogarcia@gmail.com
 */
public final class BackendEndPoint {

  public static GetProductsTask getProductsTask(Context context) {
    GetProductsTask getProductsTask = new GetProductsTask(context);
    getProductsTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
    return getProductsTask;
  }
}
