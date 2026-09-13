package br.com.amanda.VassCommerce.service;

import br.com.amanda.VassCommerce.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    private List<Categoria> categorias = new ArrayList<>();

    public CategoriaService() {
        adicionarIdCategoria(
                new Categoria("aa.com.br", "Terror", "TerrorTerror")
        );

        adicionarIdCategoria(
                new Categoria("bb.com.br", "Romance", "RomanceRomance")
        );
    }

    private void adicionarIdCategoria(Categoria categoria) {
        categoria.setId(categorias.size() + 1);
        categorias.add(categoria);
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }
}