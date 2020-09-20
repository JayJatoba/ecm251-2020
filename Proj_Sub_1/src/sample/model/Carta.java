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
     * @author Andre Lebrao 18.00356-7
     * @author Joao Guilherme Jatobá 18.01790-8
     * @since 15/09/2020
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
     * Muda o ID unico da carta
     * @param idCarta
     */
    public void setIdCarta(String idCarta) {
        this.idCarta = idCarta;
    }

    /**
     * Muda o URL da imagem da carta
     * @param urlImagem
     */
    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    /**
     *
     * Muda a colecao da carta
     * @param colecao
     */
    public void setColecao(String colecao) {
        this.colecao = colecao;
    }

    /**
     *
     * Muda o nome da carta
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * Muda a raridade da carta
     * @param raridade
     */
    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }

    /**
     *
     * Muda serie da carta
     * @param serie
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }


}
