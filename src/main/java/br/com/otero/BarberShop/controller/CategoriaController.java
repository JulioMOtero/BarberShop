package br.com.otero.BarberShop.controller;

import br.com.otero.BarberShop.model.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {


    @GetMapping
    public List<Categoria> listar(){
       Categoria cat1 = Categoria.builder().id(1L).nome("cerveja").build();
       Categoria cat2 = Categoria.builder().id(2L).nome("refrigerante").build();

        List<Categoria> lista = new ArrayList<>();

        lista.add(cat1);
        lista.add(cat2);
        return lista;
    }

}
