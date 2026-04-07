package com.rcasani.service.impl;

import com.rcasani.model.Habitacion;
import com.rcasani.repo.IHabitacionRepo;
import com.rcasani.repo.IGenericRepo;
import com.rcasani.service.IHabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HabitacionServiceImpl extends CRUDImpl<Habitacion, Integer> implements IHabitacionService {

    private final IHabitacionRepo repo;

    @Override
    protected IGenericRepo<Habitacion, Integer> getRepo() {
        return repo;
    }
}
