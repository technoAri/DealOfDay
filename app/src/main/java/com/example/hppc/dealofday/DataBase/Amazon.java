package com.example.hppc.dealofday.DataBase;

/**
 * Created by HP PC on 11/24/2016.
 */
public class Amazon {

    //name and address string
    private String prodName;
    private String price;

    public Amazon() {
      /*Blank default constructor essential for Firebase*/
    }
    //Getters and setters
    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
