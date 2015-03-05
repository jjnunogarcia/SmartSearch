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
public class Brand implements Parcelable {
  @SerializedName("_id")
  private String _id;
  @SerializedName("name")
  private String name;
  @SerializedName("slug")
  private String slug;
  @SerializedName("logo")
  private Object logo;

  public static final Creator<Brand> CREATOR;

  static {
    CREATOR = new Creator<Brand>() {

      @Override
      public Brand createFromParcel(Parcel source) {
        return new Brand(source);
      }

      @Override
      public Brand[] newArray(int size) {
        return new Brand[size];
      }
    };
  }

  public Brand() {}

  private Brand(Parcel source) {
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
    dest.writeString(slug);
    dest.writeValue(logo);
  }

  private void readFromParcel(Parcel source) {
    _id = source.readString();
    name = source.readString();
    slug = source.readString();
    logo = source.readValue(Object.class.getClassLoader());
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

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public Object getLogo() {
    return logo;
  }

  public void setLogo(Object logo) {
    this.logo = logo;
  }
}
