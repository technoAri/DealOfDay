package com.example.hppc.dealofday.DataBase;

/**
 * Created by HP PC on 11/24/2016.
 */
public class CoolpadNote3 {

    //name and address string
    private String amazonPrice;
    private String flipkartPrice;
    private String payTmPrice;

    public CoolpadNote3() {
      /*Blank default constructor essential for Firebase*/
    }
    //Getters and setters
    public String getAmazonPrice() {
        return amazonPrice;
    }

    public void setAmazonPrice(String amazonPrice) {
        this.amazonPrice = amazonPrice;
    }

    public String getFlipkartPrice() {
        return flipkartPrice;
    }

    public void setFlipkartPrice(String flipkartPrice) {
        this.flipkartPrice = flipkartPrice;
    }

    public String getPayTmPrice() {
        return payTmPrice;
    }

    public void setPayTmPrice(String payTmPrice) {
        this.payTmPrice = payTmPrice;
    }

}
