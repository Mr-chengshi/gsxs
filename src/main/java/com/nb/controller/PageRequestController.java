package com.nb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class PageRequestController {

    @RequestMapping("/register")
    public String register(){

        return "register";
    }

    @RequestMapping("/header")
    private String header(){
        return "header";

    }

    @RequestMapping("/footer")
    private String footer(){
        return "footer";

    }

    @RequestMapping("/index")
    private String index(){
        return "index";

    }

    @RequestMapping("/info")
    private String info(HttpSession session,ModelAndView modelAndView) throws JsonProcessingException {

        return "info";

    }
}
