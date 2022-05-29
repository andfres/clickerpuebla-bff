package com.sistema.blog;

import com.sistema.blog.dto.ComentarioDTO;
import com.sistema.blog.dto.PublicacionDTO;
import com.sistema.blog.entidades.Publicacion;
import com.sistema.blog.entidades.Rol;
import com.sistema.blog.repositorio.RolRepositorio;
import com.sistema.blog.servicio.ComentarioServicio;
import com.sistema.blog.servicio.PublicacionServicio;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@SpringBootApplication
public class SistemaBlogSpringBootApiRestApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaBlogSpringBootApiRestApplication.class, args);
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
	CommandLineRunner run(PublicacionServicio publicacionServicio, ComentarioServicio comentarioServicio) {
		return args -> {

			PublicacionDTO publicacion = new PublicacionDTO();
			publicacion.setTitulo("titulooooooooo");
			publicacion.setDescripcion("esto es una publicacion de prueba");
			publicacion.setContenido("esto es el contenido de la pubblicacion");
			publicacionServicio.crearPublicacion(publicacion);


			ComentarioDTO aaaaa = new ComentarioDTO();
			aaaaa.setNombre("EEEE");
			aaaaa.setEmail("ee@gmail.com");
			aaaaa.setCuerpo("EEEEsdfsdfdsfsdfsdfsdfsdfsdfdsfsdfsdfdsf");

			comentarioServicio.crearComentario(1L, aaaaa);

			Rol rol = new Rol(1 , "ROLE_ADMIN");


			System.out.println("rol:" + rol.getNombre());


		};
	}
}
