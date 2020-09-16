package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.Carta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("pokedexview.fxml"));
        primaryStage.setTitle("teste JavaFX");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }


    public static void main(String[] args) throws SQLException {
//        Connection connection = null;
//        String myDBConnectionString = "jdbc:sqlite:cartas.db";
//        Statement statement = connection.createStatement();
//        ResultSet result = statement.executeQuery("SELECT * FROM cartas");
//        while(result.next()){
//            Carta carta = new Carta(
//                    result.getString("id"),
//                    result.getString("url"),
//                    result.getString("nome"),
//                    result.getString("raridade"),
//                    result.getString("serie"),
//                    result.getString("colecao")
//            );
//            System.out.println(carta);;
//
//        }
//        result.close();
        launch(args);
    }
}
