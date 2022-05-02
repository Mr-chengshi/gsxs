package com.nb.controller;
import com.nb.domain.User;
import com.nb.service.impl.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
            session.setAttribute("user",user);
            return "index";

        }else {
           return "login";

        }
    }

    @RequestMapping("/zhuce")
    private String zhuce(User user, HttpSession session)throws Exception{
        if (userservice.register(user)){
            session.setAttribute("user",user);
            return "index";
        }else {
            return "register";
        }
    }



    @RequestMapping("/judgeUser")
    private void judgeUser( HttpServletRequest request,HttpServletResponse response)throws Exception{
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user!=null){
            response.getWriter().write(user.getUsername());
        }

    }


    @RequestMapping(value = "/modifyInfo" ,method = RequestMethod.POST)
    private String modifyInfo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws Exception{

        String name = httpServletRequest.getParameter("name");
        String sex = httpServletRequest.getParameter("sex");
        String introduction = httpServletRequest.getParameter("introduction");
        String interests = httpServletRequest.getParameter("interests");
        String email = httpServletRequest.getParameter("email");


        System.out.println("-------------------------------------------------------------");
        System.out.println(name);
        System.out.println(sex);
        System.out.println(introduction);
        System.out.println(interests);
        System.out.println(email);

        httpServletResponse.getWriter().write("true");

        return "info";

    }


}
