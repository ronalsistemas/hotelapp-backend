package com.rcasani.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Reservacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservacion")
    private Integer idReservation;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "fk_reservacion_cliente"))
    private Cliente customer;

    @Column(name = "fecha_reservacion")
    private LocalDateTime reservationDate;

    @Column(name = "fecha_entrada")
    private LocalDate checkIn;

    @Column(name = "fecha_salida")
    private LocalDate checkOut;

    @Column(name = "estado_reservacion", length = 20)
    private String status; // confirmada, cancelada, pendiente

    @Column(name = "total_reservacion", precision = 10, scale = 2)
    private BigDecimal total;
}
