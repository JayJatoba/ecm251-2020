package br.maua.dao;

import java.util.List;

public interface DAO <T>{
    List<T> getAll();
    void update(T t,String idOriginal);
    void create(T t);
}
