package com.clicker;

import com.clicker.dto.ComentarioDTO;
import com.clicker.dto.PublicacionDTO;
import com.clicker.servicio.ComentarioServicio;
import com.clicker.servicio.PublicacionServicio;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ClickerSpringBootApiRestApplication {

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
	CommandLineRunner run(PublicacionServicio publicacionServicio, ComentarioServicio comentarioServicio) {
		return args -> {

			System.out.println("eeeeeeeeeeeeee");

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

		};
	}


}
