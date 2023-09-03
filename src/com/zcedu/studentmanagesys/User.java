package com.zcedu.studentmanagesys;

public class User {
    private String
            user_id,
            user_name,
            password,
            phoneNum;

    public User(String user_id, String user_name, String password, String phoneNum) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.phoneNum = phoneNum;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
