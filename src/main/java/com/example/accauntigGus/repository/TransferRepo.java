package com.example.accauntigGus.repository;

import com.example.accauntigGus.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransferRepo extends JpaRepository<Transfer, Long> {
    List<Transfer> findByTitleContains(String title);
    Optional<Transfer> findByTitle(String title);
    void deleteById(Long id);
}