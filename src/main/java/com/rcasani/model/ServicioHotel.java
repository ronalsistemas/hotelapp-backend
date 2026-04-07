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
@Table(name = "servicio_hotel")
public class ServicioHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Integer idService;

    @Column(name = "nombre_servicio", length = 100, nullable = false)
    private String name; // wifi, spa, desayuno

    @Column(name = "descripcion_servicio", length = 255)
    private String description;

    @Column(name = "precio_servicio", precision = 10, scale = 2)
    private BigDecimal price;
}
