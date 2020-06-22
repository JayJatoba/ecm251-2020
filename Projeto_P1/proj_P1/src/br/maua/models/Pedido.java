package br.maua.models;

import java.util.Random;

import br.maua.enums.EstadoPedido;
import br.maua.enums.TipoPagamento;

/**
 * 
 * Classe concreta do Pedido.
 * Define o funcionamento de um Pedido feito no sistema.
 * 
 * 
 * @author João Guilherme Martins Jatobá - 18.01790-8@maua.br
 * @since 15/06/2020
 * @version 1.0
 */


public class Pedido {
    private String id = geradorId();
    private String descricao;
    private float valor;
    private TipoPagamento pagamento;
    private EstadoPedido estadoPedido;


    
    /** 
     * Método que cria uma String dedicada a cada pedido
     * 
     * @return String
     */
    private String geradorId(){
        Random random = new Random();
        String idGerado = "";
        for (int i = 0; i < 3; i++) {
            idGerado += random.nextInt(10);
        }
        return idGerado;
    }

    
    /** 
     * Método de descrição de cada pedido
     * 
     * 
     * @return String com todos os dados
     */
    @Override
    public String toString() {
        return "Pedido [descricao=" + descricao + ", estadoPedido=" + estadoPedido + ", id=" + id + ", pagamento="
                + pagamento + ", valor=" + valor + "]";
    }

    
    /** 
     * Método de retorno somente da descrição
     * 
     * @return String 
     */
    public String getDescricao() {
        return descricao;
    }

    
    /** 
     * Retorna o tipo de pagamento
     * 
     * @return TipoPagamento
     */
    public TipoPagamento getPagamento() {
        return pagamento;
    }

    
    /** 
     * Retorna o ID do pagamento.
     * 
     * @return String
     */
    public String getId() {
        return id;
    }

    
    /** 
     * Método que retorna o valor do pedido
     * 
     * @return float
     */
    public float getValor() {
        return valor;
    }

    
    /** 
     * 
     * Método que retorna o estado atual do pedido
     * 
     * @return EstadoPedido
     */
    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    
    /** 
     * Método que muda o estado do pedido
     * Recebe o estado que será o novoestado do pedido
     * 
     * @param estadoPedido
     */
    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }


    /**
     * 
     * Método construtor da classe.
     * Iniciado quando um pedido novo é feito.
     * Recebe descrição do pedido, valor e forma de pagamento.
     * 
     * @param descricao
     * @param valor
     * @param pagamento
     */
    public Pedido(String descricao, float valor, TipoPagamento pagamento) {
        this.descricao = descricao;
        this.valor = valor;
        this.pagamento = pagamento;
        this.setEstadoPedido(EstadoPedido.REALIZADO);
    }
    
    
}