package com.rcasani.service.impl;

import com.rcasani.model.Reservacion;
import com.rcasani.model.ServicioHotel;
import com.rcasani.repo.IGenericRepo;
import com.rcasani.repo.IReservacionRepo;
import com.rcasani.repo.IReservacionServicioRepo;
import com.rcasani.service.IReservacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservacionServiceImpl extends CRUDImpl<Reservacion, Integer> implements IReservacionService {

    private final IReservacionRepo repo;
    private final IReservacionServicioRepo reservacionServicioRepo;

    @Override
    protected IGenericRepo<Reservacion, Integer> getRepo() {
        return repo;
    }

    @Transactional
    @Override
    public Reservacion saveTransactional(Reservacion reservacion, List<ServicioHotel> servicios) {
        reservacion.getDetails().forEach(det -> det.setReservation(reservacion)); //ASIGNA EL MAESTRO A LOS DETALLES

        repo.save(reservacion); //GUARDA EL MAESTRO DETALLE
        servicios.forEach(ex -> reservacionServicioRepo.guardarServicio(reservacion.getIdReservation(), ex.getIdService()));

        return reservacion;
    }
}
