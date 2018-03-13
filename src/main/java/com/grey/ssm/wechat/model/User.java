package com.grey.ssm.wechat.model;

import java.util.Date;

public class User{
    private int UID;
    private String userName;
    private String nickName;
    private String passWord;
    private int sex;
    private Date birthday;
    private int age;
    private String email;
    private String telephone;
    private String avatar;

    public User() {
    }

    public User(int UID, String userName, String nickName, String passWord, int sex, Date birthday, int age, String email, String telephone, String avatar) {
        this.UID = UID;
        this.userName = userName;
        this.nickName = nickName;
        this.passWord = passWord;
        this.sex = sex;
        this.birthday = birthday;
        this.age = age;
        this.email = email;
        this.telephone = telephone;
        this.avatar = avatar;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "UID=" + UID +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
