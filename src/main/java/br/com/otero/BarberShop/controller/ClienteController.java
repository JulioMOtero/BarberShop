package br.com.otero.BarberShop.controller;


import br.com.otero.BarberShop.model.Cliente;
import br.com.otero.BarberShop.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> todosCLientes(){
        return ResponseEntity.ok(clienteService.todosClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Cliente>> listarCliente(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.listaCliente(id));

    }

}
