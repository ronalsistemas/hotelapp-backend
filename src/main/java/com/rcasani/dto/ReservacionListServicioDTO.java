package com.rcasani.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservacionListServicioDTO {

    @NotNull
    private ReservacionDTO reservacion;

    @NotNull
    private List<ServicioHotelDTO> listServicio;
}
