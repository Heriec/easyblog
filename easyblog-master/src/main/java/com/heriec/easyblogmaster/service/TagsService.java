package com.heriec.easyblogmaster.service;

import com.heriec.easyblogmaster.pojo.Tags;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagsService {

    List<Tags> getAllTags();

    int addTags(String[] tags);

    List<Long> getTagsByTagName(String[] tags);

    int addTagsForArticle(@Param("tagIds") List<Long> tagIds, @Param("aid") Long aid);

    int deleteTagsByAid(Long aid);

    int deleteTagsById(String ids);

    int updateTagById(Tags tag);
}
