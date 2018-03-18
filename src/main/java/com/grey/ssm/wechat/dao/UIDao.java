package com.grey.ssm.wechat.dao;

import com.grey.ssm.wechat.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UIDao {
    int insertUI(@Param("UID")int UID,@Param("aboutLove")String aboutLove,@Param("homeTown")String homeTown,
                 @Param("nowLiveAt")String nowLiveAt,@Param("zodiacSign")int zodiacSign,
                 @Param("bloodCate")String bloodCate,@Param("moto")String moto,
                 @Param("constellation")int constellation,@Param("profession")String profession,
                 @Param("company")String company);
    UserInfo queryUIByUID(@Param("UID")int UID);
    int updateUI(@Param("UID")int UID,@Param("aboutLove")String aboutLove,@Param("homeTown")String homeTown,
                 @Param("nowLiveAt")String nowLiveAt,@Param("zodiacSign")int zodiacSign,
                 @Param("bloodCate")String bloodCate,@Param("moto")String moto,
                 @Param("constellation")int constellation,@Param("profession")String profession,
                 @Param("company")String company);
    void deleteUIByUID(@Param("UID")int UID);
}
