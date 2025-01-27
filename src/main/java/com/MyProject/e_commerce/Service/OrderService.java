package com.MyProject.e_commerce.Service;

import com.MyProject.e_commerce.Model.Orders;
import com.MyProject.e_commerce.Model.Products;
import com.MyProject.e_commerce.Repository.OrdersRepository;
import com.MyProject.e_commerce.Repository.ProductsRepository;
import com.MyProject.e_commerce.Service.Impl.IOrderService;
import com.MyProject.e_commerce.dto.dtoOrders.dtoOrdersRequest;
import com.MyProject.e_commerce.dto.dtoOrders.dtoOrdersResponse;
import com.MyProject.e_commerce.dto.dtoProducts.dtoProductsResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
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
    private ProductsService productsService;

    @Override
    public dtoOrdersResponse getOrderById(Long id) {
// TAMAMLANMAYIB
        List<dtoProductsResponse> productsList  = new ArrayList<>();
        dtoOrdersResponse dtoOrdersResponse = new dtoOrdersResponse();
        dtoProductsResponse dtoProductsResponse = new dtoProductsResponse();
        Optional<Orders> orders = ordersRepository.findById(id);
        if (orders.isPresent()) {
            Orders order = orders.get();
            BeanUtils.copyProperties(order, dtoOrdersResponse);
            for (Products product : order.getProducts()) {
                BeanUtils.copyProperties(product, dtoProductsResponse);
                productsList.add(dtoProductsResponse);
            }
            dtoOrdersResponse.setProductsList(productsList);

        } else {
            return null ;
        }

        return dtoOrdersResponse;
    }


    @Transactional
    @Override
    public String createNewOrder(dtoOrdersRequest dtoOrders) {
        Orders order = new Orders();
        List<Products> productslist = new ArrayList<>();
        List<Long> unavailableProducts = new ArrayList<>();
        double totalprice = 0;
        order.setDate(new Date());
        Map<Long,Integer> products = dtoOrders.getProducts();
        int totalquantity = 0 ;

        for (Long productId : products.keySet()) {
            Optional<Products> product = productsRepository.findById(productId);
            Integer quantity = products.get(productId) ;
            if (product.isPresent() && product.get().getQuantity() >= quantity) {
                totalquantity += quantity;
                buyProduct(productId, quantity);
                totalprice += (product.get().getPrice() * quantity) ;
                productslist.add(product.get());
            } else {
                unavailableProducts.add(productId);
            }
        }
        order.setTotalquantity(totalquantity);
        order.setProducts(productslist);
        order.setTotalprice(totalprice);
        ordersRepository.save(order);

        if (!unavailableProducts.isEmpty()) {
            return "Products were not available: " + unavailableProducts +
                    "\nOrder created successfully" ;
        }

        return "Order created successfully";
    }

    @Transactional
    public void buyProduct(Long id, int quantity) {
        productsRepository.buyProducts(id, quantity) ;
    }


    @Override
    public String updateOrder(dtoOrdersRequest dtoOrders) {
        return "";
    }

    @Override
    public String deleteOrderbyId(Long id) {
        return "";
    }

    @Override
    public Map<Integer, List<dtoOrdersResponse>> getAllOrders() {
        return null;
    }

}
