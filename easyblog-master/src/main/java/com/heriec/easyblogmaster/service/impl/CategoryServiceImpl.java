package com.heriec.easyblogmaster.service.impl;

import com.heriec.easyblogmaster.dao.CategoryDao;
import com.heriec.easyblogmaster.pojo.Category;
import com.heriec.easyblogmaster.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryService;

    @Override
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @Override
    public int deleteCategoryById(String ids) {
        String[] split = ids.split(",");
        return categoryService.deleteCategoryById(split);
    }

    @Override
    public int addCategory(Category category) {
        category.setDate(new Timestamp(System.currentTimeMillis()));
        return categoryService.addCategory(category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryService.updateCategory(category);
    }
}
