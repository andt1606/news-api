package com.laptrinhjavaweb.api;


import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CategoryAPI {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/categories")
    public List<CategoryDTO> show(){
        List<CategoryDTO> results = categoryService.getAllCategories();
        return results;
    }

    @GetMapping(value = "/category/{id}")
    public CategoryDTO showOne(@PathVariable("id") long id) {
        CategoryDTO categoryDTO = categoryService.getOneCategory(id);
        return categoryDTO;
    }


    @PostMapping(value = "/category")
    public CategoryDTO createNew(@RequestBody CategoryDTO model) {
        return categoryService.save(model);
    }

    @PutMapping(value = "/category/{id}")
    public CategoryDTO updateNew(@RequestBody CategoryDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return categoryService.update(model);
    }

    @DeleteMapping(value = "/category")
    public void deleteAllCategory(@RequestBody long[] ids) {
        categoryService.delete(ids);
    }

    @DeleteMapping(value = "/category/{id}")
    public void deleteOneCategory(@PathVariable("id") long id) {
        categoryService.delete(id);
    }
}
