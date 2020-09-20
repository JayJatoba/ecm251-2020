package sample.dao;

/**
 *
 * @author Andre Lebrao 18.00356-7
 * @author Joao Guilherme Jatoba 18.01790-8
 * @since 15/09/2020
 */
public interface DAOFields {
    String getTableName();
    String getUpdateString(String table);
    String getInsertString(String table);
    String getSelectAllString(String table);
}
