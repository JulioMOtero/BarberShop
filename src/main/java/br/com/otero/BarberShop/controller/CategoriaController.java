package br.com.otero.BarberShop.controller;

import br.com.otero.BarberShop.model.Categoria;
import br.com.otero.BarberShop.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/{id}")
public ResponseEntity<List<Categoria>> listarCategoria(@PathVariable Long id) {
    return ResponseEntity.ok(categoriaService.obterCategoria(id));
    }

}
