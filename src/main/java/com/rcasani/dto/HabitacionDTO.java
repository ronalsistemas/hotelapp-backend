package com.rcasani.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitacionDTO {

    private Integer idRoom;
    private Integer hotelId;
    private Integer roomTypeId;
    private String roomNumber;
    private Integer floor;
    private String status;
}