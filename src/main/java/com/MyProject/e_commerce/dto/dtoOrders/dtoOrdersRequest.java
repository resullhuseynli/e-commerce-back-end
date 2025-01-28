package com.MyProject.e_commerce.dto.dtoOrders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoOrdersRequest {

    private Map<Long, Integer> products;  //Long is product Id , Integer is product quantity

}
