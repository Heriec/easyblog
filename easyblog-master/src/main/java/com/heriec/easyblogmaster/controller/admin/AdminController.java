package com.heriec.easyblogmaster.controller.admin;

import com.heriec.easyblogmaster.pojo.Article;
import com.heriec.easyblogmaster.pojo.Role;
import com.heriec.easyblogmaster.pojo.User;
import com.heriec.easyblogmaster.service.ArticleService;
import com.heriec.easyblogmaster.service.RoleService;
import com.heriec.easyblogmaster.service.UserService;
import com.heriec.easyblogmaster.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/user")
    public List<User> getUserByNickName(String nickname) {
        List<User> userByNickname = userService.getUserByNickname(nickname);
        return userByNickname;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/roles")
    public List<Role> getAllRole() {
        return roleService.getAllRole();
    }

    @RequestMapping("/user/enabled")
    public Message updateUserEnabled(Boolean enabled, Long uid) {
        int i = userService.updateUserEnabled(uid, enabled);
        if (i == 1)
            return new Message("success", "更新成功！");
        else
            return new Message("error", "更新失败");
    }

    @DeleteMapping("/user/{uid}")
    public Message deleteUserById(@PathVariable Long uid){
        if (userService.deleteUserById(uid) == 1)
            return new Message("success","删除成功！");
        return new Message("erroe","删除失败！");
    }
    @PutMapping("/user/role")
    public Message updateUserRoles(Long[] rids, Long id) {
        if (userService.updateUserRoles(rids, id) == rids.length)
            return new Message("success","更新成功！");
        else
            return new Message("error","更新失败！");
    }

    /**
     * state为-2的时候就是  admin可查博客管理
     *
     * @param page
     * @param count
     * @param keywords
     * @return
     */
    @GetMapping("/article/all")
    public Map<String, Object> getArticleByStateByAdmin(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "count", defaultValue = "6") Integer count, String keywords) {
        List<Article> articles = articleService.getArticleByState(-2, page, count, keywords);
        Map<String, Object> map = new HashMap<>();
        map.put("articles", articles);
        map.put("totalCount", articleService.getArticleCountByState(1, null, keywords));
        return map;
    }
    @PutMapping( "/article/dustbin")
    public Message updateArticleState(Long[] aids, Integer state) {
        if (articleService.updateArticleState(aids, state) == aids.length) {
            return new Message("success", "删除成功!");
        }
        return new Message("error", "删除失败!");
    }
}
