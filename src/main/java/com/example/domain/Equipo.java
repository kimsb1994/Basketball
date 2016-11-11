package com.example.domain;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Equipo {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private LocalDate fechaDeCreacion;
    private String localidad;

    public Equipo() {
    }

    public Equipo(String nombre, LocalDate fechaDeCreacion, String localidad) {
        this.nombre = nombre;
        this.fechaDeCreacion = fechaDeCreacion;
        this.localidad = localidad;
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

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipo equipo = (Equipo) o;

        if (id != equipo.id) return false;
        if (!nombre.equals(equipo.nombre)) return false;
        if (!fechaDeCreacion.equals(equipo.fechaDeCreacion)) return false;
        return localidad.equals(equipo.localidad);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + nombre.hashCode();
        result = 31 * result + fechaDeCreacion.hashCode();
        result = 31 * result + localidad.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", localidad='" + localidad +
                '}'+System.lineSeparator();
    }
}
