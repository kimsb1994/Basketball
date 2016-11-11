package com.example.domain;


import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Jugador {
//
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private Integer numeroDeCanastas;
    private Integer numeroDeAsistencias;
    private Integer numeroDeRebotes;
    private String posicion;
    @ManyToOne  //un coche sólo puede pertenecer a una persona
    private Equipo owner;

    public Jugador(String nombre, LocalDate fechaNacimiento, Integer numeroDeCanastas, Integer numeroDeAsistencias, Integer numeroDeRebotes, String posicion) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroDeCanastas = numeroDeCanastas;
        this.numeroDeAsistencias = numeroDeAsistencias;
        this.numeroDeRebotes = numeroDeRebotes;
        this.posicion = posicion;
    }

    public Jugador() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getNumeroDeCanastas() {
        return numeroDeCanastas;
    }

    public void setNumeroDeCanastas(Integer numeroDeCanastas) {
        this.numeroDeCanastas = numeroDeCanastas;
    }

    public Integer getNumeroDeAsistencias() {
        return numeroDeAsistencias;
    }

    public void setNumeroDeAsistencias(Integer numeroDeAsistencias) {
        this.numeroDeAsistencias = numeroDeAsistencias;
    }

    public Integer getNumeroDeRebotes() {
        return numeroDeRebotes;
    }

    public void setNumeroDeRebotes(Integer numeroDeRebotes) {
        this.numeroDeRebotes = numeroDeRebotes;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Equipo getOwner() {
        return owner;
    }

    public void setOwner(Equipo owner) {
        this.owner = owner;
    }



    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre +
                ", fechaNacimiento=" + fechaNacimiento +
                ", numeroDeCanastas=" + numeroDeCanastas +
                ", numeroDeAsistencias=" + numeroDeAsistencias +
                ", numeroDeRebotes=" + numeroDeRebotes +
                ", posicion='" + posicion +
                ", owner=" + owner +
                '}' +System.lineSeparator();
    }
}
