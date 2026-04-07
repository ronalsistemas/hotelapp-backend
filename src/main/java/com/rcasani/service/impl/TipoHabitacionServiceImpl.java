package com.rcasani.service.impl;

import com.rcasani.model.TipoHabitacion;
import com.rcasani.repo.IGenericRepo;
import com.rcasani.repo.ITipoHabitacionRepo;
import com.rcasani.service.ITipoHabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoHabitacionServiceImpl extends CRUDImpl<TipoHabitacion, Integer> implements ITipoHabitacionService {

    private final ITipoHabitacionRepo repo;

    @Override
    protected IGenericRepo<TipoHabitacion, Integer> getRepo() {
        return repo;
    }
}
