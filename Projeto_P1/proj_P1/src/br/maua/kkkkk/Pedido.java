package br.maua.kkkkk;

import java.util.Random;

import br.maua.jjjjj.EstadoPedido;
import br.maua.jjjjj.TipoPagamento;

/**
 * 
 * Classe concreta do Pedido.
 * Define o funcionamento de um Pedido feito no sistema.

 * @author João Guilherme Martins Jatobá - 18.01790-8@maua.br
 * @since 15/06/2020
 * @version 1.0
 */

public class Pedido {
    /**
     * Variável tipo String, 
     * representa a id deste pedido.
     */
    private String id = geradorId();

    /**
     * Variável tipo String, 
     * representa a descrição deste pedido.
     */
    private String descricao;

    /**
     * Variável tipo float, 
     * representa valor do pedido.
     */
    private float valor;

    /**
     * Variável do tipo TipoPagamento, 
     * representa p tipo de pagamento deste pedido.
     */
    private TipoPagamento pagamento;

    /**
     * Variável do tipo EstadoPedido, 
     * representa o estado atual do pedido.
     * Quando instanciado, o pedido começa
     * com estadoPedido = REALIZADO
     */
    private EstadoPedido estadoPedido;

    /**
     * Método construtor da classe.
     * Iniciado quando um pedido novo é feito.
     * Recebe descrição do pedido, valor e forma de pagamento.
     * @param descricao
     * @param valor
     * @param pagamento
     */
    public Pedido(String descricao, float valor, TipoPagamento pagamento) {
        this.descricao = descricao;
        this.valor = valor;
        this.pagamento = pagamento;
        this.setEstadoPedido(EstadoPedido.REALIZADO);}

    /** 
     * Método que cria uma String dedicada a cada pedido
     * @return String
     */
    private String geradorId(){
        Random random = new Random();
        String idGerado = "";
        for (int i = 0; i < 3; i++) {
            idGerado += random.nextInt(10);}
        return idGerado;}
    /** 
     * Método de descrição de cada pedido
     * @return String com todos os dados
     */
    @Override
    public String toString() {
        return "Pedido "+id+":\n\tDescricao: " + descricao + "\n\tEstado do pedido: " + estadoPedido + "\n\tMeio de pagamento: "
                + pagamento + "\n\tValor: R$ " + valor+"\n";}
    
    /** 
     * Retorna o ID do pagamento.
     * @return String
     */
    public String getId() {
        return id;}

    /** 
     * Método que muda o estado do pedido
     * Recebe o novo estado e faz a mudança
     * @param estadoPedido
     */
    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;}   
}