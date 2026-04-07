package com.rcasani.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer idPayment;

    // 🔗 Relación con Reservation
    @ManyToOne
    @JoinColumn(name = "id_reservacion", nullable = false, foreignKey = @ForeignKey(name = "fk_pago_reservacion"))
    private Reservacion reservation;

    @Column(name = "cantidad", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "fecha_pago")
    private LocalDateTime paymentDate;

    @Column(name = "metodo_pago", length = 50)
    private String paymentMethod; // efectivo, tarjeta

    @Column(name = "estado_pago", length = 20)
    private String status; // pagado, pendiente, rechazado
}
