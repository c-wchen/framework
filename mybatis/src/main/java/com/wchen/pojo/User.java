package com.wchen.pojo;

public class User {
    private Integer userId;
    private String userName;
    private String password;
    private Integer age;

    public User() {
    }

//    public User(Integer userId, String userName, String password, Integer age) {
//        this.userId = userId;
//        this.userName = userName;
//        this.password = password;
//        this.age = age;
//    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
