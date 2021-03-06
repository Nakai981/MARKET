package com.phan.market.entity;

public class Item {
    private String id;
    private String name;
    private String unit;

    public Item() {
    }

    public Item(String id, String name, String unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
    }

    public Item(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
