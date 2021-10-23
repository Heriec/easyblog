package com.heriec.easyblogmaster.dao;

import com.heriec.easyblogmaster.pojo.Role;
import com.heriec.easyblogmaster.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserDao {
    User queryUserByUsername(@Param("username") String username);

    int updateUserEmail(@Param("id") Long id, @Param("email") String email);

    /**
     * 通过昵称查询用户
     *
     * @param nickname
     * @return
     */
    List<User> getUserByNickname(@Param("nickname") String nickname);

    /**
     * 用户是否被禁用
     *
     * @param enabled
     * @param id
     * @return
     */
    int updateUserEnabled(@Param("id") Long id,@Param("enabled") boolean enabled);

    int deleteUserById(Long id);

    int deleteUserRoleByUid(Long id);

    int setUserRole(@Param("id") Long id,@Param("rids") Long[] rids);

    User getUserById(@Param("id") Long id);

    Long login (User user);

}
