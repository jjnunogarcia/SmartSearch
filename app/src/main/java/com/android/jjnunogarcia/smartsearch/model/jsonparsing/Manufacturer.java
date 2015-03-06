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
public class Manufacturer implements Parcelable {
  @SerializedName("_id")
  private Id     _id;
  @SerializedName("created_at")
  private String createdAt;
  @SerializedName("name")
  private String name;
  @SerializedName("updated_at")
  private String updatedAt;

  public static final Creator<Manufacturer> CREATOR;

  static {
    CREATOR = new Creator<Manufacturer>() {

      @Override
      public Manufacturer createFromParcel(Parcel source) {
        return new Manufacturer(source);
      }

      @Override
      public Manufacturer[] newArray(int size) {
        return new Manufacturer[size];
      }
    };
  }

  public Manufacturer() {}

  private Manufacturer(Parcel source) {
    this();
    readFromParcel(source);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeParcelable(_id, flags);
    dest.writeString(createdAt);
    dest.writeString(name);
    dest.writeString(updatedAt);
  }

  private void readFromParcel(Parcel source) {
    _id = source.readParcelable(Id.class.getClassLoader());
    createdAt = source.readString();
    name = source.readString();
    updatedAt = source.readString();
  }

  public Id get_id() {
    return _id;
  }

  public void set_id(Id _id) {
    this._id = _id;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }
}
