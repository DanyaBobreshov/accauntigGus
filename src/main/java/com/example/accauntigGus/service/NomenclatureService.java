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

    public Nomenclature save(String title) {
        Nomenclature nomenclature = new Nomenclature();
        nomenclature.setTitle(title);
        nomenclatureRepo.save(nomenclature);
        return findByTitle(title);
    }

    @Override
    public void delete(Nomenclature nomenclature) {
        nomenclatureRepo.delete(nomenclature);
    }

    @Override
    public void deleteById(Long id) {
        nomenclatureRepo.deleteById(id);
    }

    @Override
    public List<Nomenclature> list(String title) {
        if (title == null) {
            return nomenclatureRepo.findAll();
        }
        return nomenclatureRepo.findByTitleContains(title);
    }

    @Override
    public Nomenclature findById(Long id) {
        return nomenclatureRepo.findById(id).orElse(null);
    }

    @Override
    public Nomenclature findByTitle(String title) {
        return nomenclatureRepo.findByTitle(title).orElse(null);
    }

    @Override
    public Nomenclature saveEntity(Nomenclature entity) {
        nomenclatureRepo.save(entity);
        return findByTitle(entity.getTitle());
    }


    public Nomenclature correct(Nomenclature nomenclature, String title) {
        nomenclature.setTitle(title);
        nomenclatureRepo.save(nomenclature);
        return findByTitle(title);
    }
}