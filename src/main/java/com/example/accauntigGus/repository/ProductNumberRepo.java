package com.example.accauntigGus.repository;

import com.example.accauntigGus.model.ProductNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductNumberRepo extends JpaRepository<ProductNumber, Long> {
    List<ProductNumber> findByProductTitleContains(String productTitle);
    List<ProductNumber> findByProductIdContains(Long productId);
}
