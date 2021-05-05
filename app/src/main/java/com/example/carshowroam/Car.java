package com.example.carshowroam;

public class Car {
    String Maker;
    String Owner;
    String Model;
    String Tel;

    public Car(String maker, String owner, String model, String tel) {
        Maker = maker;
        Owner = owner;
        Model = model;
        Tel = tel;
    }

    public String getMaker() {
        return Maker;
    }

    public void setMaker(String maker) {
        Maker = maker;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }
}
