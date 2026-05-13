package com.rcasani.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoHabitacionDTO {

    private Integer idRoomType;

    private String name;

    private String description;

    private Integer capacity;

    private BigDecimal basePrice;
}
