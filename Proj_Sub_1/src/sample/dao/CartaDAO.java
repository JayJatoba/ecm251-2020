package sample.dao;

import sample.model.Carta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Andre Lebrao 18.00356-7
 * @author Joao Guilherme Jatoba 18.01790-8
 * @since 15/09/2020
 */
public class CartaDAO implements DAO<Carta>,DAOFields{
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:cartas.db";


    public CartaDAO(){
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Percorre o banco de dados linha por linha, criando e adicionando objetos Carta em uma Lista
     * <br> Em caso de erro, imprime no console
     * @return Lista com todas as cartas registradas no banco
     */
    @Override
    public List<Carta> getAll() {
        List<Carta> cartas = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                Carta carta = new Carta(
                        result.getString("id"),
                        result.getString("url"),
                        result.getString("nome"),
                        result.getString("raridade"),
                        result.getString("serie"),
                        result.getString("colecao")
                );
                cartas.add(carta);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return cartas;
    }

    /**
     * Tenta atualizar os dados de uma carta existente no banco. Em caso de erro, imprime no console
     * @param carta Objeto carta para ser atualizada
     * @param idOriginal ID unico original da carta<br>
     *
     */
    @Override
    public void update(Carta carta,String idOriginal) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1, carta.getIdCarta());
            preparedStatement.setString(2, carta.getUrlImagem());
            preparedStatement.setString(3, carta.getNome());
            preparedStatement.setString(4, carta.getRaridade());
            preparedStatement.setString(5, carta.getSerie());
            preparedStatement.setString(6, carta.getColecao());
            preparedStatement.setString(7, idOriginal);

            int retorno = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Tenta inserir no banco todos os dados da nova carta fornecida. Em caso de erro, imprime no console
     * @param carta Objeto Carta para ser criada
     *
     */
    @Override
    public void create(Carta carta) {
        //Inserir um novo produto
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, carta.getIdCarta());
            preparedStatement.setString(2, carta.getUrlImagem());
            preparedStatement.setString(3, carta.getNome());
            preparedStatement.setString(4, carta.getRaridade());
            preparedStatement.setString(5, carta.getSerie());
            preparedStatement.setString(6, carta.getColecao());

            int retorno = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    /**
     * @return Nome do banco de dados
     */
    @Override
    public String getTableName() {
        return "cartas";
    }

    /**
     * @param table Nome do banco de dados
     * @return Expressao de UPDATE em SQL. Todas as restricoes de nome sao substituidas por "?"
     */
    @Override
    public String getUpdateString(String table) {
        return "UPDATE "+table+" SET id = ?, url = ?, nome = ?, raridade = ?, serie = ?, colecao = ? WHERE id = ?;";
    }

    /**
     * @param table Nome do banco de dados
     * @return Expressao de INSERT em SQL. Todas as restricoes de nome sao substituidas por "?"
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+table +" (id,url,nome,raridade,serie,colecao) VALUES (?,?,?,?,?,?);";
    }

    /**
     * @param table Nome do banco de dados
     * @return Expressao de SELECT em SQL. Todas as restricoes de nome sao substituidas por "?"
     */
    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }
}
