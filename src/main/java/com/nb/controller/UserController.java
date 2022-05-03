package com.nb.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.log.Log;
import com.nb.domain.User;
import com.nb.service.impl.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {   //用来返回视图和数据
    @Autowired
    private UserServiceImp userservice;

    @RequestMapping("/denglu")
    private String denglu(User user , HttpSession session)throws Exception{
        if (userservice.login(user)){
        //登陆成功
            User user1 = userservice.selectUser(user.getXid());
            session.setAttribute("user",user1);
            return "index";

        }else {
           return "login";

        }
    }

    @RequestMapping("/zhuce")
    private String zhuce(User user, HttpSession session)throws Exception{
        if (userservice.register(user)){
            System.out.println(user);
            User user1 = userservice.selectUser(user.getXid());
            session.setAttribute("user",user1);

            return "index";
        }else {
            return "register";
        }
    }


    //判断用户是否存在
    @RequestMapping(value = "/judgeUser")
    @ResponseBody
    private User judgeUser( HttpServletRequest request,HttpServletResponse response)throws Exception{
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        User user1 = userservice.selectUser(user.getXid());
        if (user!=null){
           return user1;
        }
        else
            return null;

    }
    @RequestMapping("/getUserInfo")
    @ResponseBody
    private String getUserInfo(HttpSession session)throws Exception{

        User user = (User)session.getAttribute("user");
        String xid = user.getXid();
        User user1 = userservice.selectUser(xid);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user1);
        return s;
    }

    //修改个人信息
    @RequestMapping(value = "/modifyInfo" ,method = RequestMethod.POST)
    @ResponseBody
    private String modifyInfo(User user)throws Exception{
        System.out.println(user);
        Boolean aBoolean = userservice.updateUser(user);
        if (aBoolean)
            return "{\"boolean\":\"true\"}";
        else
            return "{\"boolean\":\"false\"}";
    }


}
