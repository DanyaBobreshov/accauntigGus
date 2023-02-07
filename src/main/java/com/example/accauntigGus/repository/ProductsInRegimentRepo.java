package com.example.accauntigGus.repository;

import com.example.accauntigGus.model.ProductsInRegiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductsInRegimentRepo extends JpaRepository<ProductsInRegiment, Long> {
    List<ProductsInRegiment> findByProductTitleContains(String productTitle);
    List<ProductsInRegiment> findByRegimentTitleContains(String regimentTitle);
    Optional<ProductsInRegiment> findByRegimentIdAndProductId(Long regimentId, Long productId);

}
