package com.example.accauntigGus.service;

import com.example.accauntigGus.model.Akt;
import com.example.accauntigGus.model.ProductsInRegiment;
import com.example.accauntigGus.repository.ProductsInRegimentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductInRegimentService implements UniService<ProductsInRegiment> {
    private final ProductsInRegimentRepo productsInRegimentRepo;

    private final RegimentService regimentService;
    private final ProductService productService;


    @Override
    public List<ProductsInRegiment> list(String title) {
        return productsInRegimentRepo.findByProductTitleContains(title);
    }

    @Override
    public ProductsInRegiment findById(Long id) {
        return productsInRegimentRepo.findById(id).orElse(null);
    }

    @Override
    public ProductsInRegiment findByTitle(String title) {
        return null;
    }

    public ProductsInRegiment findByProductAndRegiment(Long regimentId, Long productId){
        return productsInRegimentRepo.findByRegimentIdAndProductId(regimentId, productId).orElse(null);
    }

    @Override
    public ProductsInRegiment saveEntity(ProductsInRegiment entity) {
        productsInRegimentRepo.save(entity);
        return entity;
    }

    @Override
    public void delete(ProductsInRegiment entity) {
        productsInRegimentRepo.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        productsInRegimentRepo.deleteById(id);
    }

    public ProductsInRegiment save(Long regimentId, Long productId, Long productNumbers){
        ProductsInRegiment productsInRegiment=new ProductsInRegiment();
        productsInRegiment.setRegiment(regimentService.findById(regimentId));
        productsInRegiment.setProduct(productService.findById(productId));
        productsInRegiment.setNumbers(productNumbers);
        productsInRegimentRepo.save(productsInRegiment);
        return productsInRegiment;
    }

    public void correct(Long productInRegimentId, Long numbers){
        ProductsInRegiment productsInRegiment=productsInRegimentRepo.findById(productInRegimentId).orElse(null);
        productsInRegiment.setNumbers(numbers);
        productsInRegimentRepo.save(productsInRegiment);
    }

    public void correctUp(Long regimentId, Long productId, Long numbers){
        ProductsInRegiment productInRegiment=productsInRegimentRepo.findByRegimentIdAndProductId(regimentId, productId).orElse(null);
        if(productInRegiment==null) productInRegiment=new ProductsInRegiment();
        productInRegiment.setNumbers(productInRegiment.getNumbers()+numbers);
        saveEntity(productInRegiment);
    }

    public void correctDown(Long regimentId, Long productId, Long numbers){
        ProductsInRegiment productInRegiment=productsInRegimentRepo.findByRegimentIdAndProductId(regimentId, productId).orElse(null);
        if(productInRegiment==null) productInRegiment=new ProductsInRegiment();
        productInRegiment.setNumbers(productInRegiment.getNumbers()-numbers);
        saveEntity(productInRegiment);
    }



}
