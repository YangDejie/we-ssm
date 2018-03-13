package com.grey.ssm.wechat.service.Impl;

import com.grey.ssm.wechat.dao.UserDao;
import com.grey.ssm.wechat.model.User;
import com.grey.ssm.wechat.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.SchemaOutputResolver;

@Service
public class LoginServiceImpl implements LoginService{
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserDao userDao;


    public int SignUp(User user) {
        try {
            userDao.insertUser(user.getUID(),user.getUserName(),user.getNickName(),user.getPassWord(),user.getSex(),user.getBirthday(),user.getAge(),user.getEmail(),user.getTelephone());
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.toString());
            logger.error(user.toString());
            return -1;
        }
    }

    public User validateUID(int uid) {
        try {
            User user = userDao.queryUserById(uid);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.toString());
            logger.error("fail to find UID:"+uid);
            return null;
        }

    }
}
