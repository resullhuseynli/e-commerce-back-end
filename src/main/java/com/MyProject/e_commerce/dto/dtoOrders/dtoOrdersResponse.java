package com.MyProject.e_commerce.dto.dtoOrders;

import com.MyProject.e_commerce.dto.dtoProducts.dtoProductsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoOrdersResponse {

    private double totalprice;

    private Date date;

    private List<dtoProductsResponse> productsList;

}
