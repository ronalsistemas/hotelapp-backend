package com.rcasani.controller;

import com.rcasani.dto.HotelDTO;
import com.rcasani.model.Hotel;
import com.rcasani.service.IHotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/hoteles")
@RequiredArgsConstructor
public class HotelController {

    private final IHotelService hotelService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<HotelDTO>> findAll() throws Exception {

        List<HotelDTO> list = hotelService.listar().stream().map(this::convertToDto).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> findById(@PathVariable Integer id) throws Exception {
        Hotel obj = hotelService.buscar(id);

        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody HotelDTO dto) throws Exception {
        Hotel obj = hotelService.guardar(convertToEntity(dto));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdHotel()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelDTO> update(@PathVariable Integer id, @Valid @RequestBody HotelDTO dto) throws Exception {
        Hotel obj = hotelService.actualizar(id, convertToEntity(dto));

        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        hotelService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    private Hotel convertToEntity(HotelDTO dto) {
        return modelMapper.map(dto, Hotel.class);
    }

    private HotelDTO convertToDto(Hotel ojb) {
        return modelMapper.map(ojb, HotelDTO.class);
    }
}
