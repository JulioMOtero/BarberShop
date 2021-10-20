package br.com.otero.BarberShop.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
@Entity
public class Corte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean cabelo;
    private Boolean barba;
    private Date agendamento;
    private Long id_funcionario;
    private Long id_Cliente;


}
