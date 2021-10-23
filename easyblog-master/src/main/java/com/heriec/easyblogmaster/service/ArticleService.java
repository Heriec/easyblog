package com.heriec.easyblogmaster.service;

import com.heriec.easyblogmaster.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleService {
    /**
     * 截取md文件的html标签
     * @param content
     * @return
     */
    String stripHtml(String content);

    int addArticle(Article article);

    int addTagsToArticle(String[] tags, Long aid);

    List<Article> getArticleByState(@Param("state") Integer state, @Param("start") Integer
            page, @Param("count") Integer count,@Param("keywords") String keywords);

    int getArticleCountByState(@Param("state") Integer state, @Param("uid") Long uid, @Param("keywords") String
            keywords);

    int updateArticleState(Long[] aids, Integer state);

    /**
     * 从回收站回收博客
     * @param articleId
     * @return
     */
    int restoreArticle(Integer articleId);

    Article getArticleByAid(Long aid);
}
