package com.rcasani.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservacionDTO {

    private Integer idReservation;

    private ClienteDTO customer;

    private Integer idUser;

    private LocalDateTime reservationDate;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private String status;

    private BigDecimal total;

    @NotNull
    @JsonManagedReference
    private List<DetalleReservaDTO> details;
}
