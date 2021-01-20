package com.phan.market.entity;

public class ExpiryDate {
    private String id;
    private String startDate;
    private String expiryDate;
    private String nameItem;
    private int count;
    private String unit;
    private float price;

    public ExpiryDate(String id, String startDate, String expiryDate, String nameItem, int count, float price) {
        this.id = id;
        this.startDate = startDate;
        this.expiryDate = expiryDate;
        this.nameItem = nameItem;
        this.count = count;
        this.price = price;
    }

    public ExpiryDate(String nameItem, String unit) {
        this.nameItem = nameItem;
        this.unit = unit;
    }

    public ExpiryDate(String id, String expiryDate, String nameItem, int count, String unit, float price) {
        this.id = id;
        this.expiryDate = expiryDate;
        this.nameItem = nameItem;
        this.count = count;
        this.unit = unit;
        this.price = price;
    }

    public ExpiryDate() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
