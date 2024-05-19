package com.xxxx.springsecuritydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * securedEnabled：控制器方法上增加注解， @Secured("ROLE_abc")
 * prePosEnabled; 控制器方法上增加注解， @PreAuthorize("hasAnyRole('abc')") Post前判断权限
 */
@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class SpringsecuritydemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecuritydemoApplication.class, args);
    }

}
