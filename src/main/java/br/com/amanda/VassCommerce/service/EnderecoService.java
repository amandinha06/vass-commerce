package br.com.amanda.VassCommerce.service;

import br.com.amanda.VassCommerce.controller.ClienteController;
import br.com.amanda.VassCommerce.model.Cidade;
import br.com.amanda.VassCommerce.model.Cliente;
import br.com.amanda.VassCommerce.model.Endereco;
import org.springframework.boot.web.servlet.ServletRegistration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {
    private List<Endereco> enderecos = new ArrayList<>();

    public EnderecoService(
            ClienteService clienteService,
            CidadeService cidadeService
    ){
        Cliente cliente = clienteService.getClientes().get(0);
        Cidade cidade = cidadeService.getCidades().get(0);

        Endereco enderecoUm = new Endereco(
                "Rua das Flores",
                "123",
                "Casa",
                "Centro",
                "21212",
                cliente,
                cidade
        );

        enderecoUm.setId(1);
        enderecos.add(enderecoUm);
    }
    public List<Endereco> getEnderecos(){
        return enderecos;
    }
}
