package br.com.otero.BarberShop.repository;

import br.com.otero.BarberShop.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    @Query("select p from Produto p where id in :id")
    List<Produto> findByIds(@Param("id") List<Long> id);


    @Query("select v.preco from Produto v where v.id = :id")
    Double precoProduto(@Param("id") Long id);

}
