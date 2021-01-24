package com.phan.market.entity;

public class Inventory {
    private int id;
    private int idDetail;
    private String date;
    private int idEmloyee;
    private String nameEmployee;
    private String idShiment;
    private String nameShiment;
    private int count;
    private int counted;
    private int co;


    public int getCounted() {
        return counted;
    }

    public void setCounted(int counted) {
        this.counted = counted;
    }

    public int getCo() {
        return co;
    }

    public void setCo(int co) {
        this.co = co;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getNameShiment() {
        return nameShiment;
    }

    public void setNameShiment(String nameShiment) {
        this.nameShiment = nameShiment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdEmloyee() {
        return idEmloyee;
    }

    public void setIdEmloyee(int idEmloyee) {
        this.idEmloyee = idEmloyee;
    }

    public String getIdShiment() {
        return idShiment;
    }

    public void setIdShiment(String idShiment) {
        this.idShiment = idShiment;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
