package com.rcasani.service;

import com.rcasani.model.Reservacion;
import com.rcasani.model.ServicioHotel;

import java.util.List;

public interface IReservacionService extends ICRUD<Reservacion, Integer> {

    Reservacion saveTransactional(Reservacion reservacion, List<ServicioHotel> servicios);
}
