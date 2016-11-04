package com.company;


public class AdminInfo{
    private String username, password;

    public AdminInfo(){

    }

    public AdminInfo(String username, String password){
        setUsername(username);
        setPassword(password);
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }
}