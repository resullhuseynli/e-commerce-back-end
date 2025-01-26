package com.MyProject.e_commerce.Service.Impl;

import com.MyProject.e_commerce.dto.dtoCategories.dtoCategoriesRequest;
import com.MyProject.e_commerce.dto.dtoCategories.dtoCategoriesResponse;

import java.util.List;

public interface ICategoriesService {

    String addCategory(dtoCategoriesRequest dtoCategoriesRequest);

    String updateCategory(dtoCategoriesRequest dtoCategoriesRequest);

    String deleteCategorybyId(Long id);

    List<dtoCategoriesResponse> getAllCategories();

    dtoCategoriesResponse getCategoryById(Long id);

}
