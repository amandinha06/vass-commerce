package br.com.amanda.VassCommerce.service;

import br.com.amanda.VassCommerce.dto.ProdutoCreateRequest;
import br.com.amanda.VassCommerce.dto.ProdutoMapper;
import br.com.amanda.VassCommerce.model.Produto;
import br.com.amanda.VassCommerce.model.ProdutoModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service("produtoModelMemoria")
public class ProdutoModelMemoria implements ProdutoModel {

    private final List<Produto> produtos = new ArrayList<>();

    private final AtomicLong sequencia = new AtomicLong(0);

    @Override
    public Produto criar(ProdutoCreateRequest req){
        Long novoId = sequencia.incrementAndGet();

        Produto produto = ProdutoMapper.toEntity(req, novoId);

        produtos.add(produto);

        return produto;
    }

    @Override
    public Optional<Produto> obterPorId(Long id){

        return produtos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Produto> buscar(
            String nome,
            BigDecimal valorMinimo,
            BigDecimal valorMaximo) {

        return produtos.stream()
                .filter(produto ->
                        nome == null ||
                                produto.getNome().toLowerCase().contains(nome.toLowerCase())
                )
                .filter(produto ->
                        valorMinimo == null ||
                                BigDecimal.valueOf(produto.getValorUnitario())
                                        .compareTo(valorMinimo) >= 0
                )
                .filter(produto ->
                        valorMaximo == null ||
                                BigDecimal.valueOf(produto.getValorUnitario())
                                        .compareTo(valorMaximo) <= 0
                )
                .toList();
    }
}
