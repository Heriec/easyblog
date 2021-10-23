package com.heriec.easyblogmaster.service;

import com.heriec.easyblogmaster.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    /**
     * 得到所有职责，用于前端下拉表显示
     *
     * @return
     */
    List<Role> getAllRole();

    int addRoles(@Param("roles") String[] roles, @Param("uid") Long uid);

    List<Role> getRolesByUid(Long uid);
}

