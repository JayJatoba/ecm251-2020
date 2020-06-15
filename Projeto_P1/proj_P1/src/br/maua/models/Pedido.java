package br.maua.models;

import br.maua.enums.EstadoPedido;
import br.maua.enums.TipoPagamento;

public class Pedido {
    protected String id;
    protected String descricao;
    protected float valor;
    protected TipoPagamento pagamento;
    public EstadoPedido estadoPedido;


    public String getId() {
       return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public TipoPagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(TipoPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    
    
}