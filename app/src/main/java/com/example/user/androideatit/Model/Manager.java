package com.example.user.androideatit.Model;

public class Manager {
    private String id;
    private String phone;
    private String name;
//    private String email;
    private String restaurentname;
    private String password;

    public Manager() {
    }

    public Manager(String id, String name, String phone, String restaurentname, String password) {
        this.id= id;
        this.phone = phone;
        this.name = name;
//        this.email = email;
        this.restaurentname = restaurentname;
        this.password = password;
    }



    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

//    public String getEmail() {
//        return email;
//    }

    public String getRestaurentname() {
        return restaurentname;
    }

    public String getPassword() {
        return password;
    }
}
