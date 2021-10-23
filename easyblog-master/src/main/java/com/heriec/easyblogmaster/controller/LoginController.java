package com.heriec.easyblogmaster.controller;

import com.heriec.easyblogmaster.pojo.Role;
import com.heriec.easyblogmaster.pojo.User;
import com.heriec.easyblogmaster.service.RoleService;
import com.heriec.easyblogmaster.service.UserService;
import com.heriec.easyblogmaster.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    /**
     * 如果自动跳转到这个页面，说明用户未登录，返回相应的提示即可
     * <p>
     * 如果要支持表单登录，可以在这个方法中判断请求的类型，进而决定返回JSON还是HTML页面
     *
     * @return
     */
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/login_page")
    @ResponseBody
    public Message loginPage() {
        return new Message("error", "尚未登录，请登录!");
    }

    @RequestMapping("/login_error")
    @ResponseBody
    public Message loginError() {
        return new Message("error", "登录失败!");
    }

    @RequestMapping("/login_success")
    @ResponseBody
    public Message loginSuccess() {
        return new Message("success", "登录成功!");
    }

    /**
     * 0表示成功
     * 1表示失败
     * 2表示用户名重复
     *
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public Message register(User user) {
        int register = userService.register(user);
        if (register == 0) {
            return new Message("success", "注册成功！");
        } else if (register == 1) {
            return new Message("error", "用户名重复，注册失败！");
        } else {
            return new Message("error","注册失败！");
        }
    }
}
