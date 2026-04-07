package com.rcasani.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUser;

    @Column(name = "nombre_usuario", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "contraseña_usuario", length = 100, nullable = false)
    private String password;

    @Column(name = "activado_usuario", nullable = false)
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_Usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id_Rol")
    )
    private List<Rol> roles;
}
