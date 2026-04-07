package com.rcasani.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "detalle_reserva")
public class DetalleReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer idDetail;

    @ManyToOne
    @JoinColumn(name = "id_reservacion", nullable = false, foreignKey = @ForeignKey(name = "fk_detalle_reservacion"))
    private Reservacion reservation;

    @ManyToOne
    @JoinColumn(name = "id_habitacion", nullable = false, foreignKey = @ForeignKey(name = "fk_detalle_habitacion"))
    private Habitacion room;

    @Column(name = "precio_detalle", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "noches_detalle")
    private Integer nights;
}
