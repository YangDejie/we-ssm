package com.grey.ssm.wechat.service;

import com.grey.ssm.wechat.model.User;

import java.util.Date;

public interface LoginService {
    int SignUp(User user);
    User validateUID(int uid);

    void updateProfile(int uid, String nickName, String userName,
                       int sex, int age, String email, String tele, String moto,
                       String aboutLove, String homeTown, String profession,
                       int zodiac, String company, int cons, Date birth, String bloodCate,String nowLiveAt);
}
