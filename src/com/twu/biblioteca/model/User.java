package com.twu.biblioteca.model;

public class User {
    private String id;
    private String name;
    private String password;
    private String phone;
    private String email;

    public User( String id,String name,String password,String phone,String email){
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return this.password;
    }

    public String getPhone(){
        return this.phone;
    }

    public String getEmail(){
        return this.email;
    }
}
