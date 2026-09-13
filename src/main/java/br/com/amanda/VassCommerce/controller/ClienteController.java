package br.com.amanda.VassCommerce.controller;

import br.com.amanda.VassCommerce.model.Cartao;
import br.com.amanda.VassCommerce.model.Cliente;
import br.com.amanda.VassCommerce.model.Endereco;
import br.com.amanda.VassCommerce.model.Pedido;
import br.com.amanda.VassCommerce.service.PedidoService;
import br.com.amanda.VassCommerce.service.EnderecoService;
import br.com.amanda.VassCommerce.service.CartaoService;
import br.com.amanda.VassCommerce.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClienteController {
    private ClienteService clienteService;
    private CartaoService cartaoService;
    private EnderecoService enderecoService;
    private PedidoService pedidoService;

    public ClienteController(ClienteService clienteService, CartaoService cartaoService, EnderecoService enderecoService, PedidoService pedidoService){
        this.clienteService = clienteService;
        this.cartaoService = cartaoService;
        this.enderecoService = enderecoService;
        this.pedidoService = pedidoService;
    }

    @GetMapping("/cliente/{id}")
    public List<Cliente> listarCliente(@PathVariable int id){

        for (Cliente cliente : clienteService.getClientes()){
            if (cliente.getId() == id){
                return  List.of(cliente);
            }
        }
        return List.of();
    }

    @GetMapping("/cliente/{idcliente}/formas-de-pagamento")
    public List<Cartao> listarFormasDePagamento(
            @PathVariable int idcliente
    ){
        List<Cartao> cartoesCliente = new ArrayList<>();

        for (Cartao cartao : cartaoService.getCartoes()){
            if(cartao.getTitular().getId() == idcliente){
                cartoesCliente.add(cartao);
            }
        }
        return cartoesCliente;
    }

    @GetMapping("/cliente/{idcliente}/endereco")
    public List<Endereco> listarEndereco(@PathVariable int idcliente){
        List<Endereco> encontrados = new ArrayList<>();
        for (Endereco endereco : enderecoService.getEnderecos()){
            if (endereco.getCliente().getId() == idcliente){
                encontrados.add(endereco);
            }
        }
        return encontrados;
    }

    @GetMapping("/cliente/{idcliente}/pedido")
    public List<Pedido> listarPedidosCliente(@PathVariable int idcliente){

        List<Pedido> enconntrados = new ArrayList<>();

        for(Pedido pedido : pedidoService.getPedidos()){
            if(pedido.getCliente().getId() == idcliente){
                enconntrados.add(pedido);
            }
        }
        return enconntrados;
    }
}
