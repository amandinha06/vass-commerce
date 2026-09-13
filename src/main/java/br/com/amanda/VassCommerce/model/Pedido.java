package br.com.amanda.VassCommerce.model;

import java.time.LocalDateTime;

public class Pedido {
    private int id;
    private LocalDateTime dataPedido;
    private Cliente cliente;
    private Pagamento pagamento;

    public Pedido(Cliente cliente, Pagamento pagamento){
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.dataPedido = LocalDateTime.now();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
