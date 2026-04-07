package com.rcasani.service.impl;

import com.rcasani.model.Cliente;
import com.rcasani.repo.IClienteRepo;
import com.rcasani.repo.IGenericRepo;
import com.rcasani.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl extends CRUDImpl<Cliente, Integer> implements IClienteService {

    private final IClienteRepo repo;

    @Override
    protected IGenericRepo<Cliente, Integer> getRepo() {
        return repo;
    }
}
