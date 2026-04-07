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
@Table(name = "tipo_habitacion")
public class TipoHabitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_habitacion")
    private Integer idRoomType;

    @Column(name = "nombre_habitacion", length = 50, nullable = false)
    private String name;

    @Column(name = "descripcion_habitacion", length = 255)
    private String description;

    @Column(name = "capacidad_habitacion")
    private Integer capacity;

    @Column(name = "precio_habitacion", precision = 10, scale = 2)
    private BigDecimal basePrice;
}
