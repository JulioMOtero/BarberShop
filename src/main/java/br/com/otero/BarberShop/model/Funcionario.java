package br.com.otero.BarberShop.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Funcionario {

    private Long id;
    private String cargo;
}
