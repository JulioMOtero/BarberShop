package br.com.otero.BarberShop.service;


import br.com.otero.BarberShop.model.Categoria;
import br.com.otero.BarberShop.model.Produto;
import br.com.otero.BarberShop.repository.CategoriaRepository;
import br.com.otero.BarberShop.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Produto> obterProdutoPorCategoria(Long id) {
        Optional<Produto> produtos = this.produtoRepository.findById(id);
        return produtos.stream().map(produto ->
                Produto.builder()
                        .id(produto.getId())
                        .nome(produto.getNome())
                        .preco(produto.getPreco())
                        .categoria(produto.getCategoria())
                        .build()).collect(Collectors.toList());
    }


    }



