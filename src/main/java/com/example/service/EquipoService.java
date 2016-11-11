package com.example.service;


import com.example.domain.Equipo;
import com.example.domain.Jugador;
import com.example.repository.EquipoRepository;
import com.example.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private JugadorRepository jugadorRepository;


    public void testEquipo(){
        Equipo equipo1 = new Equipo();
        equipo1.setNombre("C.B Bronx");
        equipo1.setFechaDeCreacion(LocalDate.of(1987, 12, 12));
        equipo1.setLocalidad("U.S.A");
        equipoRepository.save(equipo1);


        Equipo equipo2 = new Equipo();
        equipo2.setNombre("C.B Soviets");
        equipo2.setFechaDeCreacion(LocalDate.of(1978, 04, 12));
        equipo2.setLocalidad("URSS");
        equipoRepository.save(equipo2);


        Equipo equipo3 = new Equipo();
        equipo3.setNombre("C.B Kamikaze");
        equipo3.setFechaDeCreacion(LocalDate.of(1987, 07, 04));
        equipo3.setLocalidad("Japan");
        equipoRepository.save(equipo3);


        System.out.println("Consulta los equipos existentes en una localidad determinada.");
        System.out.println(equipoRepository.findByLocalidad("URSS"));


    }
}