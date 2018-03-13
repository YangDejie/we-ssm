package com.grey.ssm.wechat.dao;

import com.grey.ssm.wechat.model.UserInfo;
import org.apache.ibatis.annotations.Param;


public interface UIDao {
    int insertUI(@Param("UID")int UID,@Param("aboutLove")String aboutLove,
                 @Param("nowLoveAt")String nowLiveAt,@Param("zodiacSign")String zodiacSign,
                 @Param("bloodCate")String bloodCate,@Param("moto")String moto,
                 @Param("constellation")String constellation,@Param("profession")String profession,
                 @Param("company")String company);
    UserInfo queryUIByUID(@Param("UID")int UID);
    int updateUI(@Param("UID")int UID,@Param("aboutLove")String aboutLove,
                 @Param("nowLoveAt")String nowLiveAt,@Param("zodiacSign")String zodiacSign,
                 @Param("bloodCate")String bloodCate,@Param("moto")String moto,
                 @Param("constellation")String constellation,@Param("profession")String profession,
                 @Param("company")String company);
    void deleteUIByUID(@Param("UID")int UID);
}
