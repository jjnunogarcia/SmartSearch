package com.android.jjnunogarcia.smartsearch;

import android.app.Application;
import com.squareup.picasso.Picasso;

import java.util.concurrent.Executors;

/**
 * User: jesus
 * Date: 06/03/15
 *
 * @author j.nuno@klara.com
 */
public class SmartSearchApplication extends Application {
  public static final String TAG = SmartSearchApplication.class.getSimpleName();

  private Picasso picasso;

  @Override
  public void onCreate() {
    super.onCreate();
    picasso = new Picasso.Builder(getApplicationContext()).executor(Executors.newSingleThreadExecutor()).build();
  }

  public Picasso getPicasso() {
    return picasso;
  }
}
