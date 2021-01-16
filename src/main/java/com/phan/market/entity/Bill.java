package com.phan.market.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bill {
    private int id;
    private String name_employee;
    private String date;
    private String name_item;
    private int count;
    private float price;
    private float sum_price;

    public Bill(int id, String name_employee, String date) {
        this.id = id;
        this.name_employee = name_employee;
        this.date = date;
    }

    public Bill(String name_item, int count, float price, float sum_price) {
        this.name_item = name_item;
        this.count = count;
        this.price = price;
        this.sum_price = sum_price;
    }

    public Bill(int id, String name_employee, String date, String name_item, int count, float price, float sum_price) {
        this.id = id;
        this.name_employee = name_employee;
        this.date = date;
        this.name_item = name_item;
        this.count = count;
        this.price = price;
        this.sum_price = sum_price;
    }

    public Bill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_employee() {
        return name_employee;
    }

    public void setName_employee(String name_employee) {
        this.name_employee = name_employee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName_item() {
        return name_item;
    }

    public void setName_item(String name_item) {
        this.name_item = name_item;
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

    public float getSum_price() {
        return sum_price;
    }

    public void setSum_price(float sum_price) {
        this.sum_price = sum_price;
    }

}
