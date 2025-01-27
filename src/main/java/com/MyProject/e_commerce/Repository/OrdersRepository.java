package com.MyProject.e_commerce.Repository;

import com.MyProject.e_commerce.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
