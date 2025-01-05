package com.janawat.crud.service.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericCrudService <T, ID> {
    protected abstract JpaRepository<T, ID> getRepository();

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }
}
