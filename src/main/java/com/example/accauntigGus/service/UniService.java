package com.example.accauntigGus.service;

import java.util.List;

public interface UniService<T> {
    List<T> list(String title);

    T findById(Long id);

    T findByTitle(String title);

    T saveEntity(T entity);

    void delete(T entity);

    void deleteById(Long id);

}
