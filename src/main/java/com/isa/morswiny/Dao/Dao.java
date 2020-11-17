package com.isa.morswiny.Dao;

import java.util.Optional;

public interface Dao<T> {

    public void save(T t);

    public T update(T t);

    public void delete(T t);

    public Optional<T> find(Integer id);


}
