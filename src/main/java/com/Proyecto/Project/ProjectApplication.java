package com.Proyecto.Project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Proyecto.Project.models.Usuario;
import com.Proyecto.Project.repository.UsuarioRepository;

@SpringBootApplication(scanBasePackages = "com.Proyecto")
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UsuarioRepository repo, PasswordEncoder encoder) {
		return args -> {
			if (repo.findByUsername("admin").isEmpty()) {
				Usuario admin = new Usuario();
				admin.setUsername("admin");
				admin.setPassword(encoder.encode("123"));
				admin.setEmail("testing@gmail.com");
				admin.setRol("USER");
				repo.save(admin);
			}
		};
	}

}
