package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import sample.model.ListaCartas;

public class Controller {
    private ListaCartas lista = new ListaCartas();
    private boolean inicio = false;

    //Inicializa
    @FXML
    private Button btnInicializar;
    // Cadastro
    @FXML
    private TextField txtUrl_Cadastro,txtNome_Cadastro,txtRaridade_Cadastro,txtSerie_Cadastro;

    // Atual
    @FXML
    private Label lblID_Atual,lblColecao_Atual, lblNome_Atual, lblRaridade_Atual,lblSerie_Atual;
    @FXML
    private ImageView imgImagem;

    // Correcao
    @FXML
    private TextField txtNome_Correcao, txtRaridade_Correcao,txtSerie_Correcao;

    @FXML
    public void inicializar(){
        if(inicio){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Aviso");
            alert.setHeaderText("Sistema já inicializado, pode continuar");
            alert.showAndWait();
        }
        else{
            inicio = true;
        }
    }
//    @FXML
//    public void proximaCarta(){
//        if(inicio){
//
//        }else{
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Erro");
//            alert.setHeaderText("Sistema não inicializado");
//            alert.showAndWait();
//        }
//    }
//    @FXML
//    public void cartaAnterior(){
//        if (inicio){
//            Integer id_atual = Integer.parseInt(lblID_Atual.getText());
//            if (id_atual==0){
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Erro");
//            alert.setHeaderText("Não há carta anterior");
//            alert.showAndWait();
//            }else{
//
//            }
//        }else{
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Erro");
//            alert.setHeaderText("Sistema não inicializado");
//            alert.showAndWait();
//        }
//    }
//    @FXML
//    public void cadastrar(){
//
//    }
//    @FXML
//    public void atualizar(){
//    }
}
