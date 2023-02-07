package com.example.accauntigGus.service;

import com.example.accauntigGus.model.Nomenclature;
import com.example.accauntigGus.repository.NomenclatureRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class NomenclatureService implements UniService<Nomenclature> {
    private final NomenclatureRepo nomenclatureRepo;
    @Override
    public List<Nomenclature> list(String title) {
        return nomenclatureRepo.findByTitleContains(title);
    }

    @Override
    public Nomenclature findById(Long id) {
        return nomenclatureRepo.findById(id).orElse(nomenclatureRepo.findById(1L).orElse(null));
    }

    @Override
    public Nomenclature findByTitle(String title) {
        return nomenclatureRepo.findByTitle(title).orElse(nomenclatureRepo.findById(1L).orElse(null));
    }

    @Override
    public Nomenclature save(Nomenclature entity) {
        nomenclatureRepo.save(entity);
        return nomenclatureRepo.findByTitle(entity.getTitle()).orElse(null);
    }

    public Nomenclature update(Nomenclature entity, String title) {
        entity.setTitle(title);
        nomenclatureRepo.save(entity);
        return entity;
    }

    @Override
    public void delete(Nomenclature entity) {
        nomenclatureRepo.delete(entity);
    }

    @Override
    public void deleteById(Long id){
        nomenclatureRepo.deleteById(id);
    }
}
