package com.heriec.easyblogmaster.service;

import com.heriec.easyblogmaster.pojo.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategory();

    int deleteCategoryById(String ids);

    int addCategory(Category category);

    int updateCategory(Category category);
}
