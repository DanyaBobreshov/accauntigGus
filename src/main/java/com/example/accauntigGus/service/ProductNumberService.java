package com.example.accauntigGus.service;

import com.example.accauntigGus.model.Product;
import com.example.accauntigGus.model.ProductNumber;
import com.example.accauntigGus.repository.ProductNumberRepo;
import com.example.accauntigGus.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductNumberService implements UniService <ProductNumber> {
    private final ProductNumberRepo productNumberRepo;
    ProductRepo productRepo;
    @Override
    public List<ProductNumber> list(String title) {
        if(title==null){
            return productNumberRepo.findAll();
        }
        else {
            return productNumberRepo.findByProductTitleContains(title);
        }
    }

    @Override
    public ProductNumber findById(Long id) {
        return productNumberRepo.findById(id).orElse(null);
    }

    @Override
    public ProductNumber findByTitle(String title) {
        return null;
    }

    public List<ProductNumber> findByProduct(Long id){
        return productNumberRepo.findByProductIdContains(id);
    }

    @Override
    public ProductNumber saveEntity(ProductNumber entity) {
        productNumberRepo.save(entity);
        return productNumberRepo.findById(entity.getId()).orElse(null);
    }

    @Override
    public void delete(ProductNumber entity) {
        productNumberRepo.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        productNumberRepo.deleteById(id);
    }
    public void correct(ProductNumber productNumber, Long productId, Long number){
        Product product = productRepo.getById(productId);
        productNumber.setProduct(product);
        productNumber.setNumber(number);
        saveEntity(productNumber);
    }

    public void correct(ProductNumber productNumber, Product product, Long number){
        productNumber.setProduct(product);
        productNumber.setNumber(number);
        saveEntity(productNumber);
    }

}
