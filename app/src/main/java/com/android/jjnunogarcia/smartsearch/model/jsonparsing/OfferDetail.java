package com.android.jjnunogarcia.smartsearch.model.jsonparsing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * User: jesus
 * Date: 05/03/15
 *
 * @author j.nuno@klara.com
 */
public class OfferDetail implements Parcelable {
  @SerializedName("geohash")
  private String                      geoHash;
  @SerializedName("min_price")
  private float                       minPrice;
  @SerializedName("max_price")
  private float                       maxPrice;
  @SerializedName("offers_in_range")
  private int                         offersInRange;
  @SerializedName("offer_locations")
  private ArrayList<ArrayList<Float>> offerLocations;

  public static final Creator<OfferDetail> CREATOR;

  static {
    CREATOR = new Creator<OfferDetail>() {

      @Override
      public OfferDetail createFromParcel(Parcel source) {
        return new OfferDetail(source);
      }

      @Override
      public OfferDetail[] newArray(int size) {
        return new OfferDetail[size];
      }
    };
  }

  public OfferDetail() {
    offerLocations = new ArrayList<>();
  }

  private OfferDetail(Parcel source) {
    this();
    readFromParcel(source);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(geoHash);
    dest.writeFloat(minPrice);
    dest.writeFloat(maxPrice);
    dest.writeInt(offersInRange);
    dest.writeList(offerLocations);
  }

  private void readFromParcel(Parcel source) {
    geoHash = source.readString();
    minPrice = source.readFloat();
    maxPrice = source.readFloat();
    offersInRange = source.readInt();
    source.readList(offerLocations, ArrayList.class.getClassLoader());
  }

  public String getGeoHash() {
    return geoHash;
  }

  public void setGeoHash(String geoHash) {
    this.geoHash = geoHash;
  }

  public float getMinPrice() {
    return minPrice;
  }

  public void setMinPrice(float minPrice) {
    this.minPrice = minPrice;
  }

  public float getMaxPrice() {
    return maxPrice;
  }

  public void setMaxPrice(float maxPrice) {
    this.maxPrice = maxPrice;
  }

  public int getOffersInRange() {
    return offersInRange;
  }

  public void setOffersInRange(int offersInRange) {
    this.offersInRange = offersInRange;
  }

  public ArrayList<ArrayList<Float>> getOfferLocations() {
    return offerLocations;
  }

  public void setOfferLocations(ArrayList<ArrayList<Float>> offerLocations) {
    this.offerLocations = offerLocations;
  }
}
