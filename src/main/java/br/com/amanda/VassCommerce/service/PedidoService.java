package br.com.amanda.VassCommerce.service;

import br.com.amanda.VassCommerce.model.Cliente;
import br.com.amanda.VassCommerce.model.Pagamento;
import br.com.amanda.VassCommerce.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();

    public PedidoService(
            ClienteService clienteService,
            PagamentoService pagamentoService
    ){
        Cliente cliente = clienteService.getClientes().get(0);
        Pagamento pagamento = pagamentoService.getPagamentos().get(0);

        Pedido pedidoUm = new Pedido(cliente, pagamento);

        adicionarIdPedido(pedidoUm);
    }

    private void adicionarIdPedido(Pedido pedido){
        pedido.setId(pedidos.size() + 1);
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
         return pedidos;
    }
}
