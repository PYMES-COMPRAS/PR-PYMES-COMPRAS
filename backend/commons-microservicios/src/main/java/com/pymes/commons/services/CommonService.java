package com.pymes.commons.services;

import java.util.Optional;

public interface CommonService<E> {

    public Iterable<E> findAll();

    public Optional<E> findById(Integer id);

    public E save(E entity);

    public void deleteById(Integer id);

}
