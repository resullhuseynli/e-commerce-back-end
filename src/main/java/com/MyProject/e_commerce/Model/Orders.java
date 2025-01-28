package com.MyProject.e_commerce.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

}
