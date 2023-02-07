package com.example.accauntigGus.service;

import com.example.accauntigGus.model.Division;
import com.example.accauntigGus.model.Regiment;
import com.example.accauntigGus.repository.RegimentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegimentService implements UniService<Regiment> {
    private final RegimentRepo regimentRepo;
    private final DivisionService divisionService;

    @Override
    public List<Regiment> list(String title) {
        if (title != null) {
            return regimentRepo.findByTitleContains(title);
        } else {
            return regimentRepo.findAll();
        }
    }

    public Regiment save(String title, String address, String telephone, String comment, Long divisionId) {
        Regiment regiment = new Regiment();
        regiment.setTitle(title);
        regiment.setAddress(address);
        regiment.setTelephone(telephone);
        regiment.setComment(comment);
        Division division = divisionService.findById(divisionId);
        if (division == null) {
            division = divisionService.findById(1L);
        }
        regiment.setDivision(division);
        regimentRepo.save(regiment);
        return regimentRepo.findByTitle(title).orElse(null);
    }

    public void deleteById(Long id) {
        regimentRepo.deleteById(id);
    }

    @Override
    public Regiment findByTitle(String title) {
        return regimentRepo.findByTitle(title).orElse(null);
    }

    @Override
    public Regiment saveEntity(Regiment entity) {
        regimentRepo.save(entity);
        return entity;
    }

    @Override
    public void delete(Regiment entity) {
        regimentRepo.delete(entity);
    }

    @Override
    public Regiment findById(Long id) {
        return regimentRepo.findById(id).orElse(null);
    }

    public Regiment correct(Long id, String title, String address, String telephone, String comment, Long divisionId) {
        Regiment regiment = regimentRepo.findById(id).orElse(null);
        if (regiment == null) {
            return findById(1L);
        }
        regiment.setTitle(title);
        regiment.setAddress(address);
        regiment.setTelephone(telephone);
        regiment.setComment(comment);
        Division division = divisionService.findById(divisionId);
        if (division == null) {
            division = divisionService.findById(1L);
        }
        regiment.setDivision(division);
        regimentRepo.save(regiment);
        return regimentRepo.findByTitle(title).orElse(null);
    }
}

