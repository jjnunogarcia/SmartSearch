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
public class ProductsResponse implements Parcelable {
  @SerializedName("products")
  private ArrayList<Product>     products;
  @SerializedName("facets")
  private Facets                 facets;
  @SerializedName("breadcrumbs")
  private ArrayList<BreadCrumbs> breadCrumbsArrayList;
  @SerializedName("navigation_tree")
  private NavigationTree         navigationTree;
  @SerializedName("filters")
  private Filters                filters;
  @SerializedName("total_entries")
  private int                    totalEntries;
  @SerializedName("min_distance")
  private Object                 minDistance;
  @SerializedName("seo_data")
  private SeoData                seoData;
  @SerializedName("maximum_price")
  private int                    maximumPrice;
  @SerializedName("minimum_price")
  private int                    minimumPrice;

  public static final Creator<ProductsResponse> CREATOR;

  static {
    CREATOR = new Creator<ProductsResponse>() {

      @Override
      public ProductsResponse createFromParcel(Parcel source) {
        return new ProductsResponse(source);
      }

      @Override
      public ProductsResponse[] newArray(int size) {
        return new ProductsResponse[size];
      }
    };
  }

  public ProductsResponse() {
    products = new ArrayList<>();
    breadCrumbsArrayList = new ArrayList<>();
  }

  private ProductsResponse(Parcel source) {
    this();
    readFromParcel(source);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeTypedList(products);
    dest.writeParcelable(facets, flags);
    dest.writeTypedList(breadCrumbsArrayList);
    dest.writeParcelable(navigationTree, flags);
    dest.writeParcelable(filters, flags);
    dest.writeInt(totalEntries);
    dest.writeValue(minDistance);
    dest.writeParcelable(seoData, flags);
    dest.writeInt(maximumPrice);
    dest.writeInt(minimumPrice);
  }

  private void readFromParcel(Parcel source) {
    source.readTypedList(products, Product.CREATOR);
    facets = source.readParcelable(Facets.class.getClassLoader());
    source.readTypedList(breadCrumbsArrayList, BreadCrumbs.CREATOR);
    navigationTree = source.readParcelable(NavigationTree.class.getClassLoader());
    filters = source.readParcelable(Filters.class.getClassLoader());
    totalEntries = source.readInt();
    minDistance = source.readValue(Object.class.getClassLoader());
    seoData = source.readParcelable(SeoData.class.getClassLoader());
    maximumPrice = source.readInt();
    minimumPrice = source.readInt();
  }

  public ArrayList<Product> getProducts() {
    return products;
  }

  public void setProducts(ArrayList<Product> products) {
    this.products = products;
  }

  public Facets getFacets() {
    return facets;
  }

  public void setFacets(Facets facets) {
    this.facets = facets;
  }

  public ArrayList<BreadCrumbs> getBreadCrumbsArrayList() {
    return breadCrumbsArrayList;
  }

  public void setBreadCrumbsArrayList(ArrayList<BreadCrumbs> breadCrumbsArrayList) {
    this.breadCrumbsArrayList = breadCrumbsArrayList;
  }

  public NavigationTree getNavigationTree() {
    return navigationTree;
  }

  public void setNavigationTree(NavigationTree navigationTree) {
    this.navigationTree = navigationTree;
  }

  public Filters getFilters() {
    return filters;
  }

  public void setFilters(Filters filters) {
    this.filters = filters;
  }

  public int getTotalEntries() {
    return totalEntries;
  }

  public void setTotalEntries(int totalEntries) {
    this.totalEntries = totalEntries;
  }

  public Object getMinDistance() {
    return minDistance;
  }

  public void setMinDistance(Object minDistance) {
    this.minDistance = minDistance;
  }

  public SeoData getSeoData() {
    return seoData;
  }

  public void setSeoData(SeoData seoData) {
    this.seoData = seoData;
  }

  public int getMaximumPrice() {
    return maximumPrice;
  }

  public void setMaximumPrice(int maximumPrice) {
    this.maximumPrice = maximumPrice;
  }

  public int getMinimumPrice() {
    return minimumPrice;
  }

  public void setMinimumPrice(int minimumPrice) {
    this.minimumPrice = minimumPrice;
  }
}
