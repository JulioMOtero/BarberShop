package br.com.otero.BarberShop.model;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Cliente {

    private Pessoa pessoa;
    private String email;
    private Integer qtdCortes;
}
