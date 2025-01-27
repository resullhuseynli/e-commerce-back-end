package com.MyProject.e_commerce.Model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode
public class OrderProductsKey implements Serializable {

    private Long orderId;

    private Long productId;

}