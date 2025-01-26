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
        List<dtoCategoriesResponse> AllCategries = getAllCategories();
        for (dtoCategoriesResponse response : AllCategries) {
            if (response.getName().equalsIgnoreCase(dtoCategoriesRequest.getName())) {
                return "Category already exists";
            }
        }
        categoriesRepository.save(categories);
        return "Successfully added category";
    }

    @Override
    public String updateCategory(dtoCategoriesRequest dtoCategoriesRequest, Long id) {
        boolean isExists = categoriesRepository.existsById(id) ;
        if (isExists) {
            Categories categories  = categoriesRepository.findById(id).get();
            BeanUtils.copyProperties(dtoCategoriesRequest, categories);
            categoriesRepository.save(categories);
            return "Successfully updated category";
        }
        return "Id not found";
    }

    @Override
    public String deleteCategorybyId(Long id) {
        if (!categoriesRepository.existsById(id)) {
            return "Category does not exist";
        }
        categoriesRepository.deleteById(id);
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
