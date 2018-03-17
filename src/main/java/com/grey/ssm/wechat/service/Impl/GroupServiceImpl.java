package com.grey.ssm.wechat.service.Impl;

import com.grey.ssm.wechat.model.Group;
import com.grey.ssm.wechat.service.GroupService;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    public boolean isExsitGroup(int gid) {
        return false;
    }

    public boolean isManager(int uid) {
        return false;
    }

    public void updateInviteCode(int gid, String inviteCode) {

    }

    public void createGroup(int gid, String gName, String inviteCode, int isVisible) {

    }

    public Group findGroup(int gid) {
        return null;
    }
}
