package com.grey.ssm.wechat.service;

import com.grey.ssm.wechat.model.Group;

public interface GroupService {

    boolean isExsitGroup(int gid);

    boolean isManager(int uid);

    void updateInviteCode(int gid, String inviteCode);

    void createGroup(int gid, String gName, String inviteCode, int isVisible);

    Group findGroup(int gid);
}
