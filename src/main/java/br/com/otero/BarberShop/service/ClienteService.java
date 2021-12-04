package br.com.otero.BarberShop.service;


import br.com.otero.BarberShop.model.Cliente;
import br.com.otero.BarberShop.model.dto.ClienteRequest;
import br.com.otero.BarberShop.model.dto.ClienteResponse;
import br.com.otero.BarberShop.repository.ClienteRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClienteService {


    @Autowired
    ClienteRepository clienteRepository;


    public List<Cliente> listaCliente(Long id) {
        Optional<Cliente> clientes = this.clienteRepository.findById(id);
        return clientes.stream().map(cliente ->
                Cliente.builder()
                        .id(cliente.getId())
                        .email(cliente.getEmail())
                        .qtdCortes(cliente.getQtdCortes())
                        .build()).collect(Collectors.toList());
    }
    public List<Cliente> todosClientes(){
        return this.clienteRepository.findAll();
    }

    public ClienteResponse novoCliente(ClienteRequest newCliente) {
        Cliente cliente = Cliente.builder()
                .email(newCliente.getEmail())
                .qtdCortes(0)
                .build();

        this.clienteRepository.save(cliente);


        return ClienteResponse.builder()
                .id(cliente.getId())
                .build();
    }

    public void deletar(Long id) {
        List<Cliente> cliente = listaCliente(id);
       this.clienteRepository.deleteAll(cliente);

    }

    public void corte(Long id_cli) throws NotFoundException {
        Cliente cliente = this.clienteRepository.findById(id_cli).orElseThrow(() -> new NotFoundException("id: " + id_cli + " Não encontrado"));
        Integer qtdCortes = cliente.getQtdCortes();

        qtdCortes = qtdCortes+1;
    }


}
