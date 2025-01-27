package com.MyProject.e_commerce.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_date")
    private Date date;

    @Column(name = "total_price")
    private double totalprice;

    @Column(name = "total_quantity")
    private int totalquantity;

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = {
                    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "product_id", referencedColumnName = "product_id"),
                    @JoinColumn(name = "product_name", referencedColumnName = "product_name"),
            }
    )
    private List<Products> products;


}
