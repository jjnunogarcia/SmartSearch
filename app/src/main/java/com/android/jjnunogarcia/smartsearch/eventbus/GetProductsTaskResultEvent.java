package com.android.jjnunogarcia.smartsearch.eventbus;

import com.android.jjnunogarcia.smartsearch.model.jsonparsing.ProductsResponse;

/**
 * User: jesus
 * Date: 06/03/15
 *
 * @author jjnunogarcia@gmail.com
 */
public class GetProductsTaskResultEvent {
  private int              serverResponse;
  private String           serverMessage;
  private ProductsResponse productsResponse;

  public GetProductsTaskResultEvent(int serverResponse) {
    this.serverResponse = serverResponse;
  }

  public int getServerResponse() {
    return serverResponse;
  }

  public void setServerResponse(int serverResponse) {
    this.serverResponse = serverResponse;
  }

  public String getServerMessage() {
    return serverMessage;
  }

  public void setServerMessage(String serverMessage) {
    this.serverMessage = serverMessage;
  }

  public void setProductsResponse(ProductsResponse productsResponse) {
    this.productsResponse = productsResponse;
  }

  public ProductsResponse getProductsResponse() {
    return productsResponse;
  }
}