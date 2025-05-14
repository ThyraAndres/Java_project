package com.Proyecto.Project.models;

import java.time.LocalDate;

public class Equipo {
    private int id;
    private int stock;
    private String nombre;
    private String marca;
    private String modelo;
    private String descripcion;
    private String imagenPath;
    private String documentoPath;
    private LocalDate fechaAdquisicion;
    private LocalDate ultimoMantenimiento;
    private boolean activo;
    private TipoEquipo tipo;

    public enum TipoEquipo {
        AMPLIFICADOR, ALTAVOZ, MICROFONO, MEZCLADORA, PROCESADOR, ACCESORIO
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenPath() {
        return this.imagenPath;
    }

    public void setImagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }

    public String getDocumentoPath() {
        return this.documentoPath;
    }

    public void setDocumentoPath(String documentoPath) {
        this.documentoPath = documentoPath;
    }

    public LocalDate getFechaAdquisicion() {
        return this.fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public LocalDate getUltimoMantenimiento() {
        return this.ultimoMantenimiento;
    }

    public void setUltimoMantenimiento(LocalDate ultimoMantenimiento) {
        this.ultimoMantenimiento = ultimoMantenimiento;
    }

    public boolean isActivo() {
        return this.activo;
    }

    public boolean getActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public TipoEquipo getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoEquipo tipo) {
        this.tipo = tipo;
    }

}
