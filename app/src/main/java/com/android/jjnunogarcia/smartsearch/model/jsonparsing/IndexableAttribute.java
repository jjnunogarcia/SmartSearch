package com.android.jjnunogarcia.smartsearch.model.jsonparsing;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * User: jesus
 * Date: 05/03/15
 *
 * @author j.nuno@klara.com
 */
public class IndexableAttribute implements Parcelable {
  private String attribute;

  public static final Creator<IndexableAttribute> CREATOR;

  static {
    CREATOR = new Creator<IndexableAttribute>() {

      @Override
      public IndexableAttribute createFromParcel(Parcel source) {
        return new IndexableAttribute(source);
      }

      @Override
      public IndexableAttribute[] newArray(int size) {
        return new IndexableAttribute[size];
      }
    };
  }

  public IndexableAttribute() {}

  private IndexableAttribute(Parcel source) {
    this();
    readFromParcel(source);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(attribute);
  }

  private void readFromParcel(Parcel source) {
    attribute = source.readString();
  }

  public String getAttribute() {
    return attribute;
  }

  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }
}
