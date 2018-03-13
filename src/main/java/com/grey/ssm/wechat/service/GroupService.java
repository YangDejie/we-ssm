package com.grey.ssm.wechat.service;

public interface GroupService {

    boolean isExsitGroup(int gid);

    boolean isManager(int uid);

    void updateInviteCode(int gid, String inviteCode);

    void createGroup(int gid, String gName, String inviteCode, int isVisible);
}
