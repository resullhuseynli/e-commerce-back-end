package com.MyProject.e_commerce.Service.Impl;

import com.MyProject.e_commerce.dto.dtoProducts.dtoProductsRequest;
import com.MyProject.e_commerce.dto.dtoProducts.dtoProductsResponse;

import java.util.List;

public interface IProductsService {

    public String addProduct(dtoProductsRequest dtoProductsRequest);

    public String updateProduct(dtoProductsRequest dtoProductsRequest);

    public String deleteProduct(dtoProductsRequest dtoProductsRequest);

    public List<dtoProductsResponse> getAllProducts();

}
