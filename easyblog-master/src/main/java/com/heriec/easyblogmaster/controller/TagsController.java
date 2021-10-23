package com.heriec.easyblogmaster.controller;


import com.heriec.easyblogmaster.pojo.Article;
import com.heriec.easyblogmaster.pojo.Category;
import com.heriec.easyblogmaster.pojo.Tags;
import com.heriec.easyblogmaster.service.TagsService;
import com.heriec.easyblogmaster.utils.Message;
import com.heriec.easyblogmaster.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tags")
public class TagsController {

    @Autowired
    private TagsService tagsService;

    @GetMapping("/all")
    public List<Tags> getAllTags() {
        return tagsService.getAllTags();
    }

    @RequestMapping("/")
    public Message addTag(Tags tag) {
        if (tag.getTagName().equals("") || tag.getTagName() == null)
            return new Message("error", "请输入tag名称！");

        int addCategory = tagsService.addTags(new String[]{tag.getTagName()});
        if (addCategory == 1)
            return new Message("success", "添加成功！");
        return new Message("error", "添加失败！");
    }

    @PutMapping("/")
    public Message updateTag(Tags tag) {
        int updateTagById = tagsService.updateTagById(tag);
        if (updateTagById == 1)
            return new Message("success", "修改成功！");
        return new Message("error", "修改失败！");
    }

    @DeleteMapping("/{ids}")
    public Message deleteTags(@PathVariable String ids) {
        int deleteTagsById = tagsService.deleteTagsById(ids);
        if (deleteTagsById > 0)
            return new Message("success", "删除成功！");
        return new Message("error", "删除失败！");
    }
}
