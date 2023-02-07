package com.example.accauntigGus.service;

import com.example.accauntigGus.model.Performer;
import com.example.accauntigGus.repository.PerformerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerformerService implements UniService<Performer> {
    private final PerformerRepo performerRepo;

    @Override
    public List<Performer> list(String title) {
        if (title==null){
            return performerRepo.findAll();
        }
        return performerRepo.findByNameContains(title);
    }

    @Override
    public Performer findById(Long id) {
        return performerRepo.findById(id).orElse(null);
    }

    @Override
    public Performer findByTitle(String title) {
        return null;
    }

    @Override
    public Performer saveEntity(Performer entity) {
       performerRepo.save(entity);
        return entity;
    }

    @Override
    public void delete(Performer entity) {
        performerRepo.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        performerRepo.deleteById(id);
    }

    public Performer save(String name, String rang){
        Performer performer=new Performer();
        performer.setName(name);
        performer.setRang(rang);
        saveEntity(performer);
        return performer;
    }

    public Performer correct(Long id, String name, String rang){
        Performer performer=performerRepo.findById(id).orElse(null);
        if(performer==null){
            return performerRepo.findById(1L).orElse(null);
        }
        performer.setRang(rang);
        performer.setName(name);
        saveEntity(performer);
        return performer;
    }
}
