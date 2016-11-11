package com.example.repository;


import com.example.domain.Equipo;
import com.example.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
/*

Devuelve todos los jugadores de un equipo, que además jueguen en la misma posición (parámetro adicional de la consulta), por ejemplo, alero.
Devuelve el jugador que más canastas ha realizado de un equipo determinado como parámetro.
 */

//Consulta los equipos existentes en una localidad determinada.
List<Equipo> findByLocalidad(String localidad);


}
