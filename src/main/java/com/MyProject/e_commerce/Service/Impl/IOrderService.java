package com.MyProject.e_commerce.Service.Impl;

import com.MyProject.e_commerce.dto.dtoOrders.dtoOrdersRequest;
import com.MyProject.e_commerce.dto.dtoOrders.dtoOrdersResponse;

import java.util.Map;

public interface IOrderService {

    dtoOrdersResponse getOrderById(Long id);

    String createNewOrder(dtoOrdersRequest dtoOrders);

    String deleteOrderbyId(Long id);

    Map<Long,dtoOrdersResponse> getAllOrders();
}
