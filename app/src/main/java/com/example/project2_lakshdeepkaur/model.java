package com.example.project2_lakshdeepkaur;

public class model {String title,price, description, purl;
model(){

}
    public model(String title, double price, String description, String purl) {
        this.title = title;
        this.price = String.valueOf(price);
        this.description = description;
        this.purl = purl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
