package br.com.otero.BarberShop.service;

import br.com.otero.BarberShop.model.Categoria;
import br.com.otero.BarberShop.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> obterCategoria(Long id) {
        Optional<Categoria> categorias = this.categoriaRepository.findById(id);
            return categorias.stream().map(categoria ->
                    Categoria.builder()
                    .id(categoria.getId())
                    .nome(categoria.getNome())
                            .produtos(categoria.getProdutos())
                    .build()).collect(Collectors.toList());
    }

}
