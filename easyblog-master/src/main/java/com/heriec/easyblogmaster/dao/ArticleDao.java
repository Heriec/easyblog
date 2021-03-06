package com.heriec.easyblogmaster.dao;


import com.heriec.easyblogmaster.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleDao {

    int addArticle(Article article);

    int updateArticle(Article article);

    List<Article> getArticleByState(@Param("state") Integer state, @Param("start") Integer start, @Param("count") Integer count, @Param("uid") Long uid, @Param("keywords") String keywords);

    int getArticleCountByState(@Param("state") Integer state, @Param("uid") Long uid, @Param("keywords") String keywords);

    int updateArticleState(@Param("aids") Long[] aids, Integer state);

    int updateArticleStateByAid(@Param("aid") Integer aid, @Param("state") Integer state);

    int deleteArticleById(@Param("aids") Long[] aids);

    Article getArticleByAid(Long aid);

}
