package com.android.jjnunogarcia.smartsearch.model.jsonparsing;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * User: jesus
 * Date: 05/03/15
 *
 * @author j.nuno@klara.com
 */
public class Location implements Parcelable {
  private ArrayList<Float> coordinates;

  public static final Creator<Location> CREATOR;

  static {
    CREATOR = new Creator<Location>() {

      @Override
      public Location createFromParcel(Parcel source) {
        return new Location(source);
      }

      @Override
      public Location[] newArray(int size) {
        return new Location[size];
      }
    };
  }

  public Location() {
    coordinates = new ArrayList<>();
  }

  private Location(Parcel source) {
    this();
    readFromParcel(source);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeList(coordinates);
  }

  private void readFromParcel(Parcel source) {
    source.readList(coordinates, Float.class.getClassLoader());
  }

  public ArrayList<Float> getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(ArrayList<Float> coordinates) {
    this.coordinates = coordinates;
  }
}
