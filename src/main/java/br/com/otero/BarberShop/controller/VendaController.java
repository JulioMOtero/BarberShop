package br.com.otero.BarberShop.controller;

import br.com.otero.BarberShop.model.Venda;
import br.com.otero.BarberShop.model.dto.VendaResponse;
import br.com.otero.BarberShop.service.ClienteService;
import br.com.otero.BarberShop.service.VendaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    VendaService vendaService;

    @Autowired
    ClienteService clienteService;


    @GetMapping
    public ResponseEntity<List<Venda>> todasVendas() {
        return ResponseEntity.ok(vendaService.historico());
    }

    @PostMapping("/{id_fun}/{id_cli}")
    public ResponseEntity<VendaResponse> marcarHorario(@PathVariable Long id_fun, @PathVariable Long id_cli) {
        return ResponseEntity.created(URI.create("")).body(vendaService.agendamento(id_fun, id_cli));
    }

//    @PutMapping("/comanda/{id}")
//    public ResponseEntity comanda(@PathVariable Long id, @RequestBody Venda produtos){
//
//       Optional<Venda> idVenda = this.vendaService.buscaId(id);
//
////        idVenda(path) + produtosConsumidos(body)
//        return ResponseEntity.created(URI.create("")).body(vendaService.comanda(/*idVenda,*/produtos));
//    }

    @Transactional
    @PutMapping("/{id}/pay")
    ResponseEntity pagamento(@PathVariable Long id) throws NotFoundException {
        this.vendaService.pagamento(id);
        this.clienteService.corte(id);
        return ResponseEntity.ok().build();
    }

}
