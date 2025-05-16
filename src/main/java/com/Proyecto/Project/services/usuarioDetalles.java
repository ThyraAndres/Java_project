package com.Proyecto.Project.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Proyecto.Project.models.Usuario;
import com.Proyecto.Project.repository.UsuarioRepository;

@Service
public class usuarioDetalles implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public usuarioDetalles(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
        return usuario; // Retorna la instancia de Usuario que implementa UserDetails
    }
}
