package com.MyProject.e_commerce.dto.dtoProducts;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class dtoProductsRequest {

    private String name;

    private double price;

    private int quantity;

    private Long categoryId;
}
