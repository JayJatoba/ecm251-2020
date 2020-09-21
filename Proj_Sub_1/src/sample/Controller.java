package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.dao.CartaDAO;
import sample.model.Carta;
import sample.model.ListaCartas;

/**
 * Classe responsavel pelos metodos e manutencao da interface grafica em JavaFX
 * @author Andre Lebrao 18.00356-7
 * @author Joao Guilherme Jatoba 18.01790-8
 * @since 15/09/2020
 */
public class Controller {

    private ListaCartas lista = new ListaCartas();
    private boolean inicializado = false;
    private CartaDAO cartaDAO = new CartaDAO();

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
    private TextField txtNomeCorrecao, txtRaridadeCorrecao, txtSerieCorrecao, txtUrlCorrecao,txtColecaoCorrecao;
    @FXML
    private TextField txtIdCorrecao;


    /**
     * Carrega todas as cartas na lista de cartas e ja exibe a primeira carta da lista. Caso a GUI ja esteja
     * inicializada cria e mostra um alerta para o usuario
     */
    @FXML
    public void inicializar(){
        if(inicializado){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Aviso");
            alert.setHeaderText("Sistema ja inicializado, pode continuar");
            alert.showAndWait();
        }
        else{
            inicializado = true;
            lista.listaCartas = cartaDAO.getAll();

            apresentacaoCarta(lista.listaCartas.get(0));
        }
    }

    /**
     * Caso a GUI ja esteja inicializada e a proxima carta esteja contida na lista, muda a carta atualmente apresentada
     * para a proxima carta na lista
     */
    @FXML
    public void proximaCarta(){
        if(inicializado){

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

    /**
     * Caso a GUI ja esteja inicializada e a proxima carta esteja contida na lista, muda a carta atualmente apresentada
     * para carta anterior na lista
     */
    @FXML
    public void cartaAnterior(){
        if (inicializado){

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

    /**
     * Coleta os valores dos campos url, nome, raridade, serie, id e colecao. Se nenhum desses campos estiverem
     * vazios, cria uma nova carta e tenta inserir na lista.<br><br>
     * Cria e reporta um alerta ao usuario caso a nova carta ja
     * exista dentro da lista de cartas.<br><br>
     * Por ultimo, limpa os campos da GUI
     */
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
                alert.setHeaderText("Pelo menos uma das entradas esta vazia. Favor preencher todas.");
                alert.showAndWait();
            }else{
                Carta cartaNova = new Carta(id, url,nome,raridade,serie, colecao);
                // Id eh unico, logo nao pode haver repeticao
                if(lista.idExistente(cartaNova.getIdCarta())){

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("Ja existe esse id");
                    alert.showAndWait();
                    return;
                }
                lista.listaCartas.add(cartaNova);
                cartaDAO.create(cartaNova);


                limpaCampos("cadastro");


            }
        }else{ erroInicializacao();}

    }

    /**
     *  Checa um por um o url, nome, raridade, serie, colecao e id e, caso o valor atual seja diferente do novo e nao
     *  nulo, troca o valor <br> Por fim, checa por id duplicado e em caso afirmativo reporta o alerta
     */
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

            String colecao = lblColecaoAtual.getText();
            String colecaoAtualizado = txtColecaoCorrecao.getText();
            if(!colecao.equals(colecaoAtualizado)&& !colecaoAtualizado.equals("")){
                lista.listaCartas.get(numAtual).setColecao(colecaoAtualizado);
                lblColecaoAtual.setText(colecaoAtualizado);
            }

            String id = lblIdAtual.getText();
            String idAtualizado = txtIdCorrecao.getText();
            if(!id.equals(idAtualizado)&& !idAtualizado.equals("")){
                if(lista.idExistente(idAtualizado)){

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("Ja existe esse id");
                    alert.showAndWait();
                    return;
                }else{
                lista.listaCartas.get(numAtual).setIdCarta(idAtualizado);
                lblIdAtual.setText(idAtualizado);}
            }

            cartaDAO.update(lista.listaCartas.get(numAtual),id);



            limpaCampos("correcao");

        }
        else {erroInicializacao();}
    }

    /**
     * Cria e exibe um alerta<br>
     *     Titulo: Erro<br>
     *     Header: Sistema nao inicializado<br>
     */
    public void erroInicializacao(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Sistema não inicializado");
        alert.showAndWait();
    }

    /**
     * Muda o id, colecao, nome, raridade, serie e foto da carta atual para a nova carta
     * @param cartaAtual Carta a ser exibida
     */
    public void apresentacaoCarta(Carta cartaAtual){
        lblIdAtual.setText(cartaAtual.getIdCarta());
        lblColecaoAtual.setText(cartaAtual.getColecao());
        lblNomeAtual.setText(cartaAtual.getNome());
        lblRaridadeAtual.setText(cartaAtual.getRaridade());
        lblSerieAtual.setText(cartaAtual.getSerie());

        testeDeImagem(cartaAtual.getUrlImagem());
    }

    /**
     *
     * Tenta puxar a imagem de um dado URL, em caso de erro cria e reporta um alerta
     * @param url URL da imagem da carta
     */
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

    /**
     *
     * Funcao que ira limpar campos onde pode se digitar dados das cartas: <br>
     *     Campos de Correcao ou de Cadastro
     * @param opcao Opcao que depende de quando a funcao for usada
     */
    public void limpaCampos(String opcao){

        if(opcao.equals("correcao")){
            txtColecaoCorrecao.clear();
            txtNomeCorrecao.clear();
            txtRaridadeCorrecao.clear();
            txtSerieCorrecao.clear();
            txtUrlCorrecao.clear();
            txtIdCorrecao.clear();
        }else if(opcao.equals("cadastro")){
            txtNomeCadastro.clear();
            txtRaridadeCadastro.clear();
            txtSerieCadastro.clear();
            txtUrlCadastro.clear();
            txtIdCadastro.clear();
            txtColecaoCadastro.clear();
        }

    }
}
