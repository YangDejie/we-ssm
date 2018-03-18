package com.grey.ssm.wechat.web;

import com.grey.ssm.wechat.model.User;
import com.grey.ssm.wechat.service.LoginService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.SoundbankResource;
import javax.xml.bind.SchemaOutputResolver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LoginService loginService;
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    DateFormat formatD = new SimpleDateFormat("yyyy-MM-dd");
    //首页
    @RequestMapping(value = "/home")
    private void Home(HttpServletRequest req, HttpServletResponse res)throws Exception{
        String s = format.format(new Date()) + ": visit home once";
        System.out.println(s);
        logger.info(s);
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req,res);
    }
    //登录get
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    private void LoginGetter(HttpServletRequest req, HttpServletResponse res) throws Exception{
        HttpSession session = req.getSession();
        String s = format.format(new Date()) + ": visit login once";
         System.out.println(s);
         logger.info(s);
         User user = (User) session.getAttribute("user");
         req.setAttribute("user",user);
         session.setAttribute("re_url",session.getAttribute("re_url"));
         req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,res);
    }
    //error
    @RequestMapping(value = "/error",method = RequestMethod.GET)
    private void error(HttpServletRequest req, HttpServletResponse res) throws Exception{
        HttpSession session = req.getSession();

        req.setAttribute("error",session.getAttribute("error"));
        session.setAttribute("error",null);
        req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req,res);
    }
    //error
    @RequestMapping(value = "/success",method = RequestMethod.GET)
    private void success(HttpServletRequest req, HttpServletResponse res) throws Exception{
        HttpSession session = req.getSession();
        req.setAttribute("success",session.getAttribute("success"));
        session.setAttribute("success",null);
        req.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(req,res);
    }
    //登录POST
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    private void LoginPoster(HttpServletRequest req, HttpServletResponse res) throws Exception{
        HttpSession session = req.getSession();
        int UID = Integer.parseInt(req.getParameter("UID"));
        String passWord = req.getParameter("passWord");
        User user = loginService.validateUID(UID);
        if (user == null){
            try {
                User addUser = new User();
                addUser.setUID(UID);
                addUser.setPassWord(passWord);
                int code = loginService.SignUp(addUser);
                if(code == 0){
                    session.setAttribute("user",addUser);
                    req.setAttribute("user", addUser);
                    res.sendRedirect("/profile");
                }else {
                    logger.error("insert user fail:"+addUser.toString());
                }
            }catch (Exception e){
                logger.error(e.toString());
            }
        }else {
            if (user.getPassWord().equals(passWord)){
                logger.info(user.toString());
                session.setAttribute("user",user);
                req.setAttribute("user",user);
                String re_url = (String) session.getAttribute("re_url");
                System.out.println("#####"+re_url);
                if (re_url == null){
                    res.sendRedirect("/profile");
                }else {
                    session.setAttribute("re_url",null);
                    res.sendRedirect(re_url);
                }

            }else {
                req.setAttribute("error","密码错误");
                res.sendRedirect("/error");
            }
        }

    }

    //profile 页
    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    private void profilePage(HttpServletRequest req, HttpServletResponse res) throws  Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/profile");
            res.sendRedirect("/login");
        }else {
            System.out.println("sssssssssssssssssssssssssss");
            req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req,res);
        }
    }
    //profile_update 页
    @RequestMapping(value = "/profile_update",method = RequestMethod.GET)
    private void profileUpPage(HttpServletRequest req, HttpServletResponse res) throws  Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/profile_update");
            res.sendRedirect("/login");
        }else {
            System.out.println("sssssssssssssssssssssssssss");
            req.getRequestDispatcher("/WEB-INF/jsp/profile_update.jsp").forward(req,res);
        }
    }
    //profile_update 页
    @RequestMapping(value = "/profile_update",method = RequestMethod.POST)
    private void profileUp(HttpServletRequest req, HttpServletResponse res) throws  Exception{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            session.setAttribute("re_url","/profile_update");
            res.sendRedirect("/login");
        }else {
            String nickName = req.getParameter("nickName");
            String userName = req.getParameter("userName");

            int sex = Integer.parseInt(req.getParameter("sex"));
            System.out.println("sex" +sex );
            int age = Integer.parseInt(req.getParameter("age"));
            String email =  req.getParameter("email");
            String tele =  req.getParameter("tele");
            String moto = req.getParameter("moto");
            System.out.println("seweqweqwex" +moto );
            String aboutLove = req.getParameter("aboutLove");
            String homeTown =  req.getParameter("homeTown");
            String profession = req.getParameter("profession");
            int zodiac = Integer.parseInt(req.getParameter("zodiacSign"));
            String company =  req.getParameter("company");
            int cons = Integer.parseInt(req.getParameter("constellation"));
            Date birth = formatD.parse( req.getParameter("birthday"));
            String bloodCate = req.getParameter("bloodCate");
            String nowLiveAt =  req.getParameter("nowLiveAt");
            loginService.updateProfile(user.getUID(),nickName,userName,sex,age,email,tele,moto,aboutLove,homeTown,profession
                ,zodiac,company,cons,birth,bloodCate,nowLiveAt);
            res.sendRedirect("/profile");
        }
    }

}
