package com.grey.ssm.wechat.service;

import com.grey.ssm.wechat.model.User;

public interface LoginService {
    int SignUp(User user);
    User validateUID(int uid);
}
