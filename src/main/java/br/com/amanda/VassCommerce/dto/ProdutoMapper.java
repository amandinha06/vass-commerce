package br.com.amanda.VassCommerce.dto;

import br.com.amanda.VassCommerce.model.Produto;
import java.time.LocalDateTime;

import java.time.LocalDateTime;

public class ProdutoMapper {

    public static Produto toEntity(ProdutoCreateRequest req, Long id){
        Produto produto = new Produto(
                req.getNome(),
                req.getDescricao(),
                req.getFotoUrl(),
                req.getValorUnitario(),
                req.getCategoria()
        );
        produto.setId(id);
        produto.setDataCadastro(LocalDateTime.now());
        produto.setDataUltimaAtualizacao(LocalDateTime.now());

        return produto;
    }

    public static ProdutoResponse toResponse(Produto produto){

        ProdutoResponse response = new ProdutoResponse();

        response.setId(produto.getId());
        response.setNome(produto.getNome());
        response.setDescricao(produto.getDescricao());
        response.setFotoUrl(produto.getFotoUrl());
        response.setDataCadastro(produto.getDataCadastro());
        response.setDataUltimaAtualizacao(produto.getDataUltimaAtualizacao());
        response.setValorUnitario(produto.getValorUnitario());
        response.setCategoria(produto.getCategoria());

        return response;
    }
}
