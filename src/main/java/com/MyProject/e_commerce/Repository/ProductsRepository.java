package com.MyProject.e_commerce.Repository;

import com.MyProject.e_commerce.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

    @Modifying
    @Query(value = "UPDATE Products p SET p.quantity = p.quantity - :amount WHERE p.id = :id AND p.quantity >= :amount")
    void buyProducts(Long id, int amount);

}
