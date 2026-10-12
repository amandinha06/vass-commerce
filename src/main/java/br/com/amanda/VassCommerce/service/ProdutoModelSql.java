package br.com.amanda.VassCommerce.service;

import br.com.amanda.VassCommerce.dto.ProdutoCreateRequest;
import br.com.amanda.VassCommerce.model.Produto;
import br.com.amanda.VassCommerce.model.ProdutoModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service("produtoModelSql")
public class ProdutoModelSql implements ProdutoModel {

    private final ProdutoModel memoria;

    public ProdutoModelSql(
            @Qualifier("produtoModelMemoria") ProdutoModel memoria){
        this.memoria = memoria;
    }

    @Override
    public Produto criar(ProdutoCreateRequest req) {
        return memoria.criar(req);
    }

    @Override
    public Optional<Produto> obterPorId(Long id){
        return memoria.obterPorId(id);
    }

    @Override
    public List<Produto> buscar(
            String nome,
            BigDecimal valorMinimo,
            BigDecimal valorMaximo){

        return memoria.buscar(nome, valorMinimo, valorMaximo);
    }
}
