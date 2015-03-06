package com.android.jjnunogarcia.smartsearch.model.jsonparsing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * User: jesus
 * Date: 05/03/15
 *
 * @author jjnunogarcia@gmail.com
 */
public class MinPrice implements Parcelable {
  @SerializedName("value")
  private int    value;
  @SerializedName("currency")
  private String currency;

  public static final Creator<MinPrice> CREATOR;

  static {
    CREATOR = new Creator<MinPrice>() {

      @Override
      public MinPrice createFromParcel(Parcel source) {
        return new MinPrice(source);
      }

      @Override
      public MinPrice[] newArray(int size) {
        return new MinPrice[size];
      }
    };
  }

  public MinPrice() {}

  private MinPrice(Parcel source) {
    this();
    readFromParcel(source);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(value);
    dest.writeString(currency);
  }

  private void readFromParcel(Parcel source) {
    value = source.readInt();
    currency = source.readString();
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}
