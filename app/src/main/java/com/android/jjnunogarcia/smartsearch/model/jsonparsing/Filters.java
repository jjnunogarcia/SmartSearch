package com.android.jjnunogarcia.smartsearch.model.jsonparsing;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * User: jesus
 * Date: 05/03/15
 *
 * @author j.nuno@klara.com
 */
public class Filters implements Parcelable {
  private Object object;

  public static final Creator<Filters> CREATOR;

  static {
    CREATOR = new Creator<Filters>() {

      @Override
      public Filters createFromParcel(Parcel source) {
        return new Filters(source);
      }

      @Override
      public Filters[] newArray(int size) {
        return new Filters[size];
      }
    };
  }

  public Filters() {}

  private Filters(Parcel source) {
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
