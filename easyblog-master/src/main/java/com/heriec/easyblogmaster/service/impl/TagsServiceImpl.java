package com.heriec.easyblogmaster.service.impl;

import com.heriec.easyblogmaster.dao.TagsDao;
import com.heriec.easyblogmaster.pojo.Tags;
import com.heriec.easyblogmaster.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagsServiceImpl implements TagsService {

    @Autowired
    private TagsDao tagsDao;

    @Override
    public List<Tags> getAllTags() {
        return tagsDao.getAllTags();
    }

    @Override
    public int addTags(String[] tags) {
        return tagsDao.addTags(tags);
    }

    @Override
    public List<Long> getTagsByTagName(String[] tags) {
        return tagsDao.getTagsByTagName(tags);
    }

    @Override
    public int addTagsForArticle(List<Long> tagIds, Long aid) {
        return tagsDao.addTagsForArticle(tagIds, aid);
    }

    @Override
    public int deleteTagsByAid(Long aid) {
        return tagsDao.deleteTagsByAid(aid);
    }

    @Override
    public int deleteTagsById(String ids) {
        String[] split = ids.split(",");
        return tagsDao.deleteTagsById(split);
    }

    @Override
    public int updateTagById(Tags tag) {
        return tagsDao.updateTagById(tag);
    }
}
