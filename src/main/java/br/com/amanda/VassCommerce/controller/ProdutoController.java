package br.com.amanda.VassCommerce.controller;

import br.com.amanda.VassCommerce.dto.ProdutoCreateRequest;
import br.com.amanda.VassCommerce.dto.ProdutoMapper;
import br.com.amanda.VassCommerce.dto.ProdutoResponse;
import br.com.amanda.VassCommerce.model.ProdutoModel;
import br.com.amanda.VassCommerce.model.Produto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produto", produces = "application/json")
public class ProdutoController {

    private final ProdutoModel model;

    public ProdutoController(
            @Qualifier("produtoModelSql") ProdutoModel model){
        this.model = model;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<ProdutoResponse> criar(
            @Valid @RequestBody ProdutoCreateRequest body
    ){
        Produto criado = model.criar(body);

        URI location = URI.create("/produto/" + criado.getId());

        return ResponseEntity
                .created(location)
                .body(ProdutoMapper.toResponse(criado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> obterPorId(
            @PathVariable Long id
    ){
        return model.obterPorId(id)
                .map(produto ->
                        ResponseEntity.ok(ProdutoMapper.toResponse(produto)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> buscar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) BigDecimal valorMinimo,
            @RequestParam(required = false) BigDecimal valorMaximo){

        List<Produto> produtos =
                model.buscar(nome, valorMinimo, valorMaximo);

        List<ProdutoResponse> respostas = produtos.stream()
                .map(ProdutoMapper::toResponse)
                .toList();

        return ResponseEntity.ok(respostas);
    }
}