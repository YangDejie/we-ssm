package com.grey.ssm.wechat.web;


import com.grey.ssm.wechat.model.ActivityMembers;
import com.grey.ssm.wechat.model.GroupActivity;
import com.grey.ssm.wechat.model.GroupMembers;
import com.grey.ssm.wechat.model.User;
import com.grey.ssm.wechat.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.SoundbankResource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class ActivityController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ActivityService activityService;
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    DateFormat formatD = new SimpleDateFormat("yyyy-MM-dd");
    //创建活动页面
    @RequestMapping(value = "/create_activity",method = RequestMethod.GET)
    private void createActivityPage(HttpServletRequest req, HttpServletResponse res)throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/create_activity");
            res.sendRedirect("/login");
        }else {
            req.getRequestDispatcher("/WEB-INF/jsp/activity_create.jsp").forward(req,res);
        }
    }
    //创建活动
    @RequestMapping(value = "/create_activity",method = RequestMethod.POST)
    private void createActivity(HttpServletRequest req, HttpServletResponse res)throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/create_activity");
            res.sendRedirect("/login");
        }else {
            int GID = Integer.parseInt(req.getParameter("GID"));
            int AID = Integer.parseInt(req.getParameter("AID"));
            int numbers = Integer.parseInt(req.getParameter("numbers"));
            String title = req.getParameter("title");
            Date date  = formatD.parse(req.getParameter("time"));
            String content = req.getParameter("content");
            boolean success = activityService.createActivity(GID,AID,user.getUID(),numbers,title,date,content);
            if (success){
                res.sendRedirect("/activity_detail/" +AID);
            }else {
                session.setAttribute("error","输入有误，创建失败");
                res.sendRedirect("/error");
            }

        }
    }

    //活动详情页面
    @RequestMapping(value = "/activity_detail/{AID}",method = RequestMethod.GET)
    private void detailActivityPage(@PathVariable("AID")int AID, HttpServletRequest req, HttpServletResponse res)throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/activity_detail");
            res.sendRedirect("/login");
        }else {
            List<ActivityMembers> members = activityService.findMembersByAID(AID);
            GroupActivity groupActivity = activityService.findActivity(AID);
            req.setAttribute("activity",groupActivity);
            req.setAttribute("numbers_done",members.size());
            req.getRequestDispatcher("/WEB-INF/jsp/activity_detail.jsp").forward(req,res);
        }
    }
    //加入活动
    @RequestMapping(value = "/join_activity/{AID}")
    private void joinActivit(@PathVariable("AID")int AID,HttpServletRequest req,HttpServletResponse res)throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/join_activity/"+AID);
            res.sendRedirect("/login");
        }else {
            activityService.joinActivity(user.getUID(),AID);
            res.sendRedirect("/home");
        }
    }
    //浏览活动
    @RequestMapping("/view_activity")
    private void viewActivity(HttpServletRequest req,HttpServletResponse res)throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/view_activity");
            res.sendRedirect("/login");
        }else {
            List<GroupActivity> groupActivities = activityService.getAllActivity();
            req.setAttribute("AList",groupActivities);
            req.getRequestDispatcher("/WEB-INF/jsp/activity_view.jsp").forward(req,res);
        }
    }
}
