package com.example.accauntigGus.repository;

import com.example.accauntigGus.model.Regiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegimentRepo extends JpaRepository<Regiment, Long> {

    List<Regiment> findByTitleContains(String title);

    Optional<Regiment> findByTitle(String title);

    void deleteByTitle(String title);

    void deleteById(Long id);

    List<Regiment> findByDivisionTitleContains(String title);
}
