package com.grey.ssm.wechat.service;

import com.grey.ssm.wechat.model.Group;
import com.grey.ssm.wechat.model.GroupMembers;
import com.grey.ssm.wechat.model.User;
import com.grey.ssm.wechat.model.UserInfo;

import java.util.List;

public interface GroupService {

    boolean isExsitGroup(int gid);

    boolean isManager(int uid);

    void updateInviteCode(int gid, String inviteCode);

    void createGroup(int gid, String gName, String inviteCode, int isVisible);

    Group findGroup(int gid);

    List<Group> findCGroupByUID(int uid);

    List<GroupMembers> findJGroupByUID(int uid);

    List<GroupMembers> findGMByGID(int gid);

    List<GroupMembers> findGMInByGID(int gid);

    List<GroupMembers> findGMNotInByGID(int gid);

    void updateGM(int gid, int uid);

    void deleteGM(int gid, int uid);

    void joinGroup(int gid, int uid);
    List<UserInfo> searchUserInfo(String nickName, int sex, int low_age, int low_age1, int high_age, String nowLiveAt, String homeTown, String aboutLove, String profession);
    List<User> searchUser(String nickName, int sex, int low_age, int low_age1, int high_age, String nowLiveAt, String homeTown, String aboutLove, String profession);

    User findUser(int uid);

    UserInfo findUserInfo(int uid);
}
