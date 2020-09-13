package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.model.Carta;
import sample.model.ListaCartas;

public class Controller {
    private ListaCartas lista = new ListaCartas();
    private boolean inicializado = false;

    //Inicializa
    @FXML
    private Button btnInicializar;


    // Cadastro
    @FXML
    private TextField txtUrl_Cadastro;
    @FXML
    private TextField txtSerie_Cadastro;
    @FXML
    private TextField txtRaridade_Cadastro;
    @FXML
    private TextField txtNome_Cadastro;

    // Atual
    @FXML
    private Label lblID_Atual,lblColecao_Atual, lblNome_Atual, lblRaridade_Atual,lblSerie_Atual;
    @FXML
    private ImageView imgImagem;

    // Correcao
    @FXML
    private TextField txtNome_Correcao, txtRaridade_Correcao,txtSerie_Correcao,txtUrl_Correcao;

    @FXML
    public void inicializar(){
        if(inicializado){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Aviso");
            alert.setHeaderText("Sistema já inicializado, pode continuar");
            alert.showAndWait();
        }
        else{
            inicializado = true;
            lista.lista_carta.add(new Carta("https://images.pokemontcg.io/dp6/90_hires.png",0,"Cubone","Comum","Legends Awakened"));
            //TODO Ver se lista eh statico
            lblID_Atual.setText(""+lista.lista_carta.get(0).getId());
            lblColecao_Atual.setText(""+lista.lista_carta.get(0).getColecao());
            lblNome_Atual.setText(lista.lista_carta.get(0).getNome());
            lblRaridade_Atual.setText(lista.lista_carta.get(0).getRaridade());
            lblSerie_Atual.setText(lista.lista_carta.get(0).getSerie());
            Image imagem = new Image(lista.lista_carta.get(0).getUrlImagem());
            imgImagem.setImage(imagem);

        }
    }
    @FXML
    public void proximaCarta(){
        if(inicializado){
            if(Integer.parseInt(lblID_Atual.getText())+1== lista.lista_carta.size()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Nao ha mais cartas");
                alert.showAndWait();
            }else{
                int novoID = Integer.parseInt(lblID_Atual.getText())+1;
                lblID_Atual.setText(""+novoID);
                lblColecao_Atual.setText(""+lista.lista_carta.get(novoID).getColecao());
                lblNome_Atual.setText(lista.lista_carta.get(novoID).getNome());
                lblRaridade_Atual.setText(lista.lista_carta.get(novoID).getRaridade());
                lblSerie_Atual.setText(lista.lista_carta.get(novoID).getSerie());
                Image imagem = new Image(lista.lista_carta.get(novoID).getUrlImagem());
                imgImagem.setImage(imagem);
            }
        }else{
            erroInicializacao();
        }
    }
    @FXML
    public void cartaAnterior(){
        if (inicializado){
            int id_atual = Integer.parseInt(lblID_Atual.getText());
            if (id_atual==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Nao ha carta anterior");
                alert.showAndWait();
            }else{
                int novoID = Integer.parseInt(lblID_Atual.getText())-1;
                lblID_Atual.setText(""+novoID);
                lblColecao_Atual.setText(""+lista.lista_carta.get(novoID).getColecao());
                lblNome_Atual.setText(lista.lista_carta.get(novoID).getNome());
                lblRaridade_Atual.setText(lista.lista_carta.get(novoID).getRaridade());
                lblSerie_Atual.setText(lista.lista_carta.get(novoID).getSerie());
                Image imagem = new Image(lista.lista_carta.get(novoID).getUrlImagem());
                imgImagem.setImage(imagem);
            }
        }else{erroInicializacao();
        }
    }

    @FXML
    public void cadastrar(){
        if (inicializado){
            String url = txtUrl_Cadastro.getText();
            String nome = txtNome_Cadastro.getText();
            String raridade = txtRaridade_Cadastro.getText();
            String serie = txtSerie_Cadastro.getText();

            if(url.equals("") || nome.equals("") || raridade.equals("") || serie.equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Uma das entradas esta vazia. Favor prencher todas.");
                alert.showAndWait();
            }else{
                lista.lista_carta.add(new Carta(url,0,nome,raridade,serie));
                txtNome_Cadastro.clear();
                txtRaridade_Cadastro.clear();
                txtSerie_Cadastro.clear();
                txtUrl_Cadastro.clear();
                //TODO perguntar o que eh colecao

            }
        }else{ erroInicializacao();}

    }
    @FXML
    public void atualizar(){
        if (inicializado){
            int id_Atual = Integer.parseInt(lblID_Atual.getText());
            String url = lista.lista_carta.get(id_Atual).getUrlImagem();
            String urlAtualizado = txtUrl_Correcao.getText();

            if(!url.equals(urlAtualizado) && !urlAtualizado.equals("")){
                //Atualiza a url na lista direto
                lista.lista_carta.get(id_Atual).setUrlImagem(urlAtualizado);

                //Atualiza a imagem
                Image imagem = new Image(lista.lista_carta.get(id_Atual).getUrlImagem());
                imgImagem.setImage(imagem);
            }

            String nome = lblNome_Atual.getText();
            String nomeAtualizado = txtNome_Correcao.getText();
            if(!nome.equals(nomeAtualizado) && !nomeAtualizado.equals("")){
                lista.lista_carta.get(id_Atual).setNome(nomeAtualizado);
                lblNome_Atual.setText(nomeAtualizado);
            }

            String raridade = lblRaridade_Atual.getText();
            String raridadeAtualizada = txtRaridade_Correcao.getText();
            if(!raridade.equals(raridadeAtualizada) && !raridadeAtualizada.equals("")){
                lista.lista_carta.get(id_Atual).setRaridade(raridadeAtualizada);
                lblRaridade_Atual.setText(raridadeAtualizada);
            }

            String serie = lblSerie_Atual.getText();
            String serieAtualizada = txtSerie_Correcao.getText();
            if(!serie.equals(serieAtualizada)&& !serieAtualizada.equals("")){
                lista.lista_carta.get(id_Atual).setSerie(serieAtualizada);
                lblSerie_Atual.setText(serieAtualizada);
            }

            txtNome_Correcao.clear();
            txtRaridade_Correcao.clear();
            txtSerie_Correcao.clear();
            txtUrl_Correcao.clear();


        }
        else {erroInicializacao();}
    }

    public void erroInicializacao(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Sistema não inicializado");
        alert.showAndWait();
    }
}
