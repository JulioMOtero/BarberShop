package br.com.otero.BarberShop.controller;


import br.com.otero.BarberShop.model.Categoria;
import br.com.otero.BarberShop.model.Produto;
import br.com.otero.BarberShop.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Produto>> listarProduto(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.obterProdutoPorCategoria(id));
    }

}
