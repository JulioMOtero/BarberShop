package br.com.otero.BarberShop.repository;

import br.com.otero.BarberShop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BarbeiroRepository extends JpaRepository<Cliente, Long> {


    @Query("SELECT c FROM Corte c " +
            "WHERE Cliente ")
    List<Cliente> findClientesByBarberiro(Long id/*, */ );
}
