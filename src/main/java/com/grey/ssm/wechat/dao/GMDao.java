package com.grey.ssm.wechat.dao;

import com.grey.ssm.wechat.model.GroupMembers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GMDao {
    int insertGM(@Param("GID")int GID,@Param("UID")int UID,
                 @Param("status")String status,@Param("privilege")String privilege);
    List<GroupMembers> queryGMByGID(@Param("GID")int GID);
    List<GroupMembers> queryGMByUID(@Param("UID")int UID);
    List<GroupMembers> queryGMByStatus(@Param("status")String status);
    int queryIDByUserInfo(@Param("nickName")String nickName,@Param("sex") int sex,
                          @Param("low_age")int low_age,@Param("high_age")int high_age,
                          @Param("nowLiveAt")String nowLiveAt,@Param("homeTown")String homeTown,
                          @Param("aboutLove")String aboutLove);
    int updateGM(@Param("GID")int GID,@Param("UID")int UID,
                 @Param("status")String status,@Param("privilege")String privilege);
    void deleteGM(@Param("GID")int GID,@Param("UID")int UID);
}