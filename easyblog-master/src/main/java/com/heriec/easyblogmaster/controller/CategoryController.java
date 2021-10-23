package com.heriec.easyblogmaster.controller;

import com.heriec.easyblogmaster.pojo.Category;
import com.heriec.easyblogmaster.service.CategoryService;
import com.heriec.easyblogmaster.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @RequestMapping("/")
    public Message addCategory(Category category) {
        if (category.getCateName().equals("") || category.getCateName() == null)
            return new Message("error", "请输入栏目名称！");

        int addCategory = categoryService.addCategory(category);
        System.out.println(category);
        if (addCategory == 1)
            return new Message("success", "添加成功！");
        return new Message("error", "添加失败！");
    }

    @PutMapping("/")
    public Message updateCategory(Category category){
        int updateCategory = categoryService.updateCategory(category);
        if (updateCategory == 1)
            return new Message("success","修改成功！");
        return new Message("error","修改失败！");
    }
    @DeleteMapping("/{ids}")
    public Message deleteCategory(@PathVariable String ids){
        int deleteCategoryById = categoryService.deleteCategoryById(ids);
        if (deleteCategoryById > 0)
            return new Message("success","删除成功！");
        return new Message("error","删除失败！");
    }
}
