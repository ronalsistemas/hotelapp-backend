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
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer idEmployee;

    @ManyToOne
    @JoinColumn(name = "id_hotel", nullable = false, foreignKey = @ForeignKey(name = "fk_empleado_hotel"))
    private Hotel hotel;

    @Column(name = "nombre_empleado", length = 100, nullable = false)
    private String firstName;

    @Column(name = "apellido_empleado", length = 100, nullable = false)
    private String lastName;

    @Column(name = "rol_empleado", length = 50)
    private String role; // recepcionista, admin

    @Column(name = "telefono_mepleado", length = 20)
    private String phone;
}
