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
public class Term implements Parcelable {
  @SerializedName("term")
  private String term;
  @SerializedName("count")
  private int    count;

  public static final Creator<Term> CREATOR;

  static {
    CREATOR = new Creator<Term>() {

      @Override
      public Term createFromParcel(Parcel source) {
        return new Term(source);
      }

      @Override
      public Term[] newArray(int size) {
        return new Term[size];
      }
    };
  }

  public Term() {}

  private Term(Parcel source) {
    this();
    readFromParcel(source);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(term);
    dest.writeInt(count);
  }

  private void readFromParcel(Parcel source) {
    term = source.readString();
    count = source.readInt();
  }

  public String getTerm() {
    return term;
  }

  public void setTerm(String term) {
    this.term = term;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
