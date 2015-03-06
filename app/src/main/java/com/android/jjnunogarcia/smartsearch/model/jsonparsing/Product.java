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
public class Product implements Parcelable {
  @SerializedName("_index")
  private String                      _index;
  @SerializedName("_type")
  private String                      _type;
  @SerializedName("_id")
  private String                      _id;
  @SerializedName("_score")
  private float                       _score;
  @SerializedName("indexable_name")
  private String                      indexableName;
  @SerializedName("description")
  private String                      description;
  @SerializedName("relevant_counter")
  private int                         relevantCounter;
  @SerializedName("min_price")
  private MinPrice                    minPrice;
  @SerializedName("max_price")
  private String                      maxPrice;
  @SerializedName("category_ids")
  private ArrayList<String>           categoryIds;
  @SerializedName("category_slugs")
  private ArrayList<String>           categorySlugs;
  @SerializedName("location")
  private ArrayList<ArrayList<Float>> locations;
  @SerializedName("brand_name")
  private String                      brandName;
  @SerializedName("brand_slugs")
  private ArrayList<String>           brandSlugs;
  @SerializedName("brand_name_slug")
  private String                      brandNameSlug;
  @SerializedName("visible_results")
  private boolean                     visibleResults;
  @SerializedName("indexable_attrs")
  private IndexableAttributes         indexableAttributes;
  @SerializedName("top")
  private boolean                     top;
  @SerializedName("offer_details")
  private ArrayList<OfferDetail>      offerDetails;
  @SerializedName("attributes")
  private ArrayList<String>           attributes;
  @SerializedName("name")
  private String                      name;
  @SerializedName("slug")
  private String                      slug;
  @SerializedName("extended_description")
  private String                      extendedDescription;
  @SerializedName("gtin")
  private String                      gtin;
  @SerializedName("gpc")
  private int                         gpc;
  @SerializedName("mpn")
  private String                      mpn;
  @SerializedName("ran")
  private String                      ran;
  @SerializedName("active")
  private boolean                     active;
  @SerializedName("brand")
  private Brand                       brand;
  @SerializedName("manufacturer")
  private Manufacturer                manufacturer;
  @SerializedName("images")
  private ArrayList<Image>            images;
  @SerializedName("attrs")
  private ArrayList<Attr>             attrs;
  @SerializedName("created_at")
  private String                      createdAt;
  @SerializedName("updated_at")
  private String                      updatedAt;
  @SerializedName("id")
  private String                      id;
  @SerializedName("min_distance")
  private float                       minDistance;

  public static final Creator<Product> CREATOR;

  static {
    CREATOR = new Creator<Product>() {

      @Override
      public Product createFromParcel(Parcel source) {
        return new Product(source);
      }

      @Override
      public Product[] newArray(int size) {
        return new Product[size];
      }
    };
  }

  public Product() {
    categoryIds = new ArrayList<>();
    categorySlugs = new ArrayList<>();
    locations = new ArrayList<>();
    brandSlugs = new ArrayList<>();
    offerDetails = new ArrayList<>();
    attributes = new ArrayList<>();
    images = new ArrayList<>();
    attrs = new ArrayList<>();
  }

  private Product(Parcel source) {
    this();
    readFromParcel(source);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(_index);
    dest.writeString(_type);
    dest.writeString(_id);
    dest.writeFloat(_score);
    dest.writeString(indexableName);
    dest.writeString(description);
    dest.writeInt(relevantCounter);
    dest.writeParcelable(minPrice, flags);
    dest.writeString(maxPrice);
    dest.writeList(categoryIds);
    dest.writeList(categorySlugs);
    dest.writeList(locations);
    dest.writeString(brandName);
    dest.writeList(brandSlugs);
    dest.writeString(brandNameSlug);
    dest.writeByte((byte) (visibleResults ? 1 : 0));
    dest.writeParcelable(indexableAttributes, flags);
    dest.writeByte((byte) (top ? 1 : 0));
    dest.writeTypedList(offerDetails);
    dest.writeList(attributes);
    dest.writeString(name);
    dest.writeString(slug);
    dest.writeString(extendedDescription);
    dest.writeString(gtin);
    dest.writeInt(gpc);
    dest.writeString(mpn);
    dest.writeString(ran);
    dest.writeByte((byte) (active ? 1 : 0));
    dest.writeParcelable(brand, flags);
    dest.writeParcelable(manufacturer, flags);
    dest.writeTypedList(images);
    dest.writeTypedList(attrs);
    dest.writeString(createdAt);
    dest.writeString(updatedAt);
    dest.writeString(id);
    dest.writeFloat(minDistance);
  }

  private void readFromParcel(Parcel source) {
    _index = source.readString();
    _type = source.readString();
    _id = source.readString();
    _score = source.readFloat();
    indexableName = source.readString();
    description = source.readString();
    relevantCounter = source.readInt();
    minPrice = source.readParcelable(MinPrice.class.getClassLoader());
    maxPrice = source.readString();
    source.readList(categoryIds, String.class.getClassLoader());
    source.readList(categorySlugs, String.class.getClassLoader());
    source.readList(locations, ArrayList.class.getClassLoader());
    brandName = source.readString();
    source.readList(brandSlugs, String.class.getClassLoader());
    brandNameSlug = source.readString();
    visibleResults = source.readByte() != 0;
    indexableAttributes = source.readParcelable(IndexableAttributes.class.getClassLoader());
    top = source.readByte() != 0;
    source.readTypedList(offerDetails, OfferDetail.CREATOR);
    source.readList(attributes, String.class.getClassLoader());
    name = source.readString();
    slug = source.readString();
    extendedDescription = source.readString();
    gtin = source.readString();
    gpc = source.readInt();
    mpn = source.readString();
    ran = source.readString();
    active = source.readByte() != 0;
    brand = source.readParcelable(Brand.class.getClassLoader());
    manufacturer = source.readParcelable(Manufacturer.class.getClassLoader());
    source.readTypedList(images, Image.CREATOR);
    source.readTypedList(attrs, Attr.CREATOR);
    createdAt = source.readString();
    updatedAt = source.readString();
    id = source.readString();
    minDistance = source.readFloat();
  }

  public String get_index() {
    return _index;
  }

  public void set_index(String _index) {
    this._index = _index;
  }

  public String get_type() {
    return _type;
  }

  public void set_type(String _type) {
    this._type = _type;
  }

  public String get_id() {
    return _id;
  }

  public void set_id(String _id) {
    this._id = _id;
  }

  public float get_score() {
    return _score;
  }

  public void set_score(float _score) {
    this._score = _score;
  }

  public String getIndexableName() {
    return indexableName;
  }

  public void setIndexableName(String indexableName) {
    this.indexableName = indexableName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getRelevantCounter() {
    return relevantCounter;
  }

  public void setRelevantCounter(int relevantCounter) {
    this.relevantCounter = relevantCounter;
  }

  public MinPrice getMinPrice() {
    return minPrice;
  }

  public void setMinPrice(MinPrice minPrice) {
    this.minPrice = minPrice;
  }

  public String getMaxPrice() {
    return maxPrice;
  }

  public void setMaxPrice(String maxPrice) {
    this.maxPrice = maxPrice;
  }

  public ArrayList<String> getCategoryIds() {
    return categoryIds;
  }

  public void setCategoryIds(ArrayList<String> categoryIds) {
    this.categoryIds = categoryIds;
  }

  public ArrayList<String> getCategorySlugs() {
    return categorySlugs;
  }

  public void setCategorySlugs(ArrayList<String> categorySlugs) {
    this.categorySlugs = categorySlugs;
  }

  public ArrayList<ArrayList<Float>> getLocations() {
    return locations;
  }

  public void setLocations(ArrayList<ArrayList<Float>> locations) {
    this.locations = locations;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public ArrayList<String> getBrandSlugs() {
    return brandSlugs;
  }

  public void setBrandSlugs(ArrayList<String> brandSlugs) {
    this.brandSlugs = brandSlugs;
  }

  public String getBrandNameSlug() {
    return brandNameSlug;
  }

  public void setBrandNameSlug(String brandNameSlug) {
    this.brandNameSlug = brandNameSlug;
  }

  public boolean isVisibleResults() {
    return visibleResults;
  }

  public void setVisibleResults(boolean visibleResults) {
    this.visibleResults = visibleResults;
  }

  public IndexableAttributes getIndexableAttributes() {
    return indexableAttributes;
  }

  public void setIndexableAttributes(IndexableAttributes indexableAttributes) {
    this.indexableAttributes = indexableAttributes;
  }

  public boolean isTop() {
    return top;
  }

  public void setTop(boolean top) {
    this.top = top;
  }

  public ArrayList<OfferDetail> getOfferDetail() {
    return offerDetails;
  }

  public void setOfferDetail(ArrayList<OfferDetail> offerDetails) {
    this.offerDetails = offerDetails;
  }

  public ArrayList<String> getAttributes() {
    return attributes;
  }

  public void setAttributes(ArrayList<String> attributes) {
    this.attributes = attributes;
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

  public String getExtendedDescription() {
    return extendedDescription;
  }

  public void setExtendedDescription(String extendedDescription) {
    this.extendedDescription = extendedDescription;
  }

  public String getGtin() {
    return gtin;
  }

  public void setGtin(String gtin) {
    this.gtin = gtin;
  }

  public int getGpc() {
    return gpc;
  }

  public void setGpc(int gpc) {
    this.gpc = gpc;
  }

  public String getMpn() {
    return mpn;
  }

  public void setMpn(String mpn) {
    this.mpn = mpn;
  }

  public String getRan() {
    return ran;
  }

  public void setRan(String ran) {
    this.ran = ran;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public Manufacturer getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(Manufacturer manufacturer) {
    this.manufacturer = manufacturer;
  }

  public ArrayList<Image> getImages() {
    return images;
  }

  public void setImages(ArrayList<Image> images) {
    this.images = images;
  }

  public ArrayList<Attr> getAttrs() {
    return attrs;
  }

  public void setAttrs(ArrayList<Attr> attrs) {
    this.attrs = attrs;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public float getMinDistance() {
    return minDistance;
  }

  public void setMinDistance(float minDistance) {
    this.minDistance = minDistance;
  }
}
