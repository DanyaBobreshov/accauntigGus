package com.example.accauntigGus.service;

import com.example.accauntigGus.model.Nomenclature;
import com.example.accauntigGus.model.Product;
import com.example.accauntigGus.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements UniService<Product> {
    private final ProductRepo productRepo;
    private final NomenclatureService nomenclatureService;

    @Override
    public List<Product> list(String title) {
        if (title != null) {
            return productRepo.findByTitleContains(title);
        } else {
            return productRepo.findAll();
        }
    }

    public Product save(String title, String module, Long year, String comment, Long nomenclatureId) {
        Product product = new Product();
        product.setTitle(title);
        product.setModule(module);
        product.setYear(year);
        product.setComment(comment);
        Nomenclature nomenclature = nomenclatureService.findById(nomenclatureId);
        if (nomenclature == null) {
            nomenclature = nomenclatureService.findById(1L);
        }
        product.setNomenclature(nomenclature);
        productRepo.save(product);
        return productRepo.findByTitle(product.getTitle()).orElse(null);
    }

    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product findByTitle(String title) {
        return productRepo.findByTitle(title).orElse(null);
    }

    @Override
    public Product saveEntity(Product entity) {
        productRepo.save(entity);
        return entity;
    }

    @Override
    public void delete(Product entity) {
        productRepo.delete(entity);
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product correct(Long id, String title,
                           String module, Long year, String comment, Long nomenclatureId) {
        Product product = findById(id);
        if (product == null) {
            return findById(1L);
        }
        product.setTitle(title);
        product.setModule(module);
        product.setYear(year);
        product.setComment(comment);
        Nomenclature nomenclature = nomenclatureService.findById(id);
        if (nomenclature == null) {
            nomenclature = nomenclatureService.findById(1L);
        }
        product.setNomenclature(nomenclature);
        productRepo.save(product);
        return findByTitle(title);
    }
}


