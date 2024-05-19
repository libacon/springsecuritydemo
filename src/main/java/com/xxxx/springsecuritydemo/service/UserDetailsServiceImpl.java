package com.xxxx.springsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder pw;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("----start permit!");
        //1. 查询数据库判断用户是否存在，不存在，返回UsernameNotFoundException
        if(!"admin".equals(username)){
            throw new UsernameNotFoundException("用户不存在");
        }
        //2. 把查询出的密码解析判断
        String password = pw.encode("123");

        return new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }
}
