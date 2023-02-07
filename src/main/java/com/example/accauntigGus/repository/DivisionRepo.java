package com.example.accauntigGus.repository;

import com.example.accauntigGus.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DivisionRepo extends JpaRepository<Division, Long> {
    List<Division> findByTitleContains(String title);

    Optional<Division> findByTitle(String title);

    void deleteById(Long id);
}
