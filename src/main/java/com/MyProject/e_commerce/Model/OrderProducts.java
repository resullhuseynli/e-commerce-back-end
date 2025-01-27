package com.MyProject.e_commerce.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_products")
public class OrderProducts {

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;

}
