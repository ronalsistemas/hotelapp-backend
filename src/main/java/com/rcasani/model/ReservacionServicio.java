package com.rcasani.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ReservacionServicioPK.class)
public class ReservacionServicio {

    @Id
    private Reservacion reservation;

    @Id
    private ServicioHotel service;

    @Column(name = "cantidad")
    private Integer quantity;
}
