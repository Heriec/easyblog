package com.heriec.easyblogmaster.dao;

import com.heriec.easyblogmaster.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleDao {
    /**
     * 得到所有职责，用于前端下拉表显示
     *
     * @return
     */
    List<Role> getAllRole();


    int addRoles(@Param("roles") String[] roles, @Param("uid") Long uid);

    List<Role> getRolesByUid(Long uid);}
