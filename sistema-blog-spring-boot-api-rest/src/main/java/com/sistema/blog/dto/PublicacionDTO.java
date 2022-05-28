package com.sistema.blog.dto;

import java.util.Set;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sistema.blog.entidades.Comentario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionDTO {

	private Long id;
	
	@NotEmpty
	@Size(min = 2,message = "El titulo de la publicación deberia tener al menos 2 caracteres")
	private String titulo;
	
	@NotEmpty
	@Size(min = 10,message = "La descripción de la publicación deberia tener al menos 10 caracteres")
	private String descripcion;
	
	@NotEmpty
	private String contenido;
	

}
