package br.maua.model;

public class Item {
    private String nome;
    private float preco;
    private float peso;
    private int quant;

    public Item(String nome, float preco, float peso, int quant) {
        this.nome = nome;
        this.preco = preco;
        this.peso = peso;
        this.quant = quant;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
}
