package br.maua.model;


/**
 * Classe da implementacao de itens de cada personagem
 * @author Andre Lebrao 18.00356-7
 * @author Joao Guilherme Jatoba 18.01790-8
 * @since 24/11/2020
 */
public class Item {
    private String nome;
    private float preco;
    private float peso;
    private int quant;

    /**
     * Construtor da classe Item
     * @param nome Nome do item
     * @param preco Preco do item
     * @param peso Peso do item
     * @param quant Quantidade do item
     */
    public Item(String nome, float preco, float peso, int quant) {
        this.nome = nome;
        this.preco = preco;
        this.peso = peso;
        this.quant = quant;
    }

    /**
     *
     * @return Retorna nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Determina o nome do item
     * @param nome Nome a ser colocado
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return Retorna o preco do item
     */
    public float getPreco() {
        return preco;
    }

    /**
     * Determina o preco do item
     * @param preco Preco a ser colocado
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     *
     * @return Retorna o peso do item
     */
    public float getPeso() {
        return peso;
    }

    /**
     * Determina o peso do item
     * @param peso Peso a ser colocado
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     *
     * @return Retorna quantidade do item especifico em posse do personagem
     */
    public int getQuant() {
        return quant;
    }

    /**
     * Determina a quantidade desse item que o personagem possui
     * @param quant Quantidade a ser colocada
     */
    public void setQuant(int quant) {
        this.quant = quant;
    }
}
