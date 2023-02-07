package com.example.accauntigGus.service;

import com.example.accauntigGus.model.Division;
import com.example.accauntigGus.repository.DivisionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DivisionService implements UniService<Division> {
    private final DivisionRepo divisionRepo;

    @Override
    public List<Division> list(String title) {
        if (title != null) {
            return divisionRepo.findByTitleContains(title);
        } else {
            return divisionRepo.findAll();
        }
    }

    public Division save(String title, String address, String telephone, String TOSOtdel) {
        Division division = new Division();
        division.setTitle(title);
        division.setAddress(address);
        division.setTelephone(telephone);
        division.setTOSOtdel(TOSOtdel);
        divisionRepo.save(division);
        return divisionRepo.findByTitle(title).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        divisionRepo.deleteById(id);
    }

    @Override
    public Division findByTitle(String title) {
        return divisionRepo.findByTitle(title).orElse(null);
    }

    @Override
    public Division saveEntity(Division entity) {
        divisionRepo.save(entity);
        return findByTitle(entity.getTitle());
    }

    @Override
    public void delete(Division entity) {
        divisionRepo.delete(entity);
    }


    @Override
    public Division findById(Long id) {
        return divisionRepo.findById(id).orElse(null);
    }

    public Division correct(Long id, String title, String address, String telephone, String TOSOtdel) {
        Division division = findById(id);
        if (division == null) {
            return findById(1L);
        }
        division.setTitle(title);
        division.setAddress(address);
        division.setTelephone(telephone);
        division.setTOSOtdel(TOSOtdel);
        divisionRepo.save(division);
        return findByTitle(title);
    }
}

