package br.com.otero.BarberShop.model.dto;


import br.com.otero.BarberShop.model.Venda;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendaResponse {

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date horarioMarcado ;

//    @mappedBy(Venda.class)
//    private Long id;

}
