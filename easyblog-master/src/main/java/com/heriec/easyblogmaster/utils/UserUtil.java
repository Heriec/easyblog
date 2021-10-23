package com.heriec.easyblogmaster.utils;

import com.heriec.easyblogmaster.pojo.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtil {

    public static User getCurrentUser(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}
