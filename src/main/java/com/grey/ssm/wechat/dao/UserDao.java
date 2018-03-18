package com.grey.ssm.wechat.dao;

import com.grey.ssm.wechat.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface UserDao {
    User queryUserById(@Param("UID") int UID);
    int insertUser(@Param("UID") int uid,
                   @Param("userName") String userName,
                   @Param("nickName") String nickName,
                   @Param("passWord") String passWord,
                   @Param("sex") int sex,
                   @Param("birthday")Date birthday,
                   @Param("age")int age,
                   @Param("email")String email,
                   @Param("telephone")String telephone);
    void updateUser(@Param("UID") int uid,
                   @Param("userName") String userName,
                   @Param("nickName") String nickName,
                   @Param("sex") int sex,
                   @Param("birthday")Date birthday,
                   @Param("age")int age,
                   @Param("email")String email,
                   @Param("telephone")String telephone);
    void deleteUser(@Param("UID") int uid);
}
