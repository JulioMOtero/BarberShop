package br.com.otero.BarberShop.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pessoa {

    private String cpf;
    private String nome;


}
