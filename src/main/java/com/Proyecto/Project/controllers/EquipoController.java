package com.Proyecto.Project.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyecto.Project.models.Equipo;
import com.Proyecto.Project.services.equipoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    private final equipoService equipoService;

    // Usa inyección por constructor (mejor práctica)
    public EquipoController(equipoService equipoService) {
        this.equipoService = equipoService;
    }

    // Endpoint corregido para obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtenerEquipoPorId(@PathVariable int id) {
        Equipo equipo = equipoService.buscarPorId(id);
        return ResponseEntity.ok(equipo);
    }

    // Endpoint para listar equipos
    @GetMapping
    public ResponseEntity<List<Equipo>> listarEquipos() {
        return ResponseEntity.ok(equipoService.buscarEquipos());
    }

    // Endpoint para crear equipo - CORREGIDO
    @PostMapping
    public ResponseEntity<Equipo> crearEquipo(@RequestBody Equipo equipo) {
        Equipo nuevoEquipo = equipoService.crearEquipo(equipo);
        return ResponseEntity.ok(nuevoEquipo);
    }

    // Endpoint para actualizar - CORREGIDO
    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizarEquipo(
            @PathVariable Integer id,
            @Valid @RequestBody Equipo equipo) {

        // 1. Buscar el equipo existente
        Equipo equipoExistente = equipoService.buscarPorId(id);
        // 2. Actualizar solo campos permitidos
        equipoExistente.setMarca(equipoExistente.getMarca());
        equipoExistente.setNombre(equipoExistente.getNombre());
        equipoExistente.setPrecio(equipoExistente.getPrecio());
        equipoExistente.setDescripcion(equipoExistente.getDescripcion());
        // 4. Guardar cambios
        Equipo equipoGuardado = equipoService.actualizarEquipo(equipoExistente);
        return ResponseEntity.ok(equipoGuardado);
    }

    // Endpoint para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable int id) {
        equipoService.eliminarEquipo(id);
        return ResponseEntity.noContent().build();
    }
}