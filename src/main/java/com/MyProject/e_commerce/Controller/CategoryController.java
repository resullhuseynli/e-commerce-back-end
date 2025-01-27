package com.MyProject.e_commerce.Controller;


import com.MyProject.e_commerce.Service.CategoriesService;
import com.MyProject.e_commerce.dto.dtoCategories.dtoCategoriesRequest;
import com.MyProject.e_commerce.dto.dtoCategories.dtoCategoriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/get/all-list")
    public List<dtoCategoriesResponse> getAllCategories() {
        return categoriesService.getAllCategories();
    }

    @GetMapping("/get/{id}")
    public dtoCategoriesResponse getCategorybyId(@PathVariable Long id) {
        return categoriesService.getCategoryById(id) ;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        return categoriesService.deleteCategorybyId(id) ;
    }

    @PostMapping("/post/new")
    public String addNewCategory(@RequestBody dtoCategoriesRequest request) {
        return categoriesService.addCategory(request);
    }

    @PutMapping("/update/{id}")
    public String updateCategory(@PathVariable Long id, @RequestBody dtoCategoriesRequest request) {
        return categoriesService.updateCategory(request, id);
    }

}
