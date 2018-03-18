package com.grey.ssm.wechat.service;

import com.grey.ssm.wechat.model.ActivityMembers;
import com.grey.ssm.wechat.model.GroupActivity;
import com.grey.ssm.wechat.model.GroupMembers;

import java.util.Date;
import java.util.List;

public interface ActivityService {
    boolean createActivity(int gid, int aid, int uid,int numbers, String title, Date date, String content);

    List<ActivityMembers> findMembersByAID(int aid);

    void joinActivity(int uid, int aid);

    GroupActivity findActivity(int aid);

    List<GroupActivity> getAllActivity();
}
