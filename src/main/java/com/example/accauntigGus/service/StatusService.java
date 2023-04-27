package com.example.accauntigGus.service;

import com.example.accauntigGus.model.Status;
import com.example.accauntigGus.repository.StatusRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StatusService implements UniService<Status> {
    private final StatusRepo statusRepo;
    @Override
    public List<Status> list(String title) {
        if(title==null){
            return statusRepo.findAll();
        }
        return statusRepo.findByTitleContains(title);
    }

    @Override
    public Status findById(Long id) {
        return statusRepo.findById(id).orElse(statusRepo.findById(1L).orElse(null));
    }

    @Override
    public Status findByTitle(String title) {
        return statusRepo.findByTitle(title).orElse(statusRepo.findById(1L).orElse(null));
    }

    @Override
    public Status saveEntity(Status entity) {
        return statusRepo.save(entity);
    }

    @Override
    public void delete(Status entity) {
        statusRepo.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        statusRepo.deleteById(id);
    }
}
