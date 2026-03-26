package com.rcasani.service.impl;

import com.rcasani.model.Hotel;
import com.rcasani.repo.IGenericRepo;
import com.rcasani.repo.IHotelRepo;
import com.rcasani.service.IHotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl extends CRUDImpl<Hotel, Integer> implements IHotelService {

    private final IHotelRepo repo;

    @Override
    protected IGenericRepo<Hotel, Integer> getRepo() {
        return repo;
    }

    @Override
    public Hotel actualizar(Integer id, Hotel hotel) throws Exception {

        Hotel existente = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("ID NOT FOUND: " + id));

        existente.setName(hotel.getName());
        existente.setAddress(hotel.getAddress());
        existente.setPhone(hotel.getPhone());
        existente.setEmail(hotel.getEmail());
        existente.setCategory(hotel.getCategory());

        return repo.save(existente);
    }
}