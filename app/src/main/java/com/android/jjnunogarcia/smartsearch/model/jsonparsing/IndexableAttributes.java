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
public class IndexableAttributes implements Parcelable {
  private ArrayList<IndexableAttribute> artDerTasche;
  private ArrayList<IndexableAttribute> produktFarbe;
  private ArrayList<IndexableAttribute> markenkompatibilitaet;
  private ArrayList<IndexableAttribute> kompatibilitaet;
  private ArrayList<IndexableAttribute> schutzfunktion;
  private ArrayList<IndexableAttribute> anzahl;

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
    dest.writeTypedList(artDerTasche);
    dest.writeTypedList(produktFarbe);
    dest.writeTypedList(markenkompatibilitaet);
    dest.writeTypedList(kompatibilitaet);
    dest.writeTypedList(schutzfunktion);
    dest.writeTypedList(anzahl);
  }

  private void readFromParcel(Parcel source) {
    source.readTypedList(artDerTasche, IndexableAttribute.CREATOR);
    source.readTypedList(produktFarbe, IndexableAttribute.CREATOR);
    source.readTypedList(markenkompatibilitaet, IndexableAttribute.CREATOR);
    source.readTypedList(kompatibilitaet, IndexableAttribute.CREATOR);
    source.readTypedList(schutzfunktion, IndexableAttribute.CREATOR);
    source.readTypedList(anzahl, IndexableAttribute.CREATOR);
  }

  public ArrayList<IndexableAttribute> getArtDerTasche() {
    return artDerTasche;
  }

  public void setArtDerTasche(ArrayList<IndexableAttribute> artDerTasche) {
    this.artDerTasche = artDerTasche;
  }

  public ArrayList<IndexableAttribute> getProduktFarbe() {
    return produktFarbe;
  }

  public void setProduktFarbe(ArrayList<IndexableAttribute> produktFarbe) {
    this.produktFarbe = produktFarbe;
  }

  public ArrayList<IndexableAttribute> getMarkenkompatibilitaet() {
    return markenkompatibilitaet;
  }

  public void setMarkenkompatibilitaet(ArrayList<IndexableAttribute> markenkompatibilitaet) {
    this.markenkompatibilitaet = markenkompatibilitaet;
  }

  public ArrayList<IndexableAttribute> getKompatibilitaet() {
    return kompatibilitaet;
  }

  public void setKompatibilitaet(ArrayList<IndexableAttribute> kompatibilitaet) {
    this.kompatibilitaet = kompatibilitaet;
  }

  public ArrayList<IndexableAttribute> getSchutzfunktion() {
    return schutzfunktion;
  }

  public void setSchutzfunktion(ArrayList<IndexableAttribute> schutzfunktion) {
    this.schutzfunktion = schutzfunktion;
  }

  public ArrayList<IndexableAttribute> getAnzahl() {
    return anzahl;
  }

  public void setAnzahl(ArrayList<IndexableAttribute> anzahl) {
    this.anzahl = anzahl;
  }
}
