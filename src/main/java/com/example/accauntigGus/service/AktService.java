package com.example.accauntigGus.service;

import com.example.accauntigGus.model.Akt;
import com.example.accauntigGus.model.ProductsInRegiment;
import com.example.accauntigGus.model.Regiment;
import com.example.accauntigGus.repository.AktRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AktService implements UniService<Akt>{
    private final AktRepo aktRepo;
    private final RegimentService regimentService;
    private final ProductInRegimentService productInRegimentService;
    private final ProductService productService;
    @Override
    public List<Akt> list(String title) {
        return aktRepo.findAll();
    }

    @Override
    public Akt findById(Long id) {
        return aktRepo.findById(id).orElse(null);
    }

    @Override
    public Akt findByTitle(String title) {
        return aktRepo.findByContract(title).orElse(null);
    }

    @Override
    public Akt saveEntity(Akt entity) {
        aktRepo.save(entity);
        return entity;
    }

    @Override
    public void delete(Akt entity) {
        aktRepo.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        aktRepo.deleteById(id);
    }

    public Akt save(LocalDate date, Long regimentId, String contract, List<Long> productsId){
        Akt akt=new Akt();
        akt.setDate(date);
        Regiment regiment=regimentService.findById(regimentId);
        akt.setBase(regiment);
        akt.setContract(contract);
        List<ProductsInRegiment>productsInRegimentList=new LinkedList<>();
        for(Long productId:productsId){
            ProductsInRegiment productInRegiment;
            if(productInRegimentService.findByProductAndRegiment(regimentId, productId)==null){
                productInRegiment= new ProductsInRegiment();
                productInRegiment.setRegiment(regiment);
                productInRegiment.setProduct(productService.findById(productId));
            }
        }
        akt.setProductsInRegiments(productsInRegimentList);
        aktRepo.save(akt);
        return akt;
    }

}
