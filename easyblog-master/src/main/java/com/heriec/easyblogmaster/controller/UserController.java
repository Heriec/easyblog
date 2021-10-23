package com.heriec.easyblogmaster.controller;

import com.heriec.easyblogmaster.service.PvService;
import com.heriec.easyblogmaster.service.UserService;
import com.heriec.easyblogmaster.utils.Message;
import com.heriec.easyblogmaster.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private PvService pvService;

    @Autowired
    private UserService userService;

    @RequestMapping("/currentUserName")
    public String currentUserName() {
        return UserUtil.getCurrentUser().getNickname();
    }

    @RequestMapping("/currentUserId")
    public Long currentUserId() {
        return UserUtil.getCurrentUser().getId();
    }

    @RequestMapping("/currentUserEmail")
    public String currentUserEmail() {
        return UserUtil.getCurrentUser().getEmail();
    }

    @RequestMapping("isAdmin")
    public boolean isAdmin() {
        List<GrantedAuthority> authorities = UserUtil.getCurrentUser().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().contains("超级管理员")) {
                return true;
            }
        }
        return false;
    }

    @RequestMapping("/updateUserEmail")
    public Message updateUserEmail(String email) {
        if (userService.updateUserEmail(email)==1)
            return new Message("success","邮件开启成功！");
        return new Message("error","开启失败！");
    }

}
