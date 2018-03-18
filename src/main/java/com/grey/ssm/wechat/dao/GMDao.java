package com.grey.ssm.wechat.dao;

import com.grey.ssm.wechat.model.GroupMembers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GMDao {
    int insertGM(@Param("GID")int GID,@Param("UID")int UID,
                 @Param("status")int status,@Param("privilege")int privilege);
    List<GroupMembers> queryGMByGID(@Param("GID")int GID);
    List<GroupMembers> queryGMByUID(@Param("UID")int UID);
    List<GroupMembers> queryGMByStatus(@Param("status")String status);
    List<Integer> queryIDByUserInfo(@Param("nickName")String nickName,@Param("sex") int sex,
                          @Param("low_age")int low_age,@Param("high_age")int high_age,
                          @Param("nowLiveAt")String nowLiveAt,@Param("homeTown")String homeTown,
                          @Param("aboutLove")String aboutLove,@Param("profession")String profession);
    int updateGM(@Param("GID")int GID,@Param("UID")int UID,
                 @Param("status")int status,@Param("privilege")int privilege);
    void deleteGM(@Param("GID")int GID,@Param("UID")int UID);

    List<GroupMembers> queryGMByStatusAndGID(@Param("status") int i, @Param("GID") int gid);

    List<GroupMembers>  queryGMByGIDAndUID(@Param("GID")int gid, @Param("UID")int uid);
}