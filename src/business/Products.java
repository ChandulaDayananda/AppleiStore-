/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author chand
 */
public class Products {
    private String  productID;
    private String categoryID;
    private String productName;
    private int productPrice;
    private String ProductSerialNumber;
    private int productQuantity;

    public Products() {
    }

    public Products(String productID, String categoryID, String productName, int productPrice, String ProductSerialNumber, int productQuantity) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.ProductSerialNumber = ProductSerialNumber;
        this.productQuantity = productQuantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductSerialNumber() {
        return ProductSerialNumber;
    }

    public void setProductSerialNumber(String ProductSerialNumber) {
        this.ProductSerialNumber = ProductSerialNumber;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
