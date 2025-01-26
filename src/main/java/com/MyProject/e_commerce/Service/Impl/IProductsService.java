package com.MyProject.e_commerce.Service.Impl;

import com.MyProject.e_commerce.dto.dtoProducts.dtoProductsRequest;
import com.MyProject.e_commerce.dto.dtoProducts.dtoProductsResponse;

import java.util.List;

public interface IProductsService {

    String addNewProduct(dtoProductsRequest dtoProductsRequest);

    String updateProduct(dtoProductsRequest dtoProductsRequest, Long id);

    String deleteProduct(Long id);

    List<dtoProductsResponse> getAllProducts();

    dtoProductsResponse getProductById(Long id);

}
