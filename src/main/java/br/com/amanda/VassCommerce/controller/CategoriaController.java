package br.com.amanda.VassCommerce.controller;

import br.com.amanda.VassCommerce.model.Categoria;
import br.com.amanda.VassCommerce.model.Produto;
import br.com.amanda.VassCommerce.service.CategoriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriaController {

    private CategoriaService categoriaService;
    private ProdutoController produtoController;

    public CategoriaController(
            CategoriaService categoriaService,
            ProdutoController produtoController) {

        this.categoriaService = categoriaService;
        this.produtoController = produtoController;
    }

    @GetMapping("/categoria")
    public List<Categoria> listarCategorias(
            @RequestParam(required = false) String nome) {

        List<Categoria> categorias = categoriaService.getCategorias();

        if (nome != null) {
            for (Categoria categoria : categorias) {
                if (categoria.getNome().equals(nome)) {
                    return List.of(categoria);
                }
            }

            return List.of();
        }

        return categorias;
    }

    @GetMapping("/categoria/{idcategoria}/produto")
    public List<Produto> listarProdutosCategoria(
            @PathVariable int idcategoria) {

        List<Produto> encontrados = new ArrayList<>();

        for (Produto produto : produtoController.getProdutos()) {
            if (produto.getCategoria().getId() == idcategoria) {
                encontrados.add(produto);
            }
        }

        return encontrados;
    }
}