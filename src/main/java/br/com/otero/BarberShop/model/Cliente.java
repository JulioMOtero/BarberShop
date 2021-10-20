package br.com.otero.BarberShop.model;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Pessoa pessoa;
    private String email;
    private Integer qtdCortes;
}
