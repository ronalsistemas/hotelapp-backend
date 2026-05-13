package com.rcasani.repo;

import com.rcasani.model.ReservacionServicio;
import com.rcasani.model.ReservacionServicioPK;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IReservacionServicioRepo extends IGenericRepo<ReservacionServicio, ReservacionServicioPK>{

    //@Transactional
    @Modifying
    @Query(value = "INSERT INTO reservacion_servicio (id_reservacion, id_servicio) VALUES (:idReservation, :idService)", nativeQuery = true)
    Integer guardarServicio(@Param("idReservation") Integer idReservation, @Param("idService") Integer idService);
}
