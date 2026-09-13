package br.com.amanda.VassCommerce.service;

import br.com.amanda.VassCommerce.model.Cartao;
import br.com.amanda.VassCommerce.model.Cliente;
import br.com.amanda.VassCommerce.model.TipoCartao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartaoService {

    private List<Cartao> cartoes = new ArrayList<>();

    private TipoCartaoService tipoCartaoService;
    private ClienteService clienteService;

    public CartaoService(
            TipoCartaoService tipoCartaoService,
            ClienteService clienteService) {

        this.tipoCartaoService = tipoCartaoService;
        this.clienteService = clienteService;

        TipoCartao debito = tipoCartaoService.getTiposCartao().get(0);
        TipoCartao credito = tipoCartaoService.getTiposCartao().get(1);

        Cliente cliente = clienteService.getClientes().get(0);

        Cartao cartaoDebito = new Cartao(debito, cliente);
        adicionarIdCartao(cartaoDebito);

        Cartao cartaoCredito = new Cartao(credito, cliente);
        adicionarIdCartao(cartaoCredito);
    }

    private void adicionarIdCartao(Cartao cartao) {
        cartao.setId(cartoes.size() + 1);
        cartoes.add(cartao);
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }
}
