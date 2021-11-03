package br.com.otero.BarberShop.controller;


import br.com.otero.BarberShop.model.Cliente;
import br.com.otero.BarberShop.model.dto.ClienteRequest;
import br.com.otero.BarberShop.model.dto.ClienteResponse;
import br.com.otero.BarberShop.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
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

    @Transactional
    @PostMapping("/novo")
    public ResponseEntity<ClienteResponse> novoCliente(@RequestBody ClienteRequest email){
        return ResponseEntity.created(URI.create("")).body(this.clienteService.novoCliente(email));
    }

}
