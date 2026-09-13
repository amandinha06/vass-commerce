package br.com.amanda.VassCommerce.service;

import br.com.amanda.VassCommerce.model.Cartao;
import br.com.amanda.VassCommerce.model.Pagamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagamentoService {

    private List<Pagamento> pagamentos = new ArrayList<>();

    private CartaoService cartaoService;

    public PagamentoService(CartaoService cartaoService) {

        this.cartaoService = cartaoService;

        Pagamento pagamento = new Pagamento(100.00);

        Cartao cartaoDebito = cartaoService.getCartoes().get(0);
        Cartao cartaoCredito = cartaoService.getCartoes().get(1);

        pagamento.getCartoes().add(cartaoDebito);
        pagamento.getCartoes().add(cartaoCredito);

        pagamentos.add(pagamento);
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }
}