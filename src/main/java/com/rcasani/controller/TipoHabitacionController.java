package com.rcasani.controller;

import com.rcasani.dto.TipoHabitacionDTO;
import com.rcasani.model.TipoHabitacion;
import com.rcasani.service.ITipoHabitacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/tipoHabitaciones")
@RequiredArgsConstructor
public class TipoHabitacionController {

    private final ITipoHabitacionService tipoHabitacionService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<TipoHabitacionDTO>> findAll() throws Exception {

        List<TipoHabitacionDTO> list = tipoHabitacionService.listar().stream().map(this::convertToDto).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoHabitacionDTO> findById(@PathVariable Integer id) throws Exception {
        TipoHabitacion obj = tipoHabitacionService.buscar(id);

        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipoHabitacionDTO dto) throws Exception {
        TipoHabitacion obj = tipoHabitacionService.guardar(convertToEntity(dto));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdRoomType()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoHabitacionDTO> update(@PathVariable Integer id, @Valid @RequestBody TipoHabitacionDTO dto) throws Exception {
        TipoHabitacion obj = tipoHabitacionService.actualizar(id, convertToEntity(dto));

        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        tipoHabitacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    private TipoHabitacion convertToEntity(TipoHabitacionDTO dto) {
        return modelMapper.map(dto, TipoHabitacion.class);
    }

    private TipoHabitacionDTO convertToDto(TipoHabitacion ojb) {
        return modelMapper.map(ojb, TipoHabitacionDTO.class);
    }
}
