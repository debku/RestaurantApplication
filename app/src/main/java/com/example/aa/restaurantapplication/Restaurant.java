package com.example.aa.restaurantapplication;

/**
 * Created by aa on 26-02-2018.
 */

public class Restaurant {

    private String product;
    private String vicinity;
    private String customer;
    private String open;
    private float rating;

    public String getProduct(){
        return product;
    }

    public void setProduct(String product){
        this.product=product;
    }
    public String getVicinity(){
        return vicinity;
    }

    public void setVicinity(String vicinity){
        this.vicinity=vicinity;
    }
    public String getCustomer(){
        return customer;
    }

    public void setCustomer(String customer){
        this.customer=customer;
    }
    public String getOpen(){
        return open;
    }

    public void setOpen(String open){
        this.open=open;
    }
    public float getRating(){
        return rating;
    }

    public void setRating(float rating){
        this.rating=rating;
    }

}
