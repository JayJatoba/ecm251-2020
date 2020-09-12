package sample.model;

public class Pokemon {
    private String urlImagem;
    private int id,colecao;
    private String nome,raridade,serie;

    public Pokemon(String urlImagem, int id, int colecao, String nome, String raridade, String serie) {
        this.urlImagem = urlImagem;
        this.id = id;
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
}
