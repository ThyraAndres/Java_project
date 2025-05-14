package com.Proyecto.Project.models;

import java.time.LocalDateTime;
import java.util.List;

public class Evento {
    private int id;
    private int tecnicoResponsable;
    private String nombre;
    private String ubicacion;
    private String descripcion;
    private String configuracionPath;
    private LocalDateTime fecha;
    private List<Integer> equiposUtilizados;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTecnicoResponsable() {
        return this.tecnicoResponsable;
    }

    public void setTecnicoResponsable(int tecnicoResponsable) {
        this.tecnicoResponsable = tecnicoResponsable;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getConfiguracionPath() {
        return this.configuracionPath;
    }

    public void setConfiguracionPath(String configuracionPath) {
        this.configuracionPath = configuracionPath;
    }

    public LocalDateTime getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<Integer> getEquiposUtilizados() {
        return this.equiposUtilizados;
    }

    public void setEquiposUtilizados(List<Integer> equiposUtilizados) {
        this.equiposUtilizados = equiposUtilizados;
    }
    
}
