package br.com.amanda.VassCommerce.model;

public class Cidade {

    private int id;
    private String nome;
    private Estado estado;

    public Cidade(int id, String nome, Estado estado){
        this.id = id;
        this.nome = nome;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
