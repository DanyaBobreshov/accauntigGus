package com.example.accauntigGus.service;

import com.example.accauntigGus.model.Akt;
import com.example.accauntigGus.model.ProductNumber;
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

    public Akt save(LocalDate date, Long regimentId, String contract, List<ProductNumber> productNumbers){
        Akt akt = new Akt();
        akt.setDate(date);
        Regiment regiment=regimentService.findById(regimentId);
        akt.setRegiment(regiment);
        akt.setContract(contract);
        akt.setProductNumbers(productNumbers);
        for(ProductNumber pn:productNumbers){
            productInRegimentService.correctUp(regimentId, pn.getProduct().getId(), pn.getNumber());
        }
        saveEntity(akt);
        return akt;
    }

    public Akt correct(Long id, LocalDate date, Long regimentId, String contract, List<ProductNumber> productNumbers){
        Akt akt=this.findById(id);
        if(akt==null) {
            return null;
        }
            Long oldRegId=akt.getRegiment().getId();
            List<ProductNumber> oldProdNum=akt.getProductNumbers();
            for(ProductNumber pn:oldProdNum){
                productInRegimentService.correctDown(oldRegId, pn.getProduct().getId(), pn.getNumber());
            }
            akt.setDate(date);
            Regiment regiment=regimentService.findById(regimentId);
            akt.setRegiment(regiment);
            akt.setContract(contract);
            akt.setProductNumbers(productNumbers);
            for(ProductNumber pn:productNumbers){
                productInRegimentService.correctUp(regimentId, pn.getProduct().getId(), pn.getNumber());
            }
            saveEntity(akt);
            return akt;
        }


    }
