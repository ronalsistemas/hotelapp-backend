package com.rcasani.service.impl;

import com.rcasani.model.Empleado;
import com.rcasani.repo.IEmpleadoRepo;
import com.rcasani.repo.IGenericRepo;
import com.rcasani.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl extends CRUDImpl<Empleado, Integer> implements IEmpleadoService {

    private final IEmpleadoRepo repo;

    @Override
    protected IGenericRepo<Empleado, Integer> getRepo() {
        return repo;
    }
}
