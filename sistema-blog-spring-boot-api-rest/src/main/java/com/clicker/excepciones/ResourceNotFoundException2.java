package com.clicker.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException2 extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String nombreDelRecurso;
	private String nombreDelCampo;

	public ResourceNotFoundException2(String nombreDelRecurso, String nombreDelCampo) {
		super(String.format("%s no encontrada con : %s : '%s'", nombreDelRecurso, nombreDelCampo));
		this.nombreDelRecurso = nombreDelRecurso;
		this.nombreDelCampo = nombreDelCampo;
	}

	public String getNombreDelRecurso() {
		return nombreDelRecurso;
	}

	public void setNombreDelRecurso(String nombreDelRecurso) {
		this.nombreDelRecurso = nombreDelRecurso;
	}

	public String getNombreDelCampo() {
		return nombreDelCampo;
	}

	public void setNombreDelCampo(String nombreDelCampo) {
		this.nombreDelCampo = nombreDelCampo;
	}


}
