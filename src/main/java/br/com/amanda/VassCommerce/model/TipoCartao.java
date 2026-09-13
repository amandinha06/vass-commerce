package br.com.amanda.VassCommerce.model;

public class TipoCartao {
    public static final int DEBITO = 1;
    public static final int CREDITO = 2;

    private int id;
    private String nome;

    public TipoCartao(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
