package com.phan.market.entity;

public class Shipment {
    private String id;
    private int count;
    private String expiryDate;
    private float price;
    private String idItem;

    public Shipment(String id, int count, String expiryDate, float price, String idItem) {
        this.id = id;
        this.count = count;
        this.expiryDate = expiryDate;
        this.price = price;
        this.idItem = idItem;
    }

    public Shipment(String id, String expiryDate, float price) {
        this.id = id;
        this.expiryDate = expiryDate;
        this.price = price;
    }

    public Shipment() {
    }

    public Shipment(String id, String expiryDate, float price, String idItem) {
        this.id = id;
        this.expiryDate = expiryDate;
        this.price = price;
        this.idItem = idItem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }
}
