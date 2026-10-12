package br.com.amanda.VassCommerce.dto;

import br.com.amanda.VassCommerce.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProdutoCreateRequest {

    @NotBlank(message = "Nome obrigatório!")
    private String nome;

    private String descricao;
    private String fotoUrl;

    @NotNull(message = "Valor obrigatório!")
    @Positive(message = "Valor deve ser positivo!")
    private Double valorUnitario;

    @NotNull(message = "Categoria obrigatória!")
    private Categoria categoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}