package com.phan.market.entity;


public class Employee {
    private int id;
    private String name;
    private int gender;
    private Long card;
    private Long phone;
    private String address;
    private String user;
    private String pass;
    private int idPosition;

    public Employee(int id, String name, int gender, Long card, Long phone, String address, String user, String pass, int idPosition) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.card = card;
        this.phone = phone;
        this.address = address;
        this.user = user;
        this.pass = pass;
        this.idPosition = idPosition;
    }

    public Employee(String name, int gender, Long card, Long phone, String address, String user, String pass, int idPosition) {
        this.name = name;
        this.gender = gender;
        this.card = card;
        this.phone = phone;
        this.address = address;
        this.user = user;
        this.pass = pass;
        this.idPosition = idPosition;
    }

    public Employee(int id, String name, int gender, Long card, Long phone, String address, String user, String pass) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.card = card;
        this.phone = phone;
        this.address = address;
        this.user = user;
        this.pass = pass;
    }

    public Employee(String name, int gender, Long card, Long phone, String address, String user, String pass) {
        this.name = name;
        this.gender = gender;
        this.card = card;
        this.phone = phone;
        this.address = address;
        this.user = user;
        this.pass = pass;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Long getCard() {
        return card;
    }

    public void setCard(Long card) {
        this.card = card;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }
}
