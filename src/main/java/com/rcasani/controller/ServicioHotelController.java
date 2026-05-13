package com.rcasani.controller;

import com.rcasani.dto.ServicioHotelDTO;
import com.rcasani.model.ServicioHotel;
import com.rcasani.service.IServicioHotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/servicioHotel")
@RequiredArgsConstructor
public class ServicioHotelController {

    private final IServicioHotelService servicioHotelService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ServicioHotelDTO>> findAll() throws Exception {

        List<ServicioHotelDTO> list = servicioHotelService.listar().stream().map(this::convertToDto).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioHotelDTO> findById(@PathVariable Integer id) throws Exception {
        ServicioHotel obj = servicioHotelService.buscar(id);

        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ServicioHotelDTO dto) throws Exception {
        ServicioHotel obj = servicioHotelService.guardar(convertToEntity(dto));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdService()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicioHotelDTO> update(@PathVariable Integer id, @Valid @RequestBody ServicioHotelDTO dto) throws Exception {
        ServicioHotel obj = servicioHotelService.actualizar(id, convertToEntity(dto));

        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        servicioHotelService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    private ServicioHotel convertToEntity(ServicioHotelDTO dto) {
        return modelMapper.map(dto, ServicioHotel.class);
    }

    private ServicioHotelDTO convertToDto(ServicioHotel ojb) {
        return modelMapper.map(ojb, ServicioHotelDTO.class);
    }
}
