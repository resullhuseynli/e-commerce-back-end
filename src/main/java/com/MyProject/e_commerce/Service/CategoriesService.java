package com.MyProject.e_commerce.Service;

import com.MyProject.e_commerce.Model.Categories;
import com.MyProject.e_commerce.Repository.CategoriesRepository;
import com.MyProject.e_commerce.Service.Impl.ICategoriesService;
import com.MyProject.e_commerce.dto.dtoCategories.dtoCategoriesRequest;
import com.MyProject.e_commerce.dto.dtoCategories.dtoCategoriesResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService implements ICategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;


    @Override
    public String addCategory(dtoCategoriesRequest dtoCategoriesRequest) {
        Categories categories = new Categories();
        BeanUtils.copyProperties(dtoCategoriesRequest, categories);
        categoriesRepository.save(categories);
        if (getCategoryById(categories.getId()) != null) {
            return "Successfully added category";
        }
        return "Category already exists";
    }

    @Override
    public String updateCategory(dtoCategoriesRequest dtoCategoriesRequest) {
        return "";
    }

    @Override
    public String deleteCategorybyId(Long id) {
        categoriesRepository.deleteById(id);
        if (categoriesRepository.existsById(id)) {
            return "Category does not exist";
        }
        return "Category deleted sucessfully";
    }

    @Override
    public List<dtoCategoriesResponse> getAllCategories() {
        List<Categories> categoriesList = categoriesRepository.findAll();
        List<dtoCategoriesResponse> categoriesResponseList = new ArrayList<>();
        for (Categories categories : categoriesList) {
            dtoCategoriesResponse dtoCategoriesResponse = new dtoCategoriesResponse();
            dtoCategoriesResponse.setName(categories.getName());
            categoriesResponseList.add(dtoCategoriesResponse);
        }
        return categoriesResponseList;
    }

    @Override
    public dtoCategoriesResponse getCategoryById(Long id) {
        Optional<Categories> categories =  categoriesRepository.findById(id);
        dtoCategoriesResponse dtoCategoriesResponse = new dtoCategoriesResponse();
        BeanUtils.copyProperties(categories, dtoCategoriesResponse);
        return dtoCategoriesResponse;
    }
}
