package com.MyProject.e_commerce.Repository;

import com.MyProject.e_commerce.Model.OrderProducts;
import com.MyProject.e_commerce.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderProductsRepository extends JpaRepository<OrderProducts, Long> {

    //Give the list of Buyed Products in Order
    @Query("SELECT op.product FROM OrderProducts op WHERE op.order.id = :orderId")
    List<Products> getOrderbyId(Long orderId);

    //Give the quantity of Buyed Product in Order
    @Query("SELECT op.quantity FROM OrderProducts op WHERE op.product.id = :productId AND op.order.id = :orderId")
    int getQuantityofProduct(Long orderId, Long productId);

    //Give the List of All Order Ids without Repetition
    @Query("SELECT DISTINCT op.order.id FROM OrderProducts op ")
    List<Long> getAllOrderIds();

    //Delete Order by Id
    @Modifying
    @Query("DELETE FROM OrderProducts op WHERE op.order.id = :orderId")
    void deleteByOrderId(Long orderId);

    //List All Product Ids in Order
    @Query("SELECT op.product.id FROM OrderProducts op WHERE op.order.id = :orderId")
    List<Long> listProductIdsByOrderId(Long orderId);

}
