package com.android.jjnunogarcia.smartsearch.model.jsonparsing;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * User: jesus
 * Date: 05/03/15
 *
 * @author jjnunogarcia@gmail.com
 */
public class BreadCrumbs implements Parcelable {
  private ArrayList<Object> objects;

  public static final Creator<BreadCrumbs> CREATOR;

  static {
    CREATOR = new Creator<BreadCrumbs>() {

      @Override
      public BreadCrumbs createFromParcel(Parcel source) {
        return new BreadCrumbs(source);
      }

      @Override
      public BreadCrumbs[] newArray(int size) {
        return new BreadCrumbs[size];
      }
    };
  }

  public BreadCrumbs() {
    objects = new ArrayList<>();
  }

  private BreadCrumbs(Parcel source) {
    this();
    readFromParcel(source);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeList(objects);
  }

  private void readFromParcel(Parcel source) {
    source.readList(objects, Object.class.getClassLoader());
  }

  public ArrayList<Object> getObjects() {
    return objects;
  }

  public void setObjects(ArrayList<Object> objects) {
    this.objects = objects;
  }
}
