package com.rcasani.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class ReservacionServicioPK {

    @ManyToOne
    @JoinColumn(name = "id_reservacion", foreignKey = @ForeignKey(name = "FK_RESERVACION_SERVICIO_R"))
    private Reservacion reservation;

    @ManyToOne
    @JoinColumn(name = "id_servicio", foreignKey = @ForeignKey(name = "FK_RESERVACION_SERVICIO_S"))
    private ServicioHotel service;
}
