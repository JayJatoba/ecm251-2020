package sample.model;

public class Carta {
    private String urlImagem,idCarta, colecao;
    private static int num =-1;
    private String nome,raridade,serie;

    public Carta(String idCarta,String urlImagem, String nome, String raridade, String serie, String colecao) {
        this.urlImagem = urlImagem;
        this.num = num +1;
        this.idCarta = idCarta;
        this.colecao = colecao;
        this.nome = nome;
        this.raridade = raridade;
        this.serie = serie;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public int getNum() {
        return num;
    }

    public String getColecao() {
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

    public String getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(String idCarta) {
        this.idCarta = idCarta;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public void setColecao(String colecao) {
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

    @Override
    public String toString() {
        return "Carta{" +
                "urlImagem='" + urlImagem + '\'' +
                ", idCarta='" + idCarta + '\'' +
                ", colecao='" + colecao + '\'' +
                ", nome='" + nome + '\'' +
                ", raridade='" + raridade + '\'' +
                ", serie='" + serie + '\'' +
                '}';
    }
}
