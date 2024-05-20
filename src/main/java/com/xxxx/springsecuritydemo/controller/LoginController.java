package com.xxxx.springsecuritydemo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
//    @Secured("ROLE_abc") //注册需要增加ROLE_
    // 允许ROLE_开头，也允许不使用ROLE_开头，比配置类更灵活
    @PreAuthorize("hasAnyRole('abc')")
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