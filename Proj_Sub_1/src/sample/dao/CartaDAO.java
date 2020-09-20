package sample.dao;

import sample.model.Carta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartaDAO implements DAO<Carta>,DAOFields{
    private Connection connection;
    /**
     * @author Andre Lebrao 18.00356-7
     * @author Joao Guilherme Jatoba 18.01790-8
     * @since 15/09/2020
     */
    private String myDBConnectionString = "jdbc:sqlite:cartas.db";


    public CartaDAO(){
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

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

    @Override
    public String getTableName() {
        return "cartas";
    }

    @Override
    public String getUpdateString(String table) {
        return "UPDATE "+table+" SET id = ?, url = ?, nome = ?, raridade = ?, serie = ?, colecao = ? WHERE id = ?;";
    }

    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+table +" (id,url,nome,raridade,serie,colecao) VALUES (?,?,?,?,?,?);";
    }

    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }
}
