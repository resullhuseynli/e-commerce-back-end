package com.MyProject.e_commerce.dto.dtoProducts;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoProductsResponse {

    private String name;

    private double price;

    private int quantity;

    private String category;

}
