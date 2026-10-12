package br.com.amanda.VassCommerce.controller;

import br.com.amanda.VassCommerce.model.Categoria;
import br.com.amanda.VassCommerce.model.Produto;
import br.com.amanda.VassCommerce.model.ProdutoModel;
import br.com.amanda.VassCommerce.service.CategoriaService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final ProdutoModel produtoModel;

    public CategoriaController(
            CategoriaService categoriaService,
            @Qualifier("produtoModelSql") ProdutoModel produtoModel) {

        this.categoriaService = categoriaService;
        this.produtoModel = produtoModel;
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

        List <Produto> produtos = produtoModel.buscar(null, null, null);

        for (Produto produto : produtos) {
            if (produto.getCategoria() != null
                    && produto.getCategoria().getId() == idcategoria) {
                encontrados.add(produto);
            }
        }

        return encontrados;
    }
}