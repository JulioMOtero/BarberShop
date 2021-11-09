package br.com.otero.BarberShop.repository;

import br.com.otero.BarberShop.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {


}
