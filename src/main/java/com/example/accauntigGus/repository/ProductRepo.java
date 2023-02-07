package com.example.accauntigGus.repository;


import com.example.accauntigGus.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByTitleContains(String title);
    Optional<Product> findByTitle(String title);
    void deleteByTitle(String title);
    void deleteById(Long id);
    List<Product>findByNomenclatureTitleContains(String title);
}