package br.com.otero.BarberShop.service;

import br.com.otero.BarberShop.model.Cliente;
import br.com.otero.BarberShop.model.Venda;
import br.com.otero.BarberShop.model.dto.VendaRequest;
import br.com.otero.BarberShop.model.dto.VendaResponse;
import br.com.otero.BarberShop.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class VendaService {

    @Autowired
    VendaRepository vendaRepository;



    public List<Venda> historico(){
        return this.vendaRepository.findAll();
    }

    public VendaResponse agendamento(Long id_fun,Long id_cli){
        Venda venda = Venda.builder()
                .id_Funcionario(id_fun)
                .id_Cliente(id_cli)
                .agendamento(new Date())
                .build();
this.vendaRepository.save(venda);
        return VendaResponse.builder()
                .horarioMarcado(new Date())
                .build();
    }

}
