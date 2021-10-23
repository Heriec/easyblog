package com.heriec.easyblogmaster.dao;

import com.heriec.easyblogmaster.pojo.Tags;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface TagsDao {

    List<Tags> getAllTags();

    int addTags(@Param("tags") String[] tags);

    List<Long> getTagsByTagName(@Param("tagNames") String[] tagNames);

    int addTagsForArticle(@Param("tagIds") List<Long> tagIds, @Param("aid") Long aid);

    int deleteTagsByAid(Long aid);

    int deleteTagsById(@Param("ids") String[] ids);

    int updateTagById(Tags tag);
}
