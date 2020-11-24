package br.maua.dao;

public interface DAOFields {
    String getTableName();
    String getDeleteString(String table);
    String getUpdateString(String table, String coluna);
    String getUpdateAllString(String table);
    String getInsertString(String table);
    String getSelectAllString(String table);
}
