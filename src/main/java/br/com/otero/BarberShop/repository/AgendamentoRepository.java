package br.com.otero.BarberShop.repository;

import br.com.otero.BarberShop.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {


}
