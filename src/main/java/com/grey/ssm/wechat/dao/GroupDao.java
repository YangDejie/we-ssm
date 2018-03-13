package com.grey.ssm.wechat.dao;

import com.grey.ssm.wechat.model.Group;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupDao {
    List<Group> queryGroupByGID(@Param("GID")int GID);
    List<Group> queryGroupByUID(@Param("UID")int UID);
    int insertGroup(@Param("GID")int GID,@Param("UID")int UID,
                    @Param("InviteCode")int InviteCode,@Param("GName")String GName);
    int updateGroup(@Param("GID")int GID,@Param("UID")int UID,
                    @Param("InviteCode")int InviteCode,@Param("GName")String GName);
    void deleteGroupByGID(@Param("GID")int GID);
}
