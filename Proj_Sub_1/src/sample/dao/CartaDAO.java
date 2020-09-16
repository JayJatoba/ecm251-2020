package sample.dao;

import sample.model.Carta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartaDAO implements DAO<Carta>{
    private Connection connection;
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
            ResultSet result = statement.executeQuery("SELECT * FROM cartas");
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
    public void update(Carta carta) {

    }

    @Override
    public void create(Carta carta) {
//Inserir um novo produto


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cartas (id, url, nome, raridade, serie, colecao) VALUES (?, ?, ?, ?, ?, ?);");

            preparedStatement.setString(1, carta.getIdCarta());
            preparedStatement.setString(2, carta.getUrlImagem());
            preparedStatement.setString(3, carta.getNome());
            preparedStatement.setString(4, carta.getRaridade());
            preparedStatement.setString(5, carta.getSerie());
            preparedStatement.setString(6, carta.getColecao());

            int retorno = preparedStatement.executeUpdate();
            System.out.println("Retorno: "+retorno);
//            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
