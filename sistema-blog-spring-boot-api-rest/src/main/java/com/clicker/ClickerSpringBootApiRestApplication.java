package com.clicker;

import com.clicker.entidades.Rol;
import com.clicker.entidades.Usuario;
import com.clicker.repositorio.RolRepositorio;
import com.clicker.repositorio.UsuarioRepositorio;
import lombok.Data;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

@SpringBootApplication
public class ClickerSpringBootApiRestApplication {

	@Autowired
	private RolRepositorio rolRepositorio;

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ClickerSpringBootApiRestApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

	@Bean
	CommandLineRunner run() {
		return args -> {

			System.out.println("---------");

//			Usuario usuario = new Usuario();
//			usuario.setNombre("Admin");
//			usuario.setUsername("Admin");
//			usuario.setEmail("andfres@gmail.com");
//
//			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//			usuario.setPassword(passwordEncoder.encode("123"));
//
//			Rol roles = rolRepositorio.findByNombre("ROLE_USER").get();
//			usuario.setRoles(Collections.singleton(roles));
//			usuarioRepositorio.save(usuario);

		};
	}



}
