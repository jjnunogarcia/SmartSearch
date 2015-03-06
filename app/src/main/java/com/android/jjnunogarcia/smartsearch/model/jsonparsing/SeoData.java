package com.android.jjnunogarcia.smartsearch.model.jsonparsing;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * User: jesus
 * Date: 05/03/15
 *
 * @author jjnunogarcia@gmail.com
 */
public class SeoData implements Parcelable {
  private Object object;

  public static final Creator<SeoData> CREATOR;

  static {
    CREATOR = new Creator<SeoData>() {

      @Override
      public SeoData createFromParcel(Parcel source) {
        return new SeoData(source);
      }

      @Override
      public SeoData[] newArray(int size) {
        return new SeoData[size];
      }
    };
  }

  public SeoData() {}

  private SeoData(Parcel source) {
    this();
    readFromParcel(source);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(object);
  }

  private void readFromParcel(Parcel source) {
    object = source.readValue(Object.class.getClassLoader());
  }

  public Object getObject() {
    return object;
  }

  public void setObject(Object object) {
    this.object = object;
  }
}
