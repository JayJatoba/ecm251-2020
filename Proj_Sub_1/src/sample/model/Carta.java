package sample.model;

public class Carta {
    private String urlImagem;
    private int colecao;
    private static int id=-1;
    private String nome,raridade,serie;

    public Carta(String urlImagem, int colecao, String nome, String raridade, String serie) {
        this.urlImagem = urlImagem;
        this.id = id+1;
        this.colecao = colecao;
        this.nome = nome;
        this.raridade = raridade;
        this.serie = serie;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public int getId() {
        return id;
    }

    public int getColecao() {
        return colecao;
    }

    public String getNome() {
        return nome;
    }

    public String getRaridade() {
        return raridade;
    }

    public String getSerie() {
        return serie;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public void setColecao(int colecao) {
        this.colecao = colecao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
}
