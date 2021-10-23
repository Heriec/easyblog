package com.heriec.easyblogmaster.service.impl;

import com.heriec.easyblogmaster.dao.RoleDao;
import com.heriec.easyblogmaster.pojo.Role;
import com.heriec.easyblogmaster.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getAllRole() {
        List<Role> allRole = roleDao.getAllRole();
        return allRole;
    }

    @Override
    public int addRoles(String[] roles, Long uid) {
        int i = roleDao.addRoles(roles, uid);
        return i;
    }

    @Override
    public List<Role> getRolesByUid(Long uid) {
        List<Role> rolesByUid = roleDao.getRolesByUid(uid);
        return rolesByUid;
    }
}
