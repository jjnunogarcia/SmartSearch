package com.android.jjnunogarcia.smartsearch.model.jsonparsing;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * User: jesus
 * Date: 05/03/15
 *
 * @author jjnunogarcia@gmail.com
 */
public class IndexableAttributes implements Parcelable {
  private ArrayList<ArrayList<String>> artDerTasche;
  private ArrayList<ArrayList<String>> produktFarbe;
  private ArrayList<ArrayList<String>> markenkompatibilitaet;
  private ArrayList<ArrayList<String>> kompatibilitaet;
  private ArrayList<ArrayList<String>> schutzfunktion;
  private ArrayList<ArrayList<String>> anzahl;

  public static final Creator<IndexableAttributes> CREATOR;

  static {
    CREATOR = new Creator<IndexableAttributes>() {

      @Override
      public IndexableAttributes createFromParcel(Parcel source) {
        return new IndexableAttributes(source);
      }

      @Override
      public IndexableAttributes[] newArray(int size) {
        return new IndexableAttributes[size];
      }
    };
  }

  public IndexableAttributes() {
    artDerTasche = new ArrayList<>();
    produktFarbe = new ArrayList<>();
    markenkompatibilitaet = new ArrayList<>();
    kompatibilitaet = new ArrayList<>();
    schutzfunktion = new ArrayList<>();
    anzahl = new ArrayList<>();
  }

  private IndexableAttributes(Parcel source) {
    this();
    readFromParcel(source);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeList(artDerTasche);
    dest.writeList(produktFarbe);
    dest.writeList(markenkompatibilitaet);
    dest.writeList(kompatibilitaet);
    dest.writeList(schutzfunktion);
    dest.writeList(anzahl);
  }

  private void readFromParcel(Parcel source) {
    source.readList(artDerTasche, String.class.getClassLoader());
    source.readList(produktFarbe, String.class.getClassLoader());
    source.readList(markenkompatibilitaet, String.class.getClassLoader());
    source.readList(kompatibilitaet, String.class.getClassLoader());
    source.readList(schutzfunktion, String.class.getClassLoader());
    source.readList(anzahl, String.class.getClassLoader());
  }

  public ArrayList<ArrayList<String>> getArtDerTasche() {
    return artDerTasche;
  }

  public void setArtDerTasche(ArrayList<ArrayList<String>> artDerTasche) {
    this.artDerTasche = artDerTasche;
  }

  public ArrayList<ArrayList<String>> getProduktFarbe() {
    return produktFarbe;
  }

  public void setProduktFarbe(ArrayList<ArrayList<String>> produktFarbe) {
    this.produktFarbe = produktFarbe;
  }

  public ArrayList<ArrayList<String>> getMarkenkompatibilitaet() {
    return markenkompatibilitaet;
  }

  public void setMarkenkompatibilitaet(ArrayList<ArrayList<String>> markenkompatibilitaet) {
    this.markenkompatibilitaet = markenkompatibilitaet;
  }

  public ArrayList<ArrayList<String>> getKompatibilitaet() {
    return kompatibilitaet;
  }

  public void setKompatibilitaet(ArrayList<ArrayList<String>> kompatibilitaet) {
    this.kompatibilitaet = kompatibilitaet;
  }

  public ArrayList<ArrayList<String>> getSchutzfunktion() {
    return schutzfunktion;
  }

  public void setSchutzfunktion(ArrayList<ArrayList<String>> schutzfunktion) {
    this.schutzfunktion = schutzfunktion;
  }

  public ArrayList<ArrayList<String>> getAnzahl() {
    return anzahl;
  }

  public void setAnzahl(ArrayList<ArrayList<String>> anzahl) {
    this.anzahl = anzahl;
  }
}
