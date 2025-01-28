package com.MyProject.e_commerce.Service;

import com.MyProject.e_commerce.Model.OrderProducts;
import com.MyProject.e_commerce.Model.Orders;
import com.MyProject.e_commerce.Model.Products;
import com.MyProject.e_commerce.Repository.OrderProductsRepository;
import com.MyProject.e_commerce.Repository.OrdersRepository;
import com.MyProject.e_commerce.Repository.ProductsRepository;
import com.MyProject.e_commerce.Service.Impl.IOrderService;
import com.MyProject.e_commerce.dto.dtoOrders.dtoOrdersRequest;
import com.MyProject.e_commerce.dto.dtoOrders.dtoOrdersResponse;
import com.MyProject.e_commerce.dto.dtoProducts.dtoProductsResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService implements IOrderService {


    @Autowired
    private OrdersRepository ordersRepository;


    @Autowired
    private ProductsRepository productsRepository;


    @Autowired
    private OrderProductsRepository orderProductsRepository;


    @Override
    public dtoOrdersResponse getOrderById(Long id) {
        Orders order = ordersRepository.findById(id).orElse(null);
        dtoOrdersResponse response = new dtoOrdersResponse();
        List<dtoProductsResponse> dtoProductsResponseList = new ArrayList<>();
        assert order != null;
        response.setDate(order.getDate());
        response.setTotalprice(order.getTotalprice());
        List<Products> productsList = orderProductsRepository.getOrderbyId(id);
        if (productsList != null) {
            for (Products product : productsList) {
                dtoProductsResponse dtoProductsResponse = new dtoProductsResponse();
                Long productId = product.getId();
                dtoProductsResponse.setName(product.getName());
                dtoProductsResponse.setPrice(product.getPrice());
                dtoProductsResponse.setCategory(product.getCategory().getName());
                dtoProductsResponse.setQuantity(orderProductsRepository.getQuantityofProduct(id,productId));
                dtoProductsResponseList.add(dtoProductsResponse);
            }

            response.setProductsList(dtoProductsResponseList);
            return response;

        }
        return null;
    }



    @Transactional
    @Override
    public String createNewOrder(dtoOrdersRequest dtoOrders) {
        Orders order = new Orders();
        List<Long> unavailableProducts = new ArrayList<>();
        List<Long> notenoughProducts = new ArrayList<>();
        double totalprice = 0;
        order.setDate(new Date());
        Map<Long,Integer> products = dtoOrders.getProducts();

        for (Long productId : products.keySet()) {
            OrderProducts orderProducts = new OrderProducts();
            Products product = productsRepository.findById(productId).orElse(null);
            Integer quantity = products.get(productId) ;
            orderProducts.setQuantity(quantity);
            orderProducts.setProduct(product);
            orderProducts.setOrder(order);
            if (product != null) {
                if (product.getQuantity() >= quantity){
                    buyProduct(productId, quantity);
                    totalprice += (product.getPrice() * quantity) ;
                    orderProductsRepository.save(orderProducts);
                } else {
                    notenoughProducts.add(productId) ;
                }
            } else {
                unavailableProducts.add(productId);
            }
        }
        ordersRepository.setTotalPrice(totalprice , order.getId());

        if (!unavailableProducts.isEmpty() || !notenoughProducts.isEmpty()) {
            return "Products were not found: " + unavailableProducts +
                    "\nWe have not enough products in Stock: " + notenoughProducts +
                    "\nOrder created successfully" ;
        }

        return "Order created successfully" +
                "\nOrder Id:" + order.getId();
    }



    @Transactional
    public void buyProduct(Long id, int quantity) {
        productsRepository.buyProducts(id, quantity) ;
    }


    @Transactional
    @Override
    public String deleteOrderbyId(Long id) {
        if (ordersRepository.existsById(id)) {
            List<Long> productIds = orderProductsRepository.listProductIdsByOrderId(id) ;
            for (Long productId : productIds) {
                productsRepository.returnProducts(productId,orderProductsRepository.getQuantityofProduct(id,productId));
            }
            orderProductsRepository.deleteByOrderId(id);
            ordersRepository.deleteById(id);
            return "Successfuly deleted!";
        }
        return "Order not found";
    }



    @Override
    public Map<Long,dtoOrdersResponse> getAllOrders() {

        Map<Long,dtoOrdersResponse> orders = new HashMap<>();
        List<Long> orderIds = orderProductsRepository.getAllOrderIds();
        for (Long orderId : orderIds) {
            orders.put(orderId , getOrderById(orderId)) ;
        }
        return orders;
    }

}
