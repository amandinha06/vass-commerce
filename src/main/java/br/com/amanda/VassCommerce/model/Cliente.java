package br.com.amanda.VassCommerce.model;

import java.util.Date;

public class Cliente extends Usuario {
    private Date dataNascimento;
    private String cpf;

    public Cliente(String nomeCompleto, String fotoUrl, Date dataNascimento, String cpf) {
        super(nomeCompleto, fotoUrl);
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
