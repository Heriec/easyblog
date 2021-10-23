package com.heriec.easyblogmaster.service.impl;

import com.heriec.easyblogmaster.dao.ArticleDao;
import com.heriec.easyblogmaster.dao.TagsDao;
import com.heriec.easyblogmaster.pojo.Article;
import com.heriec.easyblogmaster.pojo.Tags;
import com.heriec.easyblogmaster.service.ArticleService;
import com.heriec.easyblogmaster.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private TagsDao tagsDao;

    @Override
    public String stripHtml(String content) {
        content = content.replaceAll("<p .*?", "");
        content = content.replaceAll("<br\\s*/?", "");
        content = content.replaceAll("\\<.*?>", "");
        return content;
    }

    @Override
    public int addArticle(Article article) {

        //如果summary里面没有文章，那么就截取html里面的内容放到summary里面
        if (article.getSummary() == null || article.getSummary().equals("")) {
            String s = stripHtml(article.getHtmlContent());
            article.setSummary(s.substring(0, s.length() > 50 ? 50 : s.length()));
        }
        //如果文章是没有id的，就是要添加的文章
        if (article.getId() == -1) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            if (article.getState() == 1) {
                article.setPublishDate(timestamp);
            }
            article.setEditTime(timestamp);
            //设置用户信息
            article.setUid(UserUtil.getCurrentUser().getId());
            int addArticle = articleDao.addArticle(article);
            String[] dynamicTags = article.getDynamicTags();
            if (dynamicTags != null && dynamicTags.length > 0) {
                int tags = addTagsToArticle(dynamicTags, article.getId());
                if (tags == -1)
                    return tags;
            }
            return addArticle;
        } else {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            if (article.getState() == 1) {
                //设置发表日期
                article.setPublishDate(timestamp);
            }
            //更新
            article.setEditTime(timestamp);
            int article1 = articleDao.updateArticle(article);
            //修改标签
            String[] dynamicTags = article.getDynamicTags();
            if (dynamicTags != null && dynamicTags.length > 0) {
                int tags = addTagsToArticle(dynamicTags, article.getId());
                if (tags == -1) {
                    return tags;
                }
            }
            return article1;
        }

    }

    /**
     * 为文章添加标签，先要把之前的标签都给我删掉，我也不知道这样效率会不会太慢
     *
     * @param tags
     * @param aid
     * @return
     */
    @Override
    public int addTagsToArticle(String[] tags, Long aid) {
        tagsDao.deleteTagsByAid(aid);
        List<Tags> allTags = tagsDao.getAllTags();

        List<String> tagsArrayList = new ArrayList<>(Arrays.asList(tags));
        ArrayList<String> newTags = new ArrayList<>();
        for (int i = 0; i < tagsArrayList.size(); i++) {
            int count = 0;
            for (Tags allTag : allTags) {
                if (tagsArrayList.get(i).equals(allTag.getTagName())) {
                    count++;
                }
            }
            if (count == 0)
                newTags.add(tagsArrayList.get(i));
        }
        String[] strs2 = new String[newTags.size()];
        for (int i = 0; i < newTags.size(); i++) {
            strs2[i] = newTags.get(i);
        }
        if (strs2.length != 0)
            tagsDao.addTags(strs2);
        List<Long> tagsByTagName = tagsDao.getTagsByTagName(tags);
        int i = tagsDao.addTagsForArticle(tagsByTagName, aid);
        return i == tags.length ? i : -1;
    }


    @Override
    public List<Article> getArticleByState(Integer state, Integer page, Integer count, String keywords) {
        int start = (page - 1) * count;
        return articleDao.getArticleByState(state, start, count, UserUtil.getCurrentUser().getId(), keywords);
    }

    @Override
    public int getArticleCountByState(Integer state, Long uid, String keywords) {
        return articleDao.getArticleCountByState(state, uid, keywords);
    }

    /**
     * 将文章修改进入到回收站中，你不可能把一个已发布的文章重新放到草稿中吧
     *
     * @param aids
     * @param state
     * @return
     */
    @Override
    public int updateArticleState(Long[] aids, Integer state) {
        if (state == 2) {
            return articleDao.deleteArticleById(aids);
        } else {
            return articleDao.updateArticleState(aids, 2);
        }
    }

    @Override
    public int restoreArticle(Integer articleId) {
        return articleDao.updateArticleStateByAid(articleId, 1);
    }


    @Override
    public Article getArticleByAid(Long aid) {
        Article article = articleDao.getArticleByAid(aid);
        return article;
    }
}
