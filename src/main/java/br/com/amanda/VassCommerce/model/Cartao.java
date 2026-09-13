package br.com.amanda.VassCommerce.model;

import java.time.LocalDateTime;

public class Cartao {
    private int id;
    private LocalDateTime dataCriacao;
    private boolean excluido;
    private TipoCartao tipoCartao;
    private Cliente titular;

    public Cartao (TipoCartao tipoCartao, Cliente titular){
        this.tipoCartao = tipoCartao;
        this.titular = titular;
        this.dataCriacao = LocalDateTime.now();
        this.excluido = false;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    public TipoCartao getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(TipoCartao tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
}
