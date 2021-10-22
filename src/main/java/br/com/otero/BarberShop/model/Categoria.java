package br.com.otero.BarberShop.model;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
}
