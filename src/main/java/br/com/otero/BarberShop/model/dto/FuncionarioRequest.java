package br.com.otero.BarberShop.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioRequest {

    @NotNull
    @NotEmpty
    private String cargo;

    @NotNull
    @NotEmpty
    private String nome;
}
