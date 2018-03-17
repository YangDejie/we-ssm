package com.grey.ssm.wechat.web;


import com.grey.ssm.wechat.model.Group;
import com.grey.ssm.wechat.model.User;
import com.grey.ssm.wechat.service.GroupService;
import com.grey.ssm.wechat.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/")
public class GroupController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private GroupService groupService;
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //邀请码界面
    @RequestMapping(value = "/invite_code",method = RequestMethod.GET)
    private void getCodePage(HttpServletRequest req,HttpServletResponse res) throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/invite_code");
            res.sendRedirect("/login");
        }else {
            req.getRequestDispatcher("/WEB-INF/jsp/invite_code.jsp").forward(req,res);
        }
    }

    //获取邀请码
    @RequestMapping(value = "/invite_code",method = RequestMethod.POST)
    private void getCode(HttpServletRequest req,HttpServletResponse res) throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/invite_code");
            res.sendRedirect("/login");
        }else {
            int GID = Integer.parseInt(req.getParameter("GID"));
            boolean isExsitG = groupService.isExsitGroup(GID);
            if(isExsitG){
                boolean isManager = groupService.isManager(user.getUID());
                if(isManager){
                    String inviteCode = req.getParameter("inviteCode");
                    groupService.updateInviteCode(GID,inviteCode);
                    req.setAttribute("success","更新群组邀请码成功");
                    res.sendRedirect("/success");
                }else {
                    req.setAttribute("error","此群组您没有权限");
                    res.sendRedirect("/error");
                }
            }else {
                req.setAttribute("create_group","群"+GID+"不存在，需要被创建");
                res.sendRedirect("/create_group");
            }

        }
    }

    //创建群页面
    @RequestMapping(value = "/create_group",method = RequestMethod.GET)
    private void createGroupPage(HttpServletRequest req,HttpServletResponse res) throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/create_group");
            res.sendRedirect("/login");
        }else {
            req.getRequestDispatcher("/WEB-INF/jsp/create_group.jsp").forward(req,res);
        }
    }
    //创建群
    @RequestMapping(value = "/create_group",method = RequestMethod.POST)
    private void createGroup(HttpServletRequest req,HttpServletResponse res) throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/create_group");
            res.sendRedirect("/login");
        }else {
            int GID = Integer.parseInt(req.getParameter("GID"));
            boolean isExsitG = groupService.isExsitGroup(GID);
            if(isExsitG){
                req.setAttribute("create_group","群"+GID+"已存在，需要创建其他ID群组");
                res.sendRedirect("/create_group");
            }else {
                String GName = req.getParameter("GName");
                String inviteCode = req.getParameter("inviteCode");
                int isVisible = Integer.parseInt(req.getParameter("isVisible"));
                groupService.createGroup(GID,GName,inviteCode,isVisible);
                Group group = groupService.findGroup(GID);
                req.setAttribute("Group",group);
                res.sendRedirect("/group_detail");
            }
        }
    }

    //查找群页面
    @RequestMapping(value = "/find_group", method = RequestMethod.GET)
    private void   findGroupPage(HttpServletRequest req,HttpServletResponse res) throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/find_group");
            res.sendRedirect("/login");
        }else {
            req.getRequestDispatcher("/WEB-INF/jsp/find_code.jsp").forward(req,res);
        }
    }
    //查找群
    @RequestMapping(value = "/find_group", method = RequestMethod.POST)
    private void   findGroup(HttpServletRequest req,HttpServletResponse res) throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/find_group");
            res.sendRedirect("/login");
        }else {
            int GID = Integer.parseInt(req.getParameter("GID"));
            boolean isExsitG = groupService.isExsitGroup(GID);
            if(isExsitG){
                Group group = groupService.findGroup(GID);
                String invite_code = req.getParameter("inviteCode");
                if (group.getInviteCode().equals(invite_code)){
                    group.addMember(GID,user.getUID(),0);
                    Group nowGroup = groupService.findGroup(GID);
                    req.setAttribute("group",nowGroup);
                    res.sendRedirect("/group_detail");
                }


            }else {
                req.setAttribute("find_group","群"+GID+"不存在，需要创建其他ID群组");
                res.sendRedirect("/find_group");
            }
        }
    }
    //加入群页面
    @RequestMapping(value = "/join_group",method = RequestMethod.GET)
    private void joinGroupPage(HttpServletRequest req,HttpServletResponse res) throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/join_group");
            res.sendRedirect("/login");
        }else {
            req.getRequestDispatcher("/WEB-INF/jsp/join_group.jsp").forward(req,res);
        }
    }
    //加入群
    @RequestMapping(value = "/join_group",method = RequestMethod.POST)
    private void joinGroup(HttpServletRequest req,HttpServletResponse res) throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/join_group");
            res.sendRedirect("/login");
        }else {
            int GID = Integer.parseInt(req.getParameter("GID"));
            boolean isExsitG = groupService.isExsitGroup(GID);
            if(isExsitG){
                Group group = groupService.findGroup(GID);
                if (group.getInviteCode().equals(req.getParameter("inviteCode"))){
                    Group nowGroup = groupService.findGroup(GID);
                    req.setAttribute("group",nowGroup);
                    req.setAttribute("join_group",null);
                    res.sendRedirect("/group_detail");
                }else {
                    req.setAttribute("join_group","群"+GID+"不存在");
                    res.sendRedirect("/join_group");
                }
            }else {
                req.setAttribute("join_group","群"+GID+"不存在");
                res.sendRedirect("/join_group");
            }
        }
    }

}
