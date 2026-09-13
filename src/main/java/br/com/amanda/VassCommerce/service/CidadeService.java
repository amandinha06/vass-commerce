package br.com.amanda.VassCommerce.service;

import br.com.amanda.VassCommerce.model.Cidade;
import br.com.amanda.VassCommerce.model.Estado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CidadeService {

    private List<Cidade> cidades = new ArrayList<>();

    public CidadeService(EstadoService estadoService){
        Estado rio = estadoService.getEstados().get(0);
        Estado sao = estadoService.getEstados().get(1);

        cidades.add(new Cidade(1, "Barra do Piraí", rio));
        cidades.add(new Cidade(2, "São Paulo", sao));
    }

    public List<Cidade> getCidades(){
        return cidades;
    }
}
