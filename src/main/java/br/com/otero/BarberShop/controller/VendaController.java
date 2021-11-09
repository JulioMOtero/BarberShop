package br.com.otero.BarberShop.controller;

import br.com.otero.BarberShop.model.Venda;
import br.com.otero.BarberShop.model.dto.VendaResponse;
import br.com.otero.BarberShop.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<Venda>> todasVendas(){
        return ResponseEntity.ok(vendaService.historico());
    }

    @PostMapping("/{id_fun}/{id_cli}")
    public ResponseEntity<VendaResponse> marcarHorario(@PathVariable Long id_fun, @PathVariable Long id_cli ) {
        return ResponseEntity.created(URI.create("")).body(vendaService.agendamento(id_fun,id_cli));
    }
}
