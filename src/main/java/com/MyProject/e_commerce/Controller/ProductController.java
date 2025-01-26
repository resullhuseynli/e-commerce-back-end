package com.MyProject.e_commerce.Controller;

import com.MyProject.e_commerce.Model.Products;
import com.MyProject.e_commerce.Service.ProductsService;
import com.MyProject.e_commerce.dto.dtoProducts.dtoProductsRequest;
import com.MyProject.e_commerce.dto.dtoProducts.dtoProductsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/get/all-list")
    public List<dtoProductsResponse> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping("/get/{id}")
    public dtoProductsResponse getProductById(@PathVariable Long id) {
        return productsService.getProductById(id);
    }


    @PostMapping("/add/new")
    public String addNewProduct(@RequestBody dtoProductsRequest products) {
        return productsService.addNewProduct(products);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productsService.deleteProduct(id) ;
    }

    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody dtoProductsRequest products) {
        return productsService.updateProduct(products, id) ;
    }
}
