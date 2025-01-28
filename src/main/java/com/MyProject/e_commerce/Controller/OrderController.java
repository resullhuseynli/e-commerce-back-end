package com.MyProject.e_commerce.Controller;


import com.MyProject.e_commerce.Service.OrderService;
import com.MyProject.e_commerce.dto.dtoOrders.dtoOrdersRequest;
import com.MyProject.e_commerce.dto.dtoOrders.dtoOrdersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/buy")
    public String createNewOrder(@RequestBody dtoOrdersRequest dtoOrdersRequest) {
        return orderService.createNewOrder(dtoOrdersRequest);
    }

    @GetMapping("get/{id}")
    public dtoOrdersResponse getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/get/all-orders")
    public Map<Long,dtoOrdersResponse> getAllOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrderById(@PathVariable Long id) {
        return orderService.deleteOrderbyId(id) ;
    }
}
