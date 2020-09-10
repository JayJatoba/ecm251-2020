package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.modle.Usuario;

public class Controller {
    @FXML
    private Label lblSaida,lblResultado;

    @FXML
    private Button bntBotao1;

    @FXML
    private TextField txtEntrada;

    @FXML
    private TextField txtNumero1,txtNumero2;

    @FXML
    private TextField txtNome,txtSenha, txtURL;

    @FXML
    private ImageView imgFoto;


    @FXML
    public void exibirNome(){
        String nome = txtEntrada.getText();
        lblSaida.setText(nome);
    }

    @FXML
    public void somar(){
        int num1 = Integer.parseInt(txtNumero1.getText());
        int num2 = Integer.parseInt(txtNumero2.getText());
        int soma = num1 + num2;
        String valor = "Resultado: "+soma;
        lblResultado.setText(valor);
    }

    @FXML
    public void cadastrar(){
        Usuario usuario  = new Usuario(
                txtNome.getText(),txtSenha.getText(),txtURL.getText()
        );
        txtNome.clear();
        txtSenha.clear();
        txtURL.clear();
        System.out.println("Usuario cadastrado: "+usuario);
    }

    @FXML
    public void previewPhoto(){
        try{
        String url = txtURL.getText();
        Image image = new Image(url);
        imgFoto.setImage(image);
    }catch(IllegalArgumentException exception){
            txtURL.clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("URL Incorreta");
            alert.setHeaderText("Batata");
            alert.showAndWait();
        }
    }
}
