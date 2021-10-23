package com.heriec.easyblogmaster.service;

import com.heriec.easyblogmaster.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    public User queryUserByUsername(@Param("username") String username);

    public int updateUserEmail(@Param("email") String email);

    /**
     * 通过昵称查询用户
     *
     * @param nickname
     * @return
     */
    public List<User> getUserByNickname(@Param("nickname") String nickname);

    /**
     * 用户是否被禁用
     *
     * @param id
     * @param enabled
     * @return
     */
    public int updateUserEnabled(Long id, @Param("enabled") boolean enabled);

    public int deleteUserById(Long id);

    public int updateUserRoles(Long[] rids, Long id);

    public int setUserRole(@Param("id") Long id, @Param("rids") Long[] rids);

    public User getUserById(@Param("id") Long id);

    public int register(User user);


}
