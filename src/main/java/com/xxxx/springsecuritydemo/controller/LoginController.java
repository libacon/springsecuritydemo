package com.xxxx.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

//    @RequestMapping("loin")
//    public String login(){
//        System.out.println("执行登录方法");
//        return "redirect:main.html";
//    }

    /**
     * 登录成功后post跳转至成功页
     * @return 跳转地址
     */
    @RequestMapping("/toMain")
    public String main(){
        return "redirect:main.html";
    }

    /**
     * 登录失败后post跳转至失败页
     * @return 跳转地址
     */
    @RequestMapping("/toError")
    public String logError(){
        return "redirect:error.html";
    }

}