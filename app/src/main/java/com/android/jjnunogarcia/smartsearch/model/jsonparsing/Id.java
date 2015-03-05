package com.android.jjnunogarcia.smartsearch.model.jsonparsing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * User: jesus
 * Date: 05/03/15
 *
 * @author j.nuno@klara.com
 */
public class Id implements Parcelable {
  @SerializedName("$oid")
  private String oid;

  public static final Creator<Id> CREATOR;

  static {
    CREATOR = new Creator<Id>() {

      @Override
      public Id createFromParcel(Parcel source) {
        return new Id(source);
      }

      @Override
      public Id[] newArray(int size) {
        return new Id[size];
      }
    };
  }

  public Id() {}

  private Id(Parcel source) {
    this();
    readFromParcel(source);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(oid);
  }

  private void readFromParcel(Parcel source) {
    oid = source.readString();
  }

  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }
}
