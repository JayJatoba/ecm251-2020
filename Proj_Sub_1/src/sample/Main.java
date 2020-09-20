package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Responsavel por iniciar a interface grafica
 * @author Andre Lebrao 18.00356-7
 * @author Joao Guilherme Jatoba 18.01790-8
 * @since 15/09/2020
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("pokedexview.fxml"));
        primaryStage.setTitle("teste JavaFX");
        primaryStage.setScene(new Scene(root,646,478));
        primaryStage.show();
    }


    public static void main(String[] args){
        launch(args);
    }
}
