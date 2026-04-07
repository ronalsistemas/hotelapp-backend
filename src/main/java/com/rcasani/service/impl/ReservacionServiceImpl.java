package com.rcasani.service.impl;

import com.rcasani.model.Reservacion;
import com.rcasani.repo.IGenericRepo;
import com.rcasani.repo.IReservacionRepo;
import com.rcasani.service.IReservacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservacionServiceImpl extends CRUDImpl<Reservacion, Integer> implements IReservacionService {

    private final IReservacionRepo repo;

    @Override
    protected IGenericRepo<Reservacion, Integer> getRepo() {
        return repo;
    }
}
