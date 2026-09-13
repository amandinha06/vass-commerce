package br.com.amanda.VassCommerce.controller;

import br.com.amanda.VassCommerce.model.TipoCartao;
import br.com.amanda.VassCommerce.service.TipoCartaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TipoCartaoController {

    private TipoCartaoService tipoCartaoService;

    public TipoCartaoController(TipoCartaoService tipoCartaoService){
        this.tipoCartaoService = tipoCartaoService;
    }

    @GetMapping("/tipo-cartao")
    public List<TipoCartao> listarTiposCartao(){
        return tipoCartaoService.getTiposCartao();
    }
}
