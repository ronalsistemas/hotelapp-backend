package com.rcasani.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {

    private Integer idHotel;

    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @Size(min = 5, max = 255)
    private String address;

    @NotNull
    @Pattern(regexp = "[0-9]+")
    @Size(min = 7, max = 20)
    private String phone;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer category;
}
