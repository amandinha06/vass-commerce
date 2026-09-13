package br.com.amanda.VassCommerce.controller;

import br.com.amanda.VassCommerce.model.Estado;
import br.com.amanda.VassCommerce.service.EstadoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstadoController {

    private EstadoService estadoService;

    public EstadoController(EstadoService estadoService){
        this.estadoService = estadoService;
    }

    @GetMapping("/estado")
    public List<Estado> listarEstados(){
        return estadoService.getEstados();
    }
}
