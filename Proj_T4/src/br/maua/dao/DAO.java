package br.maua.dao;

import java.util.List;
/**
 * Interface com funcoes de SQL e comparacao de elementos ja existentes
 * @param <T> Tipo de objeto usado pela interface
 * @author Andre Lebrao 18.00356-7
 * @author Joao Guilherme Jatoba 18.01790-8
 * @since 24/11/2020
 */
public interface DAO <T>{
    List<T> getAll();
    void update(T t,String coluna,String novoValor);
    void updateAll(T t);
    void delete(T t);
    void create(T t);
}
