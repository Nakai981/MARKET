package com.phan.market.entity;

public class ImpCouponDetail {
    private int id;
    private int idCoupon;
    private int count;
    private float price;
    private String idShipment;
    private String nameShipment;
    private int idSupplier;
    private String nameSupplier;

    public ImpCouponDetail() {
    }

    public ImpCouponDetail(int idCoupon, int count, float price, String idShipment, int idSupplier) {
        this.idCoupon = idCoupon;
        this.count = count;
        this.price = price;
        this.idShipment = idShipment;
        this.idSupplier = idSupplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCoupon() {
        return idCoupon;
    }

    public void setIdCoupon(int idCoupon) {
        this.idCoupon = idCoupon;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIdShipment() {
        return idShipment;
    }

    public void setIdShipment(String idShipment) {
        this.idShipment = idShipment;
    }

    public String getNameShipment() {
        return nameShipment;
    }

    public void setNameShipment(String nameShipment) {
        this.nameShipment = nameShipment;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public ImpCouponDetail(int id, int idCoupon, int count, float price, String idShipment, String nameShipment, int idSupplier, String nameSupplier) {
        this.id = id;
        this.idCoupon = idCoupon;
        this.count = count;
        this.price = price;
        this.idShipment = idShipment;
        this.nameShipment = nameShipment;
        this.idSupplier = idSupplier;
        this.nameSupplier = nameSupplier;
    }
}
