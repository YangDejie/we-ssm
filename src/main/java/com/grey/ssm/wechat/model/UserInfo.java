package com.grey.ssm.wechat.model;

public class UserInfo  {
    private int UID;
    private String aboutLove;
    private String homeTown;
    private String nowLiveAt;
    private String zodiacSign;
    private String bloodCate;
    private String moto;
    private String constellation;
    private String profession;
    private String company;

    public UserInfo() {
    }

    public UserInfo(int UID, String aboutLove, String homeTown, String nowLiveAt, String zodiacSign, String bloodCate, String moto, String constellation, String profession, String company) {
        this.UID = UID;
        this.aboutLove = aboutLove;
        this.homeTown = homeTown;
        this.nowLiveAt = nowLiveAt;
        this.zodiacSign = zodiacSign;
        this.bloodCate = bloodCate;
        this.moto = moto;
        this.constellation = constellation;
        this.profession = profession;
        this.company = company;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getAboutLove() {
        return aboutLove;
    }

    public void setAboutLove(String aboutLove) {
        this.aboutLove = aboutLove;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getNowLiveAt() {
        return nowLiveAt;
    }

    public void setNowLiveAt(String nowLiveAt) {
        this.nowLiveAt = nowLiveAt;
    }

    public String getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(String zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    public String getBloodCate() {
        return bloodCate;
    }

    public void setBloodCate(String bloodCate) {
        this.bloodCate = bloodCate;
    }

    public String getMoto() {
        return moto;
    }

    public void setMoto(String moto) {
        this.moto = moto;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "UID=" + UID +
                ", aboutLove='" + aboutLove + '\'' +
                ", homeTown='" + homeTown + '\'' +
                ", nowLiveAt='" + nowLiveAt + '\'' +
                ", zodiacSign='" + zodiacSign + '\'' +
                ", bloodCate='" + bloodCate + '\'' +
                ", moto='" + moto + '\'' +
                ", constellation='" + constellation + '\'' +
                ", profession='" + profession + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
