package sample.dao;

public interface DAOFields {
    String getTableName();
    String getUpdateString(String table);
    String getInsertString(String table);
    String getSelectAllString(String table);
}
