package br.com.otero.BarberShop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProdutoVenda {

    @EmbeddedId
    ProdutoVendaFks id;

    @ManyToOne
    @MapsId("produtoId")
    @JoinColumn(name = "id_produto")
    Produto produto;

    @ManyToOne
    @MapsId("vendaId")
    @JoinColumn(name = "id_venda")
    Venda venda;

    int qtd_produtos;
}
