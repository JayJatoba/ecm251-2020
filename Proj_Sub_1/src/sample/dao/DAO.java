package sample.dao;

import java.util.List;

/**
 * @param <T> Tipo de objeto usado pela interface
 * @author Andre Lebrao 18.00356-7
 * @author Joao Guilherme Jatoba 18.01790-8
 * @since 15/09/2020
 */
public interface DAO <T>{
    List<T> getAll();
    void update(T t,String idOriginal);
    void create(T t);
}
