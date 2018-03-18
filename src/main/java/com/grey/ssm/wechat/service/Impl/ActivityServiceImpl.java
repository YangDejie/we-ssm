package com.grey.ssm.wechat.service.Impl;

import com.grey.ssm.wechat.dao.AMDao;
import com.grey.ssm.wechat.dao.GADao;
import com.grey.ssm.wechat.dao.GMDao;
import com.grey.ssm.wechat.model.ActivityMembers;
import com.grey.ssm.wechat.model.Group;
import com.grey.ssm.wechat.model.GroupActivity;
import com.grey.ssm.wechat.model.GroupMembers;
import com.grey.ssm.wechat.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ActivityServiceImpl implements ActivityService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private GADao GADao;
    @Autowired
    private AMDao AMDao;
    public boolean createActivity(int gid, int aid, int uid, int numbers, String title, Date date, String content) {
        try{
            GADao.insertGA(gid, aid, uid, numbers,title,date,content);
            return true;
        }catch (Exception e){
            logger.error(e.toString());
            logger.error((new GroupActivity(gid, aid, uid, numbers,title,date,content).toString()));
            return false;
        }
    }

    public List<ActivityMembers> findMembersByAID(int aid) {
        try {
            List<ActivityMembers> members = AMDao.queryAMByAID(aid);
            return  members;

        }catch (Exception e){
            logger.error(e.toString());
            logger.error("find member for AID:"+aid);
            return null;
        }

    }

    public void joinActivity(int uid, int aid) {
        try {
            AMDao.insertAM(aid,uid);
        }catch (Exception e){
            logger.error(e.toString());
        }
    }

    public GroupActivity findActivity(int aid) {
        List<GroupActivity> groupActivity = GADao.queryGAByAID(aid);
        return groupActivity.get(0);
    }

    public List<GroupActivity> getAllActivity() {
        List<GroupActivity> groupActivities = GADao.getAll();
        return groupActivities;
    }
}
