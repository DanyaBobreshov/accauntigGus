package com.example.accauntigGus.repository;

import com.example.accauntigGus.model.Performer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformerRepo extends JpaRepository<Performer, Long> {
    List<Performer> findByNameContains(String name);

}
