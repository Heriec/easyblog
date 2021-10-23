package com.heriec.easyblogmaster.controller;

import com.heriec.easyblogmaster.pojo.Article;
import com.heriec.easyblogmaster.service.ArticleService;
import com.heriec.easyblogmaster.utils.Message;
import com.heriec.easyblogmaster.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/article")
public class ArticleController {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private ArticleService articleService;

    @PostMapping("/")
    public Message addArticle(Article article) {
        int result = articleService.addArticle(article);
        if (result == 1) {
            return new Message("success", article.getId() + "");
        } else {
            return new Message("error", article.getState() == 0 ? "文章保存失败!" : "文章发表失败!");
        }
    }
//
//    /**
//     * 上传图片
//     * @param req
//     * @param image
//     * @return
//     */
//    public Message uploadImg(HttpServletRequest req, MultipartFile image) {
//    }

    @GetMapping("/all")
    public Map<String, Object> getArticleByState(@RequestParam(value = "state", defaultValue = "-1") Integer state, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "count", defaultValue = "6") Integer count, String keywords) {
        int totalCount = articleService.getArticleCountByState(state, UserUtil.getCurrentUser().getId(), keywords);
        List<Article> articleByState = articleService.getArticleByState(state, page, count, keywords);
        HashMap<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);
        map.put("articles", articleByState);
        return map;
    }

    @GetMapping("/{aid}")
    public Article getArticleByAid(@PathVariable Long aid) {
        return articleService.getArticleByAid(aid);
    }

    @PutMapping("/dustbin")
    public Message updateArticleState(Long[] aids, Integer state) {
        if (articleService.updateArticleState(aids, state) == aids.length)
            return new Message("success", "删除成功！");
        return new Message("error", "删除失败!");
    }

    @PutMapping("/restore")
    public Message restoreArticle(Integer articleId) {
        if (articleService.restoreArticle(articleId) == 1)
            return new Message("success","还原成功！");
        return new Message("error","还原失败！");
    }

}