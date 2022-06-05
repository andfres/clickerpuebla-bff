package com.clicker.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
