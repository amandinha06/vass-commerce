package br.com.amanda.VassCommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Pagamento {

    private int id;
    private Double valorPago;
    private List<Cartao> cartoes = new ArrayList<>();

    public Pagamento(Double valorPago){
        this.valorPago = valorPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }
}
