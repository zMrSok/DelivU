package com.example.icyapp.Model;

public class UserModel {
    private String name,password,phone,uid,address;


    public UserModel() {
    }
    public UserModel(String name,String password){
        this.name = name;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.uid = uid;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAddress() {return  address; }

    public void setAddress(String address){this.address = address;}
}
