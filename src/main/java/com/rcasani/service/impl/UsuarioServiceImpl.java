package com.rcasani.service.impl;

import com.rcasani.model.Usuario;
import com.rcasani.repo.IGenericRepo;
import com.rcasani.repo.IUsuarioRepo;
import com.rcasani.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends CRUDImpl<Usuario, Integer> implements IUsuarioService {

    private final IUsuarioRepo repo;

    @Override
    protected IGenericRepo<Usuario, Integer> getRepo() {
        return repo;
    }
}
