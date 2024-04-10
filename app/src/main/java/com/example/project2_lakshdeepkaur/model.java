package com.example.project2_lakshdeepkaur;

public class model {String Title, Price, Description, purl;
model(){

}
    public model(String title, double price, String description, String purl) {
        this.Title = title;
        this.Price = String.valueOf(price);
        this.Description = description;
        this.purl = purl;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        this.Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
