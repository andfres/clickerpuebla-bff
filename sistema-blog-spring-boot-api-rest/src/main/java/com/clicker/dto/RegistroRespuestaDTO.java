package com.clicker.dto;


import com.clicker.entidades.Rol;
import com.clicker.entidades.Usuario;
import lombok.Data;
import org.apache.catalina.User;

import javax.validation.constraints.Email;
import java.util.Set;

@Data
public class RegistroRespuestaDTO {


	private String nombre;
	private String username;

	@Email
	private String email;
	private long dinero;
	private Set<Rol> roles;
	private String tokenDeAcceso;


	public RegistroRespuestaDTO(String tokenDeAcceso, Usuario usuario) {
		super();
		this.nombre = usuario.getNombre();
		this.username = usuario.getUsername();
		this.email = usuario.getEmail();
		this.dinero = usuario.getDinero();
		this.roles = usuario.getRoles();

		this.tokenDeAcceso = tokenDeAcceso;
	}
}
