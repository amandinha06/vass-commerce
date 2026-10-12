package br.com.amanda.VassCommerce.model;

import br.com.amanda.VassCommerce.dto.ProdutoCreateRequest;

import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

public interface ProdutoModel {
    Produto criar(ProdutoCreateRequest req);

    Optional<Produto> obterPorId(Long id);

    List<Produto> buscar(
            String nome,
            BigDecimal valorMinimo,
            BigDecimal valorMaximo
    );
}
