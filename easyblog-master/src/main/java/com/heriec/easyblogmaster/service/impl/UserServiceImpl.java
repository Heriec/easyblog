package com.heriec.easyblogmaster.service.impl;

import com.heriec.easyblogmaster.dao.RoleDao;
import com.heriec.easyblogmaster.dao.UserDao;
import com.heriec.easyblogmaster.pojo.Role;
import com.heriec.easyblogmaster.pojo.User;
import com.heriec.easyblogmaster.service.UserService;
import com.heriec.easyblogmaster.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User queryUserByUsername(String username) {
        User user = userDao.queryUserByUsername(username);
        return user;
    }

    @Override
    public int updateUserEmail(String email) {
        int i = userDao.updateUserEmail(UserUtil.getCurrentUser().getId(), email);
        return i;
    }

    @Override
    public List<User> getUserByNickname(String nickname) {
        List<User> userByNickname = userDao.getUserByNickname(nickname);
        return userByNickname;
    }

    @Override
    public int updateUserEnabled(Long id, boolean enabled) {
        int i = userDao.updateUserEnabled(id, enabled);
        return i;
    }

    @Override
    public int deleteUserById(Long id) {
        int i = userDao.deleteUserById(id);
        return i;
    }

    @Override
    public int updateUserRoles(Long[] rids, Long id) {
        userDao.deleteUserRoleByUid(id);
        return userDao.setUserRole(id,rids);

    }


    @Override
    public int setUserRole(Long id, Long[] rids) {
        int i = userDao.setUserRole(id, rids);
        return i;
    }

    @Override
    public User getUserById(Long id) {
        User userById = userDao.getUserById(id);
        return userById;
    }

    /**
     * 这是登录判断
     *
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.queryUserByUsername(s);
        System.out.println(user);
        if (user == null)
            return new User();

        List<Role> rolesByUid = roleDao.getRolesByUid(user.getId());
        user.setRoles(rolesByUid);

        return user;
    }


    /**
     * 0表示失败
     * 1表示成功
     * 2表示用户名重复
     *
     * @param user
     * @return
     */
    public int register(User user) {
        User queryUserByUsername = userDao.queryUserByUsername(user.getUsername());
        if (queryUserByUsername != null)
            return 2;
        //密码加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Long login = userDao.login(user);
        String[] roles = {"2"};
        int addRoles = roleDao.addRoles(roles, user.getId());
        boolean flag = false;
        if (addRoles == roles.length && login == 1)
            flag = true;
        if (flag)
            return 1;
        else
            return 0;
    }


}
