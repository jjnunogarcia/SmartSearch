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
public class Image implements Parcelable {
  @SerializedName("_id")
  private String _id;
  @SerializedName("image")
  private String image;
  @SerializedName("large")
  private String large;
  @SerializedName("medium")
  private String medium;
  @SerializedName("thumb")
  private String thumb;
  @SerializedName("checksum")
  private String checkSum;
  @SerializedName("created_at")
  private String createdAt;
  @SerializedName("updated_at")
  private String updatedAt;

  public static final Creator<Image> CREATOR;

  static {
    CREATOR = new Creator<Image>() {

      @Override
      public Image createFromParcel(Parcel source) {
        return new Image(source);
      }

      @Override
      public Image[] newArray(int size) {
        return new Image[size];
      }
    };
  }

  public Image() {}

  private Image(Parcel source) {
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
    dest.writeString(image);
    dest.writeString(large);
    dest.writeString(medium);
    dest.writeString(thumb);
    dest.writeString(checkSum);
    dest.writeString(createdAt);
    dest.writeString(updatedAt);
  }

  private void readFromParcel(Parcel source) {
    _id = source.readString();
    image = source.readString();
    large = source.readString();
    medium = source.readString();
    thumb = source.readString();
    checkSum = source.readString();
    createdAt = source.readString();
    updatedAt = source.readString();
  }

  public String get_id() {
    return _id;
  }

  public void set_id(String _id) {
    this._id = _id;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getLarge() {
    return large;
  }

  public void setLarge(String large) {
    this.large = large;
  }

  public String getMedium() {
    return medium;
  }

  public void setMedium(String medium) {
    this.medium = medium;
  }

  public String getThumb() {
    return thumb;
  }

  public void setThumb(String thumb) {
    this.thumb = thumb;
  }

  public String getCheckSum() {
    return checkSum;
  }

  public void setCheckSum(String checkSum) {
    this.checkSum = checkSum;
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
}
