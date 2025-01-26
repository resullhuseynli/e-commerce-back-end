package com.MyProject.e_commerce.Service;

import com.MyProject.e_commerce.Repository.ProductsRepository;
import com.MyProject.e_commerce.Service.Impl.IProductsService;
import com.MyProject.e_commerce.dto.dtoProducts.dtoProductsRequest;
import com.MyProject.e_commerce.dto.dtoProducts.dtoProductsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService implements IProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public String addProduct(dtoProductsRequest dtoProductsRequest) {
        return "";
    }

    @Override
    public String updateProduct(dtoProductsRequest dtoProductsRequest) {
        return "";
    }

    @Override
    public String deleteProduct(dtoProductsRequest dtoProductsRequest) {
        return "";
    }

    @Override
    public List<dtoProductsResponse> getAllProducts() {
        return List.of();
    }
}
