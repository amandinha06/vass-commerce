package br.com.amanda.VassCommerce.controller;

import br.com.amanda.VassCommerce.model.Cidade;
import br.com.amanda.VassCommerce.service.CidadeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CidadeController {

    private CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService){
        this.cidadeService = cidadeService;
    }

    @GetMapping("/estado/{idestado}/cidade")
    public List<Cidade> listarCidadesEstado(@PathVariable int idestado) {
        List<Cidade> cidadesEncontradas = new ArrayList<>();

        for (Cidade cidade : cidadeService.getCidades()){
            if (cidade.getEstado().getId() == idestado){
                cidadesEncontradas.add(cidade);
            }
        }
        return cidadesEncontradas;
    }
}
