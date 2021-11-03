package br.com.otero.BarberShop.controller;

import br.com.otero.BarberShop.model.Cliente;
import br.com.otero.BarberShop.model.Funcionario;
import br.com.otero.BarberShop.model.dto.ClienteRequest;
import br.com.otero.BarberShop.model.dto.ClienteResponse;
import br.com.otero.BarberShop.model.dto.FuncionarioRequest;
import br.com.otero.BarberShop.model.dto.FuncionarioResponse;
import br.com.otero.BarberShop.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> todosFuncionarios(){
        return ResponseEntity.ok(funcionarioService.todosFuncionarios());
    }


    @GetMapping("/{id}")
    public ResponseEntity<List<Funcionario>> listarFuncionarios(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.listaFuncionario(id));

    }

    @Transactional
    @PostMapping("/novo")
    public ResponseEntity<FuncionarioResponse> novoFuncionario(@RequestBody FuncionarioRequest novoFuncionario){
        return ResponseEntity.created(URI.create("")).body(this.funcionarioService.novoFuncionario(novoFuncionario));
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> deletarFuncionario(@PathVariable Long id){
        this.funcionarioService.deletar(id);
        return ResponseEntity.ok("Funcionario id: "+id+" deletado");

    }


}
