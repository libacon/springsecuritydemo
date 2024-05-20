package com.xxxx.springsecuritydemo.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface MyService {
    boolean hasPermisson(HttpServletRequest request, Authentication authentication);
}
