package com.example.accauntigGus.repository;

import com.example.accauntigGus.model.Akt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AktRepo extends JpaRepository<Akt, Long> {
    List<Akt> findByRegimentId(Long id);

    Optional<Akt> findByContract(String contract);
}
