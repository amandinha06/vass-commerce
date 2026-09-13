package br.com.amanda.VassCommerce.service;

import br.com.amanda.VassCommerce.model.Estado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadoService {

    private  List<Estado> estados = new ArrayList<>();

    public EstadoService(){
        estados.add(new Estado(1, "Rio de Janeiro", "RJ"));
        estados.add(new Estado(2,"São Paulo", "SP"));
    }

    public List<Estado> getEstados(){
        return estados;
    }
}
