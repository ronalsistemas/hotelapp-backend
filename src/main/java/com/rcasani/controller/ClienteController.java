package com.rcasani.controller;

import com.rcasani.dto.ClienteDTO;
import com.rcasani.model.Cliente;
import com.rcasani.service.IClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final IClienteService clienteService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() throws Exception {

        List<ClienteDTO> list = clienteService.listar().stream().map(this::convertToDto).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) throws Exception {
        Cliente obj = clienteService.buscar(id);

        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ClienteDTO dto) throws Exception {
        Cliente obj = clienteService.guardar(convertToEntity(dto));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCustomer()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO dto) throws Exception {
        Cliente obj = clienteService.actualizar(id, convertToEntity(dto));

        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        clienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    private Cliente convertToEntity(ClienteDTO dto) {
        return modelMapper.map(dto, Cliente.class);
    }

    private ClienteDTO convertToDto(Cliente ojb) {
        return modelMapper.map(ojb, ClienteDTO.class);
    }
}
