package br.com.otero.BarberShop.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProdutoVendaFks implements Serializable {


    @Column(name = "id_produto")
    Long produtoId;

    @Column(name = "id_venda")
    Long vendaId;

}
