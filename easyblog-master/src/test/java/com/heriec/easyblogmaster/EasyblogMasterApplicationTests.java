package com.heriec.easyblogmaster;



import com.heriec.easyblogmaster.pojo.Role;
import com.heriec.easyblogmaster.pojo.Tags;
import com.heriec.easyblogmaster.pojo.User;
import com.heriec.easyblogmaster.service.RoleService;
import com.heriec.easyblogmaster.service.TagsService;
import com.heriec.easyblogmaster.service.UserService;
import com.heriec.easyblogmaster.service.impl.TagsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EasyblogMasterApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    TagsService tagsService;

    @Test
    void contextLoads() {
        List<User> userByNickname = userService.getUserByNickname("乔峰");
        for (User user : userByNickname) {
            System.out.println(user);
        }
    }
    @Test
    void contextLoads2() {
        int i = userService.setUserRole(20L, new Long[]{Long.valueOf(4), Long.valueOf(5)});
        System.out.println(i);
    }
    @Test
    void contextLoads3() {
        User sang = userService.queryUserByUsername("sang");
        System.out.println(sang);
    }

    @Test
    void contextLoads4() {
        List<Role> allRole = roleService.getAllRole();
        for (Role role : allRole) {
            System.out.println(role);
        }
    }

    @Test
    void contextLoads5() {
        List<Role> rolesByUid = roleService.getRolesByUid(6L);
        for (Role role : rolesByUid) {
            System.out.println(role);
        }
    }

    @Test
    void contextLoads6() {
        List<Tags> allTags = tagsService.getAllTags();
        for (Tags role : allTags) {
            System.out.println(role);
        }
    }
}
