package br.com.otero.BarberShop.repository;

import br.com.otero.BarberShop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}
