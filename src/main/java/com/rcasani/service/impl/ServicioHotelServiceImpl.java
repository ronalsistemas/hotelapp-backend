package com.rcasani.service.impl;

import com.rcasani.model.ServicioHotel;
import com.rcasani.repo.IGenericRepo;
import com.rcasani.repo.IServicioHotelRepo;
import com.rcasani.service.IServicioHotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicioHotelServiceImpl extends CRUDImpl<ServicioHotel, Integer> implements IServicioHotelService {

    private final IServicioHotelRepo repo;

    @Override
    protected IGenericRepo<ServicioHotel, Integer> getRepo() {
        return repo;
    }
}
