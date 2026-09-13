package br.com.amanda.VassCommerce.service;

import br.com.amanda.VassCommerce.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();

    public ClienteService(){
        adicionarIdCliente(
                new Cliente(
                        "Amanda Diniz",
                        "foto1.com",
                        new Date(),
                        "123654"
                )
        );

        adicionarIdCliente(
                new Cliente(
                        "Kaio Carlos",
                        "foto2.com",
                        new Date(),
                        "654123"
                )
        );
    }

    private  void adicionarIdCliente(Cliente cliente){
        cliente.setId(clientes.size() + 1);
        clientes.add(cliente);
    }

    public List<Cliente> getClientes(){
        return clientes;
    }
}
