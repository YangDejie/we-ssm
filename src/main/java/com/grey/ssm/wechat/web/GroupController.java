package com.grey.ssm.wechat.web;


import com.grey.ssm.wechat.model.Group;
import com.grey.ssm.wechat.model.GroupMembers;
import com.grey.ssm.wechat.model.User;
import com.grey.ssm.wechat.model.UserInfo;
import com.grey.ssm.wechat.service.GroupService;
import com.grey.ssm.wechat.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

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
    //查找用户页面
    @RequestMapping(value = "/find_user", method = RequestMethod.GET)
    private void   findUserPage(HttpServletRequest req,HttpServletResponse res) throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/find_user");
            res.sendRedirect("/login");
        }else {
            req.getRequestDispatcher("/WEB-INF/jsp/find_user.jsp").forward(req,res);
        }
    }
    //查找用户
    @RequestMapping(value = "/find_user", method = RequestMethod.POST)
    private void   findUser(HttpServletRequest req,HttpServletResponse res) throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/find_user");
            res.sendRedirect("/login");
        }else {
            String nickName = req.getParameter("nickName");
            int sex = Integer.parseInt(req.getParameter("sex"));
            int low_age = Integer.parseInt(req.getParameter("low_age"));
            int high_age = Integer.parseInt(req.getParameter("high_age"));
            String nowLiveAt = req.getParameter("nowLiveAt");
            String homeTown = req.getParameter("homeTown");
            String aboutLove = req.getParameter("aboutLove");
            String profession = req.getParameter("profession");
            List<User> users = groupService.searchUser(nickName,sex,low_age,low_age,high_age,nowLiveAt,homeTown,aboutLove,profession);
            if (users==null){
                res.sendRedirect("/find_result");
            }else {
                session.setAttribute("userList",users);
                res.sendRedirect("/find_result");
            }
        }
    }
    @RequestMapping("/find_result")
    private void findResult(HttpServletRequest req,HttpServletResponse res)throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/find_result");
            res.sendRedirect("/login");
        }else {
            req.setAttribute("userList",session.getAttribute("userList"));
            session.setAttribute("userList",null);
            req.getRequestDispatcher("/WEB-INF/jsp/find_result.jsp").forward(req,res);
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
            req.getRequestDispatcher("/WEB-INF/jsp/group_join.jsp").forward(req,res);
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
            Group group = groupService.findGroup(GID);
            if(group!=null){
                if (group.getInviteCode().equals(req.getParameter("inviteCode"))){
                    groupService.joinGroup(GID,user.getUID());
                    session.setAttribute("success","申请成功");
                    res.sendRedirect("/success");
                }else {
                    session.setAttribute("error","群"+GID+"邀请不存在");
                    res.sendRedirect("/error");
                }
            }else {
                session.setAttribute("error","群"+GID+"不存在");
                res.sendRedirect("/error");
            }
        }
    }
    @RequestMapping("/my_group")
    private void myGroupPage(HttpServletRequest req, HttpServletResponse res) throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/join_group");
            res.sendRedirect("/login");
        }else {
            int UID = user.getUID();
            List<Group> group_create = groupService.findCGroupByUID(UID);
            List<GroupMembers> group_join  = groupService.findJGroupByUID(UID);
            req.setAttribute("cg",group_create);
            req.setAttribute("jg",group_join);
            req.getRequestDispatcher("/WEB-INF/jsp/group_my.jsp").forward(req,res);
        }
    }
    @RequestMapping("/manage_group/{GID}")
    private void manageGroup(@PathVariable("GID")int GID, HttpServletRequest req, HttpServletResponse res)throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/manage_group/"+GID);
            res.sendRedirect("/login");
        }else {
            List<GroupMembers> inMembers = groupService.findGMInByGID(GID);
            List<GroupMembers> notMembers = groupService.findGMNotInByGID(GID);
            req.setAttribute("gm_in",inMembers);
            req.setAttribute("gm_notin",notMembers);
            req.getRequestDispatcher("/WEB-INF/jsp/group_manage.jsp").forward(req,res);
        }
    }
    @RequestMapping("/user_detail/{UID}")
    private void UserDetail(@PathVariable("UID")int UID, HttpServletRequest req, HttpServletResponse res)throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/user_detail/"+UID);
            res.sendRedirect("/login");
        }else {
            User user_find= groupService.findUser(UID);
            UserInfo userInfo = groupService.findUserInfo(UID);
            req.setAttribute("user",user_find);
            req.setAttribute("ui",userInfo);
            req.getRequestDispatcher("/WEB-INF/jsp/user_detail.jsp").forward(req,res);
        }
    }
    @RequestMapping("/agree/{UID}/join/{GID}")
    private void agreeJoin(@PathVariable("GID")int GID, @PathVariable("UID")int UID, HttpServletRequest req, HttpServletResponse res)throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/agree/"+UID+"/join/"+GID);
            res.sendRedirect("/login");
        }else {
            groupService.updateGM(GID,UID);
            req.setAttribute("success","已经同意");
            req.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(req,res);
        }
    }
    @RequestMapping("/deny/{UID}/join/{GID}")
    private void denyJoin(@PathVariable("GID")int GID, @PathVariable("UID")int UID, HttpServletRequest req, HttpServletResponse res)throws Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/deny/"+UID +"/join/"+GID);
            res.sendRedirect("/login");
        }else {
            groupService.deleteGM(GID,UID);
            req.setAttribute("success","已经删除");
            req.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(req,res);
        }
    }
}
