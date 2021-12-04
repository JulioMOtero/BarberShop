package br.com.otero.BarberShop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "VENDA"/*, schema = "PUBLIC"*/)
public class Venda {


    @OneToMany(mappedBy = "venda")
    Set<ProdutoVenda> qtdProdutos;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date agendamento;
    private Long id_Funcionario;
    private Long id_Cliente;
    private Boolean pago = false;
    private Double valorTotal;
}
