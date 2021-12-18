package br.com.otero.BarberShop.service;

import br.com.otero.BarberShop.model.Agendamento;
import br.com.otero.BarberShop.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AgendamentoService {

    @Autowired
    AgendamentoRepository agendamentoRepository;

    public List<Agendamento> obterAgendamento(Long id) {
        Optional<Agendamento> agendamentos = this.agendamentoRepository.findById(id);
        return agendamentos.stream().map(agendamento ->
                Agendamento.builder()
                        .id_agendamento(agendamento.getId_agendamento())
                        .horario(new Date())
                        .servico(agendamento.getServico())
                        .id_cliente(agendamento.getId_cliente())
                        .id_funcionario(agendamento.getId_funcionario())

                        .build()).collect(Collectors.toList());
    }

    public List<Agendamento> todosAgendamentos() {
        return this.agendamentoRepository.findAll();
    }

    // fazer cadastro de agendamento
    // > criar AgendamentoRequest (quais infos ele vai pegar?)
    // qual vai ser o return(AgendamentoResponse) desse metodo(id_agendamento e data
    //

}
