package com.example.accauntigGus.repository;
import com.example.accauntigGus.model.Status;
import com.example.accauntigGus.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StatusRepo extends JpaRepository<Status, Long>{
    List<Status> findByTitleContains(String title);
    Optional<Status>findByTitle(String title);
    void deleteById(Long id);
}