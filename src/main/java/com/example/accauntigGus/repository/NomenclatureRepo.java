package com.example.accauntigGus.repository;

import com.example.accauntigGus.model.Nomenclature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NomenclatureRepo extends JpaRepository<Nomenclature, Long> {
    List<Nomenclature> findByTitleContains(String title);
    Optional<Nomenclature> findByTitle(String title);
    void deleteByTitle (String title);
    void deleteById (Long id);
}
