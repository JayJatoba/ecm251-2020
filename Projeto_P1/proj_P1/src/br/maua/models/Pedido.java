package br.maua.models;

import java.util.Random;

import br.maua.enums.EstadoPedido;
import br.maua.enums.TipoPagamento;

public class Pedido {
    private String id = geradorId();
    private String descricao;
    private float valor;
    private TipoPagamento pagamento;
    private EstadoPedido estadoPedido;


    

    private String geradorId(){
        Random random = new Random();
        String idGerado = "";
        for (int i = 0; i < 3; i++) {
            idGerado += random.nextInt(10);
        }
        return idGerado;
    }

    @Override
    public String toString() {
        return "Pedido [descricao=" + descricao + ", estadoPedido=" + estadoPedido + ", id=" + id + ", pagamento="
                + pagamento + ", valor=" + valor + "]";
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoPagamento getPagamento() {
        return pagamento;
    }

    public String getId() {
        return id;
    }

    public float getValor() {
        return valor;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Pedido(String descricao, float valor, TipoPagamento pagamento) {
        this.descricao = descricao;
        this.valor = valor;
        this.pagamento = pagamento;
        this.setEstadoPedido(EstadoPedido.REALIZADO);
    }
    
    
}