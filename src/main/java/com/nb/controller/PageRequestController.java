package com.nb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private String info(){
        return "info";

    }
}
