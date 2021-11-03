package br.com.otero.BarberShop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @DateTimeFormat(pattern = "yyyyy/MM/dd")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date agendamento;
    private Long id_funcionario;
    private Long id_Cliente;

    @OneToMany
    List<Produto> produtos = new ArrayList<>();

}