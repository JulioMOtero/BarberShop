package br.com.otero.BarberShop.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {

    @OneToMany(mappedBy = "produto")
//    @JoinTable(
//            name = "produto_venda",
//            joinColumns = @JoinColumn(name = "id_produto"),
//            inverseJoinColumns = @JoinColumn(name = "id_venda"))
    Set<ProdutoVenda> venda;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
