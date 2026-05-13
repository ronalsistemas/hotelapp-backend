package com.rcasani.controller;

import com.rcasani.dto.ReservacionListServicioDTO;
import com.rcasani.dto.ReservacionDTO;
import com.rcasani.model.Reservacion;
import com.rcasani.model.ServicioHotel;
import com.rcasani.model.Usuario;
import com.rcasani.service.IReservacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/reservaciones")
@RequiredArgsConstructor
public class ReservacionController {

    private final IReservacionService reservacionService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ReservacionDTO>> findAll() throws Exception {

        List<ReservacionDTO> list = reservacionService.listar().stream().map(this::convertToDto).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservacionDTO> findById(@PathVariable Integer id) throws Exception {
        Reservacion obj = reservacionService.buscar(id);

        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ReservacionListServicioDTO dto) throws Exception {
        Reservacion obj = convertToEntity(dto.getReservacion());
        List<ServicioHotel> list = dto.getListServicio().stream().map(ex -> modelMapper.map(ex, ServicioHotel.class)).toList();

        Reservacion objResponse = reservacionService.saveTransactional(obj, list);

        //Reservacion obj = reservacionService.guardar(convertToEntity(dto));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdReservation()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservacionDTO> update(@PathVariable Integer id, @Valid @RequestBody ReservacionDTO dto) throws Exception {
        Reservacion obj = reservacionService.actualizar(id, convertToEntity(dto));

        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        reservacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    private Reservacion convertToEntity(ReservacionDTO dto) {
        Reservacion reservacion = modelMapper.map(dto, Reservacion.class);

        // USUARIO
        if (dto.getIdUser() != null) {

            Usuario usuario = new Usuario();
            usuario.setIdUser(dto.getIdUser());

            reservacion.setUsuario(usuario);
        }

        return reservacion;
        //return modelMapper.map(dto, Reservacion.class);
    }

    private ReservacionDTO convertToDto(Reservacion obj) {
        ReservacionDTO dto = modelMapper.map(obj, ReservacionDTO.class);

        // MAPEAR USUARIO
        if (obj.getUsuario() != null) {
            dto.setIdUser(obj.getUsuario().getIdUser());
        }

        return dto;
        //return modelMapper.map(ojb, ReservacionDTO.class);
    }
}
