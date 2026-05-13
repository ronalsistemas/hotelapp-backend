package com.rcasani.controller;

import com.rcasani.dto.HabitacionDTO;
import com.rcasani.model.Habitacion;
import com.rcasani.service.IHabitacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/habitaciones")
@RequiredArgsConstructor
public class HabitacionController {

    private final IHabitacionService habitacionService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<HabitacionDTO>> findAll() throws Exception {

        List<HabitacionDTO> list = habitacionService.listar().stream().map(this::convertToDto).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitacionDTO> findById(@PathVariable Integer id) throws Exception {
        Habitacion obj = habitacionService.buscar(id);

        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody HabitacionDTO dto) throws Exception {
        Habitacion obj = habitacionService.guardar(convertToEntity(dto));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdRoom()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HabitacionDTO> update(@PathVariable Integer id, @Valid @RequestBody HabitacionDTO dto) throws Exception {
        Habitacion obj = habitacionService.actualizar(id, convertToEntity(dto));

        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        habitacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    private Habitacion convertToEntity(HabitacionDTO dto) {
        return modelMapper.map(dto, Habitacion.class);
    }

    private HabitacionDTO convertToDto(Habitacion ojb) {
        return modelMapper.map(ojb, HabitacionDTO.class);
    }
}
