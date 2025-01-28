package com.MyProject.e_commerce.Repository;

import com.MyProject.e_commerce.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    //Set the Total Price
    @Modifying
    @Query("UPDATE Orders o SET o.totalprice = :newTotalPrice WHERE o.id = :orderId")
    void setTotalPrice(double newTotalPrice , Long orderId);
}
