package com.heriec.easyblogmaster.dao;

import com.heriec.easyblogmaster.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface CategoryDao {
    List<Category> getAllCategory();

    int deleteCategoryById(@Param("ids") String[] ids);

    int addCategory(Category category);

    int updateCategory(Category category);
}
