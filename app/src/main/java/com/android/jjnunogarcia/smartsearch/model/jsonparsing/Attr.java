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
public class Attr implements Parcelable {
  @SerializedName("_id")
  private String _id;
  @SerializedName("name")
  private String name;
  @SerializedName("raw")
  private String raw;
  @SerializedName("value")
  private String value;

  public static final Creator<Attr> CREATOR;

  static {
    CREATOR = new Creator<Attr>() {

      @Override
      public Attr createFromParcel(Parcel source) {
        return new Attr(source);
      }

      @Override
      public Attr[] newArray(int size) {
        return new Attr[size];
      }
    };
  }

  public Attr() {}

  private Attr(Parcel source) {
    this();
    readFromParcel(source);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(_id);
    dest.writeString(name);
    dest.writeString(raw);
    dest.writeString(value);
  }

  private void readFromParcel(Parcel source) {
    _id = source.readString();
    name = source.readString();
    raw = source.readString();
    value = source.readString();
  }

  public String get_id() {
    return _id;
  }

  public void set_id(String _id) {
    this._id = _id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRaw() {
    return raw;
  }

  public void setRaw(String raw) {
    this.raw = raw;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
