package com.MyProject.e_commerce.Controller;


import com.MyProject.e_commerce.Service.CategoriesService;
import com.MyProject.e_commerce.Service.ProductsService;
import com.MyProject.e_commerce.dto.dtoCategories.dtoCategoriesRequest;
import com.MyProject.e_commerce.dto.dtoCategories.dtoCategoriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class Controller {

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private ProductsService productsService;

    @GetMapping("/get/all-categories")
    public List<dtoCategoriesResponse> getAllCategories() {
        return categoriesService.getAllCategories();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        return categoriesService.deleteCategorybyId(id) ;
    }

    @PostMapping("/add/new-category")
    public String addNewCategory(@RequestBody dtoCategoriesRequest request) {
        return categoriesService.addCategory(request);
    }
}
