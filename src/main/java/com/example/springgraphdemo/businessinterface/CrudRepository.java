package com.example.springgraphdemo.businessinterface;

import java.util.List;

public interface CrudRepository<T,ID> {

    public T findById(ID id);

    public List<T> findAll();

    public ID  save(T t);

    public T update(T t);

    public void delete(ID id);
}
