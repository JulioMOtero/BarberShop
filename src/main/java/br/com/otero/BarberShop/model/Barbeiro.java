package br.com.otero.BarberShop.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Barbeiro {

    private Funcionario funcionario;
    private List<String> agenda;
}
