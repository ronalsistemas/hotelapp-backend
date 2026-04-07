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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCustomer;

    @Column(name = "nombre_cliente", length = 100, nullable = false)
    private String firstName;

    @Column(name = "apellido_cliente", length = 100, nullable = false)
    private String lastName;

    @Column(name = "dni_cliente", length = 20, nullable = false, unique = true)
    private String dni;

    @Column(name = "telefono_cliente", length = 20)
    private String phone;

    @Column(name = "correo_cliente", length = 100)
    private String email;

    @Column(name = "direccion_cliente", length = 255)
    private String address;
}
