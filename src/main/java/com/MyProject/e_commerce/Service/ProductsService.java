package com.MyProject.e_commerce.Service;

import com.MyProject.e_commerce.Model.Categories;
import com.MyProject.e_commerce.Model.Products;
import com.MyProject.e_commerce.Repository.CategoriesRepository;
import com.MyProject.e_commerce.Repository.ProductsRepository;
import com.MyProject.e_commerce.Service.Impl.IProductsService;
import com.MyProject.e_commerce.dto.dtoProducts.dtoProductsRequest;
import com.MyProject.e_commerce.dto.dtoProducts.dtoProductsResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService implements IProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public String addNewProduct(dtoProductsRequest dtoProductsRequest) {
        Products products = new Products();
        BeanUtils.copyProperties(dtoProductsRequest, products);
        Optional<Categories> category = categoriesRepository.findById(dtoProductsRequest.getCategoryId()) ;
        if (category.isEmpty()) {
            return "Category Not Found";
        }
        products.setCategory(category.get());
        productsRepository.save(products);
        return "Product added successfully";
    }

    @Override
    public String updateProduct(dtoProductsRequest dtoProductsRequest, Long id) {
        boolean exists = productsRepository.existsById(id);
        if (exists) {
            Products products = productsRepository.findById(id).get();
            BeanUtils.copyProperties(dtoProductsRequest, products);
            products.setCategory(categoriesRepository.findById(dtoProductsRequest.getCategoryId()).get());
            productsRepository.save(products);
            return "Product updated successfully";
        }
        return "Product Not Found";
    }

    @Override
    public String deleteProduct(Long id) {
        if (!productsRepository.existsById(id)) {
            return "Product Not Found";
        }
        productsRepository.deleteById(id);
        return "Product deleted successfully";
    }

    @Override
    public List<dtoProductsResponse> getAllProducts() {
        List<Products> productsList = productsRepository.findAll();
        List<dtoProductsResponse> productsResponseList = new ArrayList<>();
        for (Products products : productsList) {
            dtoProductsResponse dtoProductsResponse = new dtoProductsResponse();
            BeanUtils.copyProperties(products, dtoProductsResponse);
            dtoProductsResponse.setCategory(products.getCategory().getName());
            productsResponseList.add(dtoProductsResponse);
        }
        return productsResponseList;
    }

    @Override
    public dtoProductsResponse getProductById(Long id) {
        Optional<Products> product = productsRepository.findById(id);
        if (product.isPresent()) {
            dtoProductsResponse dtoProductsResponse = new dtoProductsResponse();
            BeanUtils.copyProperties(product, dtoProductsResponse);
            return dtoProductsResponse;
        }
        return null;
    }
}
