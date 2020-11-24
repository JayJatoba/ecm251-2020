package br.maua.dao;

import java.util.List;

public interface DAO <T>{
    List<T> getAll();
    void update(T t,String coluna,String novoValor);
    void updateAll(T t);
    void create(T t);
}
