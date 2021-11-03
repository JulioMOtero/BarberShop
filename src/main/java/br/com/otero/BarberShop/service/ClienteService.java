package br.com.otero.BarberShop.service;


import br.com.otero.BarberShop.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteService {


    @Autowired
    ClienteRepository clienteRepository;
}
