package br.com.amanda.VassCommerce.model;

import java.time.LocalDateTime;

public class Usuario {
    private int id;
    private String nomeCompleto;
    private LocalDateTime datUltimaAtualizacao;
    private LocalDateTime dataCadastro;
    private String fotoUrl;

    public Usuario(String nomeCompleto, String fotoUrl) {
        this.nomeCompleto = nomeCompleto;
        this.fotoUrl = fotoUrl;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDatUltimaAtualizacao() {
        return datUltimaAtualizacao;
    }

    public void setDatUltimaAtualizacao(LocalDateTime datUltimaAtualizacao) {
        this.datUltimaAtualizacao = datUltimaAtualizacao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }
}
