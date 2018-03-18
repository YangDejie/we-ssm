package com.grey.ssm.wechat.dao;

import com.grey.ssm.wechat.model.GroupActivity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface GADao {
    int insertGA(@Param("GID")int GID, @Param("AID")int AID,
                 @Param("CreateID")int CreateID, @Param("numbers")int numbers,
                 @Param("title")String title, @Param("time")Date time,
                 @Param("content")String content);
    List<GroupActivity> queryGAByGID(@Param("GID")int GID);
    List<GroupActivity> queryGAByAID(@Param("AID")int AID);
    List<GroupActivity> queryGAByCreateID(@Param("CreateID")int CreateID);
    int updateGA(@Param("GID")int GID, @Param("AID")int AID,
                 @Param("CreateID")int CreateID, @Param("numbers")int numbers,
                 @Param("title")String title, @Param("time")Date time,
                 @Param("content")String content);
    void deleteGA(@Param("GID")int GID,@Param("AID")int AID);

    List<GroupActivity> getAll();
}