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
import sample.teste.Aplicacao;

import java.lang.reflect.InvocationTargetException;

public class Controller {
    private ListaCartas lista = new ListaCartas();
    private boolean inicializado = false;

    //Inicializa
    @FXML
    private Button btnInicializar;


    // Cadastro
    @FXML
    private TextField txtUrlCadastro;
    @FXML
    private TextField txtSerieCadastro;
    @FXML
    private TextField txtRaridadeCadastro;
    @FXML
    private TextField txtNomeCadastro,txtColecaoCadastro,txtIdCadastro;

    // Atual
    @FXML
    private Label lblIdAtual, lblColecaoAtual, lblNomeAtual, lblRaridadeAtual, lblSerieAtual;
    @FXML
    private ImageView imgImagem;

    // Correcao
    @FXML
    private TextField txtNomeCorrecao, txtRaridadeCorrecao, txtSerieCorrecao, txtUrlCorrecao,txtIdCorrecao,txtColecaoCorrecao;

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
            Aplicacao aplicacao = new Aplicacao();
            lista.listaCartas.add(aplicacao.run());

//            TODO Ver se lista eh statico
            apresentacaoCarta(lista.listaCartas.get(0));
        }
    }

    @FXML
    public void proximaCarta(){
        if(inicializado){
            System.out.println("Atual: "+lista.getNumAtual(lblIdAtual.getText()));
            int novoID = lista.getNumAtual(lblIdAtual.getText())+1;
            if(novoID== lista.listaCartas.size()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Nao ha mais cartas");
                alert.showAndWait();
            }
            else{apresentacaoCarta(lista.listaCartas.get(novoID));}
        }else{
            erroInicializacao();
        }
    }


    @FXML
    public void cartaAnterior(){
        if (inicializado){
            System.out.println("Atual: "+lista.getNumAtual(lblIdAtual.getText()));
            int novoID = lista.getNumAtual(lblIdAtual.getText())-1;
            if (novoID==-1){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Nao ha carta anterior");
                alert.showAndWait();
            }else{apresentacaoCarta(lista.listaCartas.get(novoID));}
        }else{erroInicializacao();
        }
    }

    @FXML
    public void cadastrar(){
        if (inicializado){
            String url = txtUrlCadastro.getText();
            String nome = txtNomeCadastro.getText();
            String raridade = txtRaridadeCadastro.getText();
            String serie = txtSerieCadastro.getText();
            String id = txtIdCadastro.getText();
            String colecao = txtColecaoCadastro.getText();

            if(url.equals("") || nome.equals("") || raridade.equals("") || serie.equals("") ||
            id.equals("") || colecao.equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Pelo menos uma das entradas está vazia. Favor preencher todas.");
                alert.showAndWait();
            }else{

                lista.listaCartas.add(new Carta(url,id, colecao,nome,raridade,serie));
                txtNomeCadastro.clear();
                txtRaridadeCadastro.clear();
                txtSerieCadastro.clear();
                txtUrlCadastro.clear();
                txtIdCadastro.clear();
                txtColecaoCadastro.clear();

            }
        }else{ erroInicializacao();}

    }
    @FXML
    public void atualizar(){
        if (inicializado){
            int numAtual = lista.getNumAtual(lblIdAtual.getText());
            String url = lista.listaCartas.get(numAtual).getUrlImagem();
            String urlAtualizado = txtUrlCorrecao.getText();

            if(!url.equals(urlAtualizado) && !urlAtualizado.equals("")){
                //Atualiza a url na lista direto
                lista.listaCartas.get(numAtual).setUrlImagem(urlAtualizado);
                //Atualiza a imagem
                testeDeImagem(urlAtualizado);
            }

            String nome = lblNomeAtual.getText();
            String nomeAtualizado = txtNomeCorrecao.getText();
            if(!nome.equals(nomeAtualizado) && !nomeAtualizado.equals("")){
                lista.listaCartas.get(numAtual).setNome(nomeAtualizado);
                lblNomeAtual.setText(nomeAtualizado);
            }

            String raridade = lblRaridadeAtual.getText();
            String raridadeAtualizada = txtRaridadeCorrecao.getText();
            if(!raridade.equals(raridadeAtualizada) && !raridadeAtualizada.equals("")){
                lista.listaCartas.get(numAtual).setRaridade(raridadeAtualizada);
                lblRaridadeAtual.setText(raridadeAtualizada);
            }

            String serie = lblSerieAtual.getText();
            String serieAtualizada = txtSerieCorrecao.getText();
            if(!serie.equals(serieAtualizada)&& !serieAtualizada.equals("")){
                lista.listaCartas.get(numAtual).setSerie(serieAtualizada);
                lblSerieAtual.setText(serieAtualizada);
            }

            String id = lblIdAtual.getText();
            String idAtualizado = txtIdCorrecao.getText();

            if(!id.equals(idAtualizado)&& !idAtualizado.equals("")){
                lista.listaCartas.get(numAtual).setIdCarta(idAtualizado);
                lblIdAtual.setText(idAtualizado);
            }

            String colecao = lblColecaoAtual.getText();
            String colecaoAtualizado = txtColecaoCorrecao.getText();

            if(!colecao.equals(colecaoAtualizado)&& !colecaoAtualizado.equals("")){
                lista.listaCartas.get(numAtual).setColecao(colecaoAtualizado);
                lblColecaoAtual.setText(colecaoAtualizado);
            }

            txtColecaoCorrecao.clear();
            txtNomeCorrecao.clear();
            txtRaridadeCorrecao.clear();
            txtSerieCorrecao.clear();
            txtUrlCorrecao.clear();
            txtIdCorrecao.clear();


        }
        else {erroInicializacao();}
    }

    public void erroInicializacao(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Sistema não inicializado");
        alert.showAndWait();
    }

    public void apresentacaoCarta(Carta cartaAtual){
        lblIdAtual.setText(cartaAtual.getIdCarta());
        lblColecaoAtual.setText(cartaAtual.getColecao());
        lblNomeAtual.setText(cartaAtual.getNome());
        lblRaridadeAtual.setText(cartaAtual.getRaridade());
        lblSerieAtual.setText(cartaAtual.getSerie());

        testeDeImagem(cartaAtual.getUrlImagem());
    }

    public void testeDeImagem(String url){
        try{Image imagem = new Image(url);
            imgImagem.setImage(imagem);
        }catch(Exception e){
            //TODO Procurar erro exato
//            e.printStackTrace();
            Image imagem = new Image("https://forum.vivaldi.net/assets/uploads/files/1538786976560-capturar.png");
            imgImagem.setImage(imagem);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Este URL: \n"+url+"\nnão existe.");
            alert.showAndWait();
        }

    }
}
