package com.Proyecto.Project.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    // Muestra el formulario de login
    @GetMapping("/login")
    public String showLoginForm() {
        return "auth/login"; // Asegúrate que login.html esté en templates/auth/
    }

    // Procesa el login (manejado por Spring Security, este método es opcional)
    @PostMapping("/login")
    public String processLogin() {
        return "redirect:/home"; // Redirige después del login exitoso
    }

    // Muestra el home después del login
    @GetMapping("/home")
    public String showHome(Authentication authentication) {
        if (authentication != null) {
            System.out.println("Usuario autenticado: " + authentication.getName());
        }
        return "auth/home"; // Asegúrate que home.html esté en templates/auth/
    }
}