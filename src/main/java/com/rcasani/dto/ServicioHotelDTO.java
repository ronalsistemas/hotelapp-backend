package com.rcasani.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicioHotelDTO {

    private Integer idService;

    private String name;

    private String description;

    private BigDecimal price;
}
