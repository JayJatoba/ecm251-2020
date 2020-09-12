package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import sample.model.PokemonList;

public class Controller {
    private PokemonList lista = new PokemonList();

    // Cadastro
    @FXML
    private TextField txtUrl_Cadastro,txtNome_Cadastro,txtRaridade_Cadastro,txtSerie_Cadastro;

    // Atual
    @FXML
    private Label lblID_Atual,lblColecao_Atual, lblNome_Atual, lblRaridade_Atual,lblSerie_Atual;
    private ImageView imgImagem;

    // Correcao
    @FXML
    private TextField txtNome_Correcao, txtRaridade_Correcao,txtSerie_Correcao;


}
