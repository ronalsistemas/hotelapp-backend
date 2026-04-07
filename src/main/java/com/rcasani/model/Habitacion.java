package com.rcasani.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Integer idRoom;

    @ManyToOne
    @JoinColumn(name = "id_hotel", nullable = false, foreignKey = @ForeignKey(name = "fk_habitacion_hotel"))
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "id_tipo_habitacion", nullable = false, foreignKey = @ForeignKey(name = "fk_habitacion_tipoHabitacion"))
    private TipoHabitacion roomType;

    @Column(name = "numero_habitacion", length = 10, nullable = false)
    private String roomNumber;

    @Column(name = "piso_habitacion")
    private Integer floor;

    @Column(name = "estado_habitacion", length = 20)
    private String status; // disponible, ocupada, mantenimiento
}
