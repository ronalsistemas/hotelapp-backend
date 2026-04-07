package com.rcasani.service.impl;

import com.rcasani.model.DetalleReserva;
import com.rcasani.repo.IDetalleReservaRepo;
import com.rcasani.repo.IGenericRepo;
import com.rcasani.service.IDetalleReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetalleReservaServiceImpl extends CRUDImpl<DetalleReserva, Integer> implements IDetalleReservaService {

    private final IDetalleReservaRepo repo;

    @Override
    protected IGenericRepo<DetalleReserva, Integer> getRepo() {
        return repo;
    }
}
