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
public class NavigationTree implements Parcelable {
  @SerializedName("path")
  private String             path;
  @SerializedName("siblings")
  private ArrayList<Sibling> siblings;

  public static final Creator<NavigationTree> CREATOR;

  static {
    CREATOR = new Creator<NavigationTree>() {

      @Override
      public NavigationTree createFromParcel(Parcel source) {
        return new NavigationTree(source);
      }

      @Override
      public NavigationTree[] newArray(int size) {
        return new NavigationTree[size];
      }
    };
  }

  public NavigationTree() {
    siblings = new ArrayList<>();
  }

  private NavigationTree(Parcel source) {
    this();
    readFromParcel(source);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(path);
    dest.writeTypedList(siblings);
  }

  private void readFromParcel(Parcel source) {
    path = source.readString();
    source.readTypedList(siblings, Sibling.CREATOR);
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public ArrayList<Sibling> getSiblings() {
    return siblings;
  }

  public void setSiblings(ArrayList<Sibling> siblings) {
    this.siblings = siblings;
  }
}
