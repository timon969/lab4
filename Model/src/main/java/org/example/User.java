package org.example;

public class User {
    private String userName;
    private String password;

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String newUserName){
        userName = newUserName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String newPassword){
        password = newPassword;
    }

}
