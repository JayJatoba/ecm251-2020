package br.maua.dao;

/**
 * Interface de preparo dos comandos de Java para SQL
 * @author Andre Lebrao 18.00356-7
 * @author Joao Guilherme Jatoba 18.01790-8
 * @since 24/11/2020
 */
public interface DAOFields {
    String getTableName();
    String getDeleteString(String table);
    String getUpdateString(String table, String coluna);
    String getUpdateAllString(String table);
    String getInsertString(String table);
    String getSelectAllString(String table);
}
