package com.example.service;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.domain.Equipo;
import com.example.domain.Jugador;
import com.example.repository.EquipoRepository;
import com.example.repository.JugadorRepository;
import com.sun.tools.classfile.SourceDebugExtension_attribute;
import org.hibernate.annotations.SourceType;
import org.jcp.xml.dsig.internal.SignerOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;


@Service
public class JugadorService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private JugadorRepository jugadorRepository;

    public void testJugador(){
        Jugador jugador1 = new Jugador ("Ice cube", LocalDate.of(1975, 8, 14),18,88,23,"Base");
        Jugador jugador2 = new Jugador ("Dr.Dree", LocalDate.of(1978, 7, 22),42,52,40,"Escolta");
        Jugador jugador3 = new Jugador ("Snoop Dog", LocalDate.of(1977, 9, 15),65,35,12,"Alero");
        Jugador jugador4 = new Jugador ("TuPac", LocalDate.of(1977, 10, 10),45,44,89,"Ala-Pivot");
        Jugador jugador5 = new Jugador ("Eazy-e", LocalDate.of(1997, 12, 9),48,18,112,"Pivot");
        Equipo Bronx = equipoRepository.findOne(1L);
        jugador1.setOwner(Bronx);
        jugador2.setOwner(Bronx);
        jugador3.setOwner(Bronx);
        jugador4.setOwner(Bronx);
        jugador5.setOwner(Bronx);
        jugadorRepository.save(jugador1);
        jugadorRepository.save(jugador2);
        jugadorRepository.save(jugador3);
        jugadorRepository.save(jugador4);
        jugadorRepository.save(jugador5);



        Jugador jugador6 = new Jugador ("Lenin", LocalDate.of(1889, 07, 14),25,22,45,"Base");
        Jugador jugador7 = new Jugador ("Marxx", LocalDate.of(1833, 06, 16),85,32,12,"Escolta");
        Jugador jugador8 = new Jugador ("Engels", LocalDate.of(1823, 01, 28),87,51,1,"Alero");
        Jugador jugador9 = new Jugador ("Fidel", LocalDate.of(1919, 04, 17),78,5,88,"Ala-Pivot");
        Jugador jugador10 = new Jugador ("Chavez", LocalDate.of(1943, 12, 04),45,8,99,"Pivot");
        Equipo URSS = equipoRepository.findOne(2L);
        jugador6.setOwner(URSS);
        jugador7.setOwner(URSS);
        jugador8.setOwner(URSS);
        jugador9.setOwner(URSS);
        jugador10.setOwner(URSS);
        jugadorRepository.save(jugador6);
        jugadorRepository.save(jugador7);
        jugadorRepository.save(jugador8);
        jugadorRepository.save(jugador9);
        jugadorRepository.save(jugador10);



        Jugador jugador11 = new Jugador ("Saitama", LocalDate.of(1943, 07, 24),33,55,85,"Base");
        Jugador jugador12 = new Jugador ("Joseph Joestar", LocalDate.of(1939, 9, 05),45,45,96,"Escolta");
        Jugador jugador13 = new Jugador ("Rock Lee", LocalDate.of(1423, 01, 06),88,25,2,"Alero");
        Jugador jugador14 = new Jugador ("L", LocalDate.of(2004, 07, 04),15,6,52,"Ala-Pivot");
        Jugador jugador15 = new Jugador ("Satan", LocalDate.of(810, 05, 01),65,20,88,"Pivot");
        Equipo Kamikaze = equipoRepository.findOne(3L);
        jugador11.setOwner(Kamikaze);
        jugador12.setOwner(Kamikaze);
        jugador13.setOwner(Kamikaze);
        jugador14.setOwner(Kamikaze);
        jugador15.setOwner(Kamikaze);
        jugadorRepository.save(jugador11);
        jugadorRepository.save(jugador12);
        jugadorRepository.save(jugador13);
        jugadorRepository.save(jugador14);
        jugadorRepository.save(jugador15);
        System.out.println("Buscar jugadores por nombre, de manera que no sea necesario introducir el nombre completo.");
        System.out.println(jugadorRepository.findByNombre("Snoop Dog"));
        System.out.println("Buscar jugadores que hayan conseguido un número mayor o igual a un número de canastas especificado como parámetro.");
        System.out.println(jugadorRepository.findByNumeroDeCanastasGreaterThanEqual(80));
        System.out.println("Buscar jugadores que hayan efectuado un número de asistencias dentro de un rango especificado como parámetro.");
        System.out.println(jugadorRepository.findByNumeroDeAsistenciasBetween(25,50));
        System.out.println("Buscar jugadores que pertenezcan a una posición específica, por ejemplo: escolta.");
        System.out.println(jugadorRepository.findByPosicion("escolta"));
        System.out.println("Buscar jugadores que hayan nacido en una fecha anterior a una fecha especificada como parámetro.");
        System.out.println(jugadorRepository.findByFechaNacimientoBefore(LocalDate.of(1994, 05, 15)));
        System.out.println("Agrupar los jugadores por la posición del campo y devolver para cada grupo la siguiente información: la media de canastas, asistencias y rebotes.");
        List<Object[]> jugadorList = jugadorRepository.AgruparPosicionDarMedia();
        for (Object[] jugador : jugadorList)
        {
            System.out.println("Posicion: "+jugador[0]);
            System.out.println("AVG = "+jugador[1]);
            System.out.println("MIN = "+jugador[2]);
            System.out.println("MAX = "+jugador[3]+System.lineSeparator());
        }
        System.out.println("Lo mismo que el punto anterior pero devolviendo la media, el máximo y el mínimo de canastas, asistencias y rebotes.");
        List<Object[]> jugadorList1 = jugadorRepository.AgruparPosicionDarMediaTotal();
            for (Object[] jugador : jugadorList1)
        {
            System.out.println("Posicion: "+jugador[0]);
            System.out.println("Puntos:");
            System.out.println("AVG = "+jugador[1]);
            System.out.println("MIN = "+jugador[2]);
            System.out.println("MAX = "+jugador[3]);
            System.out.println("Asistencias:");
            System.out.println("AVG = "+jugador[4]);
            System.out.println("MIN = "+jugador[5]);
            System.out.println("MAX = "+jugador[6]);
            System.out.println("Rebotes:");
            System.out.println("AVG = "+jugador[7]);
            System.out.println("MIN = "+jugador[8]);
            System.out.println("MAX = "+jugador[9]+System.lineSeparator());
        }
        System.out.println("Devuelve todos los jugadores de un equipo, a partir de l nombre completo del equipo.");
        System.out.println(jugadorRepository.findByOwnerNombre("C.B Bronx"));
        System.out.println("Devuelve todos los jugadores de un equipo, que además jueguen en la misma posición (parámetro adicional de la consulta), por ejemplo, alero.");
        System.out.println(jugadorRepository.findByOwnerNombreAndPosicion("C.B Bronx","Alero"));
        System.out.println("Devuelve todos los jugadores de un equipo, que además jueguen en la misma posición (parámetro adicional de la consulta), por ejemplo, alero.");
        System.out.println(jugadorRepository.nombreJugador("C.B Bronx",new PageRequest(0,1)));



    }
}
