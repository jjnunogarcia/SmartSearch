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
public class Sibling implements Parcelable {
  @SerializedName("_id")
  private String            _id;
  @SerializedName("name")
  private String            name;
  @SerializedName("active")
  private boolean           active;
  @SerializedName("parent_id")
  private String            parentId;
  @SerializedName("image")
  private String            image;
  @SerializedName("slug")
  private String            slug;
  @SerializedName("level")
  private int               level;
  @SerializedName("similar")
  private ArrayList<Object> similar;
  @SerializedName("external_id")
  private String            externalId;
  @SerializedName("products")
  private int               products;

  public static final Creator<Sibling> CREATOR;

  static {
    CREATOR = new Creator<Sibling>() {

      @Override
      public Sibling createFromParcel(Parcel source) {
        return new Sibling(source);
      }

      @Override
      public Sibling[] newArray(int size) {
        return new Sibling[size];
      }
    };
  }

  public Sibling() {
    similar = new ArrayList<>();
  }

  private Sibling(Parcel source) {
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
    dest.writeByte((byte) (active ? 1 : 0));
    dest.writeString(parentId);
    dest.writeString(image);
    dest.writeString(slug);
    dest.writeInt(level);
    dest.writeList(similar);
    dest.writeString(externalId);
    dest.writeInt(products);
  }

  private void readFromParcel(Parcel source) {
    _id = source.readString();
    name = source.readString();
    active = source.readByte() != 0;
    parentId = source.readString();
    image = source.readString();
    slug = source.readString();
    level = source.readInt();
    source.readList(similar, String.class.getClassLoader());
    externalId = source.readString();
    products = source.readInt();
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

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public ArrayList<Object> getSimilar() {
    return similar;
  }

  public void setSimilar(ArrayList<Object> similar) {
    this.similar = similar;
  }

  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public int getProducts() {
    return products;
  }

  public void setProducts(int products) {
    this.products = products;
  }
}
