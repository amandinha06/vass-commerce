package br.com.amanda.VassCommerce.service;

import br.com.amanda.VassCommerce.model.TipoCartao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoCartaoService {
    private List<TipoCartao> tiposCartao = new ArrayList<>();

    public TipoCartaoService(){

        tiposCartao.add(
                new TipoCartao(TipoCartao.DEBITO, "Debito")
        );

        tiposCartao.add(
                new TipoCartao(TipoCartao.CREDITO, "credito")
        );
    }
    public List<TipoCartao> getTiposCartao(){
        return tiposCartao;
    }
}
