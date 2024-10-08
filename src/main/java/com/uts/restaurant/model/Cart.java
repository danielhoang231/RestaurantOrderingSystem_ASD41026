package com.uts.restaurant.model;

public class Cart {
  //  private int cartItemID;
    private int productID;
    private String customisationRequest;
    private int quantity;

    public Cart(int productID, String customisationRequest, int quantity) {
       // this.cartItemID = cartItemID;
        this.productID = productID;
        this.customisationRequest = customisationRequest;
        this.quantity = quantity;
    }

/*public int getCartItemID() {
        return cartItemID;
    }

    public void setCartItemID(int id) {
        id = cartItemID;
    }
 */
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int id) {
        id = productID;
    }

    public String getCustomisationRequest() {
        return customisationRequest;
    }

    public void setCustomisationRequest(String customisationRequest) {
        this.customisationRequest = customisationRequest;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
