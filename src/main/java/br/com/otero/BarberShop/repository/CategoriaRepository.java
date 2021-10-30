package br.com.otero.BarberShop.repository;

import br.com.otero.BarberShop.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
