package com.grey.ssm.wechat.dao;

import com.grey.ssm.wechat.model.ActivityMembers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AMDao {
    int insertAM(@Param("AID")int AID,@Param("UID")int UID);
    List<ActivityMembers> queryAMByAID(@Param("AID")int AID);
    List<ActivityMembers> queryAMByUID(@Param("UID")int UID);
    void deleteAM(@Param("AID")int AID,@Param("UID")int UID);
}
