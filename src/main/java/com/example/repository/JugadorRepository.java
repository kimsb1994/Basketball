package com.example.repository;


import com.example.domain.Jugador;
import com.example.domain.Equipo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    //Buscar jugadores por nombre, de manera que no sea necesario introducir el nombre completo.
    List<Jugador> findByNombre(String nombre);


    //Buscar jugadores que hayan conseguido un número mayor o igual a un número de canastas especificado como parámetro.
    List<Jugador> findByNumeroDeCanastasGreaterThanEqual(int numeroDeCanastas);


    //Buscar jugadores que hayan efectuado un número de asistencias dentro de un rango especificado como parámetro.
    List<Jugador> findByNumeroDeAsistenciasBetween(int min, int max);


    //jugadores que pertenezcan a una posición específica, por ejemplo: base
    List<Jugador> findByPosicion(String posicion);
    //Buscar jugadores que hayan nacido en una fecha anterior a una fecha especificada como parámetro.
    List<Jugador> findByFechaNacimientoBefore(LocalDate fechaNacimiento);

    //Agrupar los jugadores por la posición del campo y devolver para cada grupo la siguiente información: la media de canastas, asistencias y rebotes.
    @Query("SELECT jugador.posicion, AVG(jugador.numeroDeCanastas), MIN(jugador.numeroDeAsistencias), MAX(jugador.numeroDeRebotes)" +
            "FROM Jugador jugador " +
            "GROUP BY jugador.posicion")
    List<Object[]> AgruparPosicionDarMedia();

    //Lo mismo que el punto anterior pero devolviendo la media, el máximo y el mínimo de canastas, asistencias y rebotes.
    @Query("SELECT jugador.posicion, AVG(jugador.numeroDeCanastas), MIN(jugador.numeroDeCanastas), MAX(jugador.numeroDeCanastas), AVG(jugador.numeroDeAsistencias), MIN(jugador.numeroDeAsistencias), MAX(jugador.numeroDeAsistencias), AVG(jugador.numeroDeRebotes), MIN(jugador.numeroDeRebotes), MAX(jugador.numeroDeRebotes)" +
            "FROM Jugador jugador " +
            "GROUP BY jugador.posicion")
    List<Object[]> AgruparPosicionDarMediaTotal();

    //Devuelve todos los jugadores de un equipo, a partir de l nombre completo del equipo.
    List<Jugador> findByOwnerNombre(String nombre);
    //Devuelve todos los jugadores de un equipo, a partir de l nombre completo del equipo.
    List<Jugador> findByOwnerNombreAndPosicion(String nombre,String posicion);

    @Query("SELECT jugador " + " FROM Jugador jugador " + "WHERE jugador.owner.nombre = :EquipoNombre"+" ORDER BY jugador.numeroDeCanastas desc")
    List<Jugador>nombreJugador(@Param("EquipoNombre") String nombre, Pageable pageable);
}
