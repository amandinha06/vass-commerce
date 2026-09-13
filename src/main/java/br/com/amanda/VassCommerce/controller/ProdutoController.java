package br.com.amanda.VassCommerce.controller;

import br.com.amanda.VassCommerce.model.Categoria;
import br.com.amanda.VassCommerce.model.Produto;
import br.com.amanda.VassCommerce.service.CategoriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

    private CategoriaService categoriaService;

    public ProdutoController(CategoriaService categoriaService) {

        this.categoriaService = categoriaService;

        List<Categoria> categorias = categoriaService.getCategorias();

        Categoria terror = categorias.get(0);
        Categoria romance = categorias.get(1);

        Produto livroTerror = new Produto(
                "Livro de Terror",
                "Assustador",
                "aa.com.br",
                39.90,
                terror
        );

        adicionarIdCategoriaProduto(livroTerror);

        Produto livroRomance = new Produto(
                "Livro de Romance",
                "Amor",
                "bb.com.br",
                29.90,
                romance
        );

        adicionarIdCategoriaProduto(livroRomance);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    private void adicionarIdCategoriaProduto(Produto produto) {
        produto.setId(produtos.size() + 1);
        produtos.add(produto);
    }

    @GetMapping("/produto/{id}")
    public List<Produto> listarProdutoId(@PathVariable int id) {

        Produto encontrado = null;

        for (Produto produto : produtos) {
            if (id == produto.getId()) {
                encontrado = produto;
            }
        }

        if (encontrado == null) {
            return List.of();
        }

        return List.of(encontrado);
    }
}