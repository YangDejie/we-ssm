package com.grey.ssm.wechat.web;


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
            req.getRequestDispatcher("/WEB-INF/jsp/invite_code.jsp").forward(req,res);
        }
    }
    //创建群页面
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
                int isVisible = req.getIntHeader("isVisible");
                groupService.createGroup(GID,GName,inviteCode,isVisible);
            }
        }
    }
}
