package com.phan.market.entity;

public class ImportCoupon {
    private int id;
    private String nameSupplier;
    private String date;
    private String nameItem;
    private int count;
    private float priceCoupon;

    public ImportCoupon() {
    }

    public ImportCoupon(int id, String nameSupplier, String date, String nameItem, int count, float priceCoupon) {
        this.id = id;
        this.nameSupplier = nameSupplier;
        this.date = date;
        this.nameItem = nameItem;
        this.count = count;
        this.priceCoupon = priceCoupon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public float getPriceCoupon() {
        return priceCoupon;
    }

    public void setPriceCoupon(float priceCoupon) {
        this.priceCoupon = priceCoupon;
    }
}
