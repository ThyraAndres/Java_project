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

import com.Proyecto.Project.models.Usuario;
import com.Proyecto.Project.services.usuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final usuarioService usuarioService;

    // Usa inyección por constructor (mejor práctica)
    public UsuarioController(usuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Endpoint corregido para obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable int id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    // Endpoint para listar usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.buscarUsuarios());
    }

    // Endpoint para crear usuario - CORREGIDO
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    // Endpoint para actualizar - CORREGIDO
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(
            @PathVariable Integer id,
            @Valid @RequestBody Usuario usuario) {

        // 1. Buscar el usuario existente
        Usuario usuarioExistente = usuarioService.buscarPorId(id);
        // 2. Actualizar solo campos permitidos
        usuarioExistente.setUsername(usuario.getUsername());
        usuarioExistente.setEmail(usuario.getEmail());
        // 4. Guardar cambios
        Usuario usuarioGuardado = usuarioService.actualizarUsuario(usuarioExistente);
        return ResponseEntity.ok(usuarioGuardado);
    }

    // Endpoint para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}