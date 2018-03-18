package com.grey.ssm.wechat.service.Impl;

import com.grey.ssm.wechat.dao.GMDao;
import com.grey.ssm.wechat.dao.GroupDao;
import com.grey.ssm.wechat.dao.UIDao;
import com.grey.ssm.wechat.dao.UserDao;
import com.grey.ssm.wechat.model.Group;
import com.grey.ssm.wechat.model.GroupMembers;
import com.grey.ssm.wechat.model.User;
import com.grey.ssm.wechat.model.UserInfo;
import com.grey.ssm.wechat.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private GMDao gmpDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UIDao uiDao;
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
        List<Group>groups = groupDao.queryGroupByGID(gid);
        System.out.println(groups);
        if (!groups.isEmpty())
            return groups.get(0);
        else
            return null;
    }

    public List<Group> findCGroupByUID(int uid) {
        List<Group> groups = groupDao.queryGroupByUID(uid);
        return groups;
    }

    public List<GroupMembers> findJGroupByUID(int uid) {
        List<GroupMembers> groupMembers = gmpDao.queryGMByUID(uid);
        return groupMembers;
    }

    public List<GroupMembers> findGMByGID(int gid) {
        return null;
    }

    public List<GroupMembers> findGMInByGID(int gid) {
        List<GroupMembers> gms = gmpDao.queryGMByStatusAndGID(1,gid);
        return gms;
    }

    public List<GroupMembers> findGMNotInByGID(int gid) {
        List<GroupMembers> gms = gmpDao.queryGMByStatusAndGID(0,gid);
        return gms;
    }

    public void updateGM(int gid, int uid) {
        gmpDao.updateGM(gid,uid,1,0);
    }

    public void deleteGM(int gid, int uid) {
        gmpDao.deleteGM(gid,uid);
    }

    public void joinGroup(int gid, int uid) {
        List<GroupMembers> groupMembers =gmpDao.queryGMByGIDAndUID(gid,uid);
        if (groupMembers.isEmpty())
            gmpDao.insertGM(gid,uid,0,0);
    }

    public List<User> searchUser(String nickName, int sex, int low_age, int low_age1, int high_age, String nowLiveAt, String homeTown, String aboutLove, String profession) {
        List<Integer> users= gmpDao.queryIDByUserInfo(nickName,sex,low_age,high_age,nowLiveAt
                        ,homeTown,aboutLove,profession);
        if (users.size()==0) return null;
        else {
            List<User> userList = new ArrayList<User>();
        for (int i = 0; i<users.size(); i++){
                System.out.println("##"+users.get(i));
                User user = userDao.queryUserById(Integer.parseInt(""+users.get(i)));
                userList.add(user);
            }
            System.out.println(userList.get(0).toString());
            return userList;
        }

    }

    public User findUser(int uid) {
        User user= userDao.queryUserById(uid);
        return user;
    }

    public UserInfo findUserInfo(int uid) {
        return uiDao.queryUIByUID(uid);
    }

    public List<UserInfo> searchUserInfo(String nickName, int sex, int low_age, int low_age1, int high_age, String nowLiveAt, String homeTown, String aboutLove, String profession) {
        List<Integer> users = gmpDao.queryIDByUserInfo(nickName,sex,low_age,high_age,nowLiveAt
                ,homeTown,aboutLove,profession);
        if (users.size()==0) return null;
        else {
            List<UserInfo> userInfo = new ArrayList<UserInfo>();
            for (int i =0; i<users.size();i++){
                userInfo.add(uiDao.queryUIByUID(users.get(i)));
            }
            return userInfo;
        }

    }
}
