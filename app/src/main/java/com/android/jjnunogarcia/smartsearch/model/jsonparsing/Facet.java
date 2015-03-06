package com.android.jjnunogarcia.smartsearch.model.jsonparsing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * User: jesus
 * Date: 05/03/15
 *
 * @author jjnunogarcia@gmail.com
 */
public class Facet implements Parcelable {
  @SerializedName("_type")
  private String          _type;
  @SerializedName("missing")
  private int             missing;
  @SerializedName("total")
  private int             total;
  @SerializedName("other")
  private int             other;
  @SerializedName("terms")
  private ArrayList<Term> terms;

  public static final Creator<Facet> CREATOR;

  static {
    CREATOR = new Creator<Facet>() {

      @Override
      public Facet createFromParcel(Parcel source) {
        return new Facet(source);
      }

      @Override
      public Facet[] newArray(int size) {
        return new Facet[size];
      }
    };
  }

  public Facet() {
    terms = new ArrayList<>();
  }

  private Facet(Parcel source) {
    this();
    readFromParcel(source);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(_type);
    dest.writeInt(missing);
    dest.writeInt(total);
    dest.writeInt(other);
    dest.writeTypedList(terms);
  }

  private void readFromParcel(Parcel source) {
    _type = source.readString();
    missing = source.readInt();
    total = source.readInt();
    other = source.readInt();
    source.readTypedList(terms, Term.CREATOR);
  }

  public String get_type() {
    return _type;
  }

  public void set_type(String _type) {
    this._type = _type;
  }

  public int getMissing() {
    return missing;
  }

  public void setMissing(int missing) {
    this.missing = missing;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getOther() {
    return other;
  }

  public void setOther(int other) {
    this.other = other;
  }

  public ArrayList<Term> getTerms() {
    return terms;
  }

  public void setTerms(ArrayList<Term> terms) {
    this.terms = terms;
  }
}
