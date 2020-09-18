package sample.model;

public class Carta {
    private String urlImagem,idCarta, colecao;
    private String nome,raridade,serie;

    /**
     *
     * @param idCarta id unico da carta ex: (xy8-144)
     * @param urlImagem url completo da imagem da carta ex: (https://images.pokemontcg.io/xy8/144.png)
     * @param nome nome do Pokemon ex: (Mewtwo Spirit Link)
     * @param raridade raridadde do Pokemon ex: (Uncommon)
     * @param serie serie do pokemon ex: (XY)
     * @param colecao colecao a qual a carta pertence ex: (BREAKthrough)
     *
     */
    public Carta(String idCarta,String urlImagem, String nome, String raridade, String serie, String colecao) {
        this.urlImagem = urlImagem;
        this.idCarta = idCarta;
        this.colecao = colecao;
        this.nome = nome;
        this.raridade = raridade;
        this.serie = serie;
    }

    /**
     * @return URL da imagem da carta
     */
    public String getUrlImagem() {
        return urlImagem;
    }

    /**
     * @return Colecao a qual a carta pertence
     */
    public String getColecao() {
        return colecao;
    }

    /**
     * @return Nome da carta
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return Raridade da carta
     */
    public String getRaridade() {
        return raridade;
    }

    /**
     * @return Serie da carta
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @return ID unico da carta
     */
    public String getIdCarta() {
        return idCarta;
    }

    /**
     * @param idCarta ID unico da carta
     * Muda o ID unico da carta para a String recebida
     */
    public void setIdCarta(String idCarta) {
        this.idCarta = idCarta;
    }

    /**
     * @param urlImagem
     * Muda o URL da imagem da carta para a String recebida
     */
    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    /**
     * @param colecao
     * Muda a colecao da  carta para a String recebida
     */
    public void setColecao(String colecao) {
        this.colecao = colecao;
    }

    /**
     * @param nome
     * Muda o nome da carta para a String recebida
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param raridade
     * Muda a raridade da carta para a String recebida
     */
    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }

    /**
     * @param serie
     * Muda serie da carta para a String recebida
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }


}
