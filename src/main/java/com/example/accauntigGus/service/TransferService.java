package com.example.accauntigGus.service;

import com.example.accauntigGus.model.Transfer;
import com.example.accauntigGus.repository.TransferRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TransferService implements UniService<Transfer> {
    private final TransferRepo transferRepo;
    @Override
    public List<Transfer> list(String title) {
        if (title==null){
            return transferRepo.findAll();
        }
        return transferRepo.findByTitleContains(title);
    }

    @Override
    public Transfer findById(Long id) {
        return transferRepo.findById(id).orElse(transferRepo.findById(1L).orElse(null));
    }

    @Override
    public Transfer findByTitle(String title) {
        return transferRepo.findByTitle(title).orElse(transferRepo.findById(1L).orElse(null));
    }

    @Override
    public Transfer saveEntity(Transfer entity) {
        return transferRepo.save(entity);
    }

    @Override
    public void delete(Transfer entity) {
        transferRepo.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        transferRepo.deleteById(id);
    }
}
