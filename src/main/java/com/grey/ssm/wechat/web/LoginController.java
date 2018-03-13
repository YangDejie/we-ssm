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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
                    req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req,res);
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
                    res.sendRedirect("/home");
                }else {
                    session.setAttribute("re_url",null);
                    res.sendRedirect(re_url);
                }

            }else {
                req.setAttribute("error","密码错误");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req,res);
            }
        }

    }

}
