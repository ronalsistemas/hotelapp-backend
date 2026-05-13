package com.rcasani.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleReservaDTO {

    private Integer idDetail;

    @JsonBackReference
    private ReservacionDTO reservation;

    //@JsonBackReference
    private HabitacionDTO room;

    private BigDecimal price;

    private Integer nights;
}
