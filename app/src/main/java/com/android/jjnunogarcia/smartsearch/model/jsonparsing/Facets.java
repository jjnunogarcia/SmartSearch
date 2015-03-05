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
public class Facets implements Parcelable {
  @SerializedName("brand_name_slug")
  private Facet brandNameSlug;
  @SerializedName("category_ids")
  private Facet categoryIds;
  @SerializedName("attributes")
  private Facet attributes;
  @SerializedName("brand_name")
  private Facet brandName;

  public static final Creator<Facets> CREATOR;

  static {
    CREATOR = new Creator<Facets>() {

      @Override
      public Facets createFromParcel(Parcel source) {
        return new Facets(source);
      }

      @Override
      public Facets[] newArray(int size) {
        return new Facets[size];
      }
    };
  }

  public Facets() {}

  private Facets(Parcel source) {
    this();
    readFromParcel(source);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeParcelable(brandNameSlug, flags);
    dest.writeParcelable(categoryIds, flags);
    dest.writeParcelable(attributes, flags);
    dest.writeParcelable(brandName, flags);
  }

  private void readFromParcel(Parcel source) {
    brandNameSlug = source.readParcelable(Facets.class.getClassLoader());
    categoryIds = source.readParcelable(Facets.class.getClassLoader());
    attributes = source.readParcelable(Facets.class.getClassLoader());
    brandName = source.readParcelable(Facets.class.getClassLoader());
  }

  public Facet getBrandNameSlug() {
    return brandNameSlug;
  }

  public void setBrandNameSlug(Facet brandNameSlug) {
    this.brandNameSlug = brandNameSlug;
  }

  public Facet getCategoryIds() {
    return categoryIds;
  }

  public void setCategoryIds(Facet categoryIds) {
    this.categoryIds = categoryIds;
  }

  public Facet getAttributes() {
    return attributes;
  }

  public void setAttributes(Facet attributes) {
    this.attributes = attributes;
  }

  public Facet getBrandName() {
    return brandName;
  }

  public void setBrandName(Facet brandName) {
    this.brandName = brandName;
  }
}
