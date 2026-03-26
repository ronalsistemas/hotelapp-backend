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
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private Integer idHotel;

    @Column(name = "nombre_hotel", length = 100, nullable = false)
    private String name;

    @Column(name = "direccion_hotel", length = 255)
    private String address;

    @Column(name = "telefono_hotel", length = 20)
    private String phone;

    @Column(name = "correo_hotel", length = 100)
    private String email;

    @Column(name = "categoria_hotel")
    private Integer category;
}
