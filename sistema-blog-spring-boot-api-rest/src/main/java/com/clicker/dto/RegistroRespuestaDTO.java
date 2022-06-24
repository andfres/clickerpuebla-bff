package com.clicker.dto;


import com.clicker.entidades.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Setter
@Getter

public class RegistroRespuestaDTO {

	private String nombre;
	private String username;

	private String email;
	private long dinero;
	private long dineroTotal;
	private Set<Rol> roles;
	private String tokenDeAcceso;

	@JsonIgnoreProperties("usuario")
	private List<Edificio> edificios = new ArrayList<Edificio>();
	@JsonIgnoreProperties("usuario")
	private List<Manager> managers = new ArrayList<Manager>();
	@JsonIgnoreProperties("usuario")
	private List<Mejora> mejoras = new ArrayList<Mejora>();
	@JsonIgnoreProperties("usuario")
	private List<Logro> logros = new ArrayList<Logro>();

	public RegistroRespuestaDTO(String tokenDeAcceso, Usuario usuario) {
//		super();
		this.nombre = usuario.getNombre();
		this.username = usuario.getUsername();
		this.email = usuario.getEmail();
		this.dinero = usuario.getDinero();
		this.dineroTotal = usuario.getDineroTotal();
		this.roles = usuario.getRoles();

		this.edificios = usuario.getEdificios();
		this.managers = usuario.getManagers();
		this.mejoras = usuario.getMejoras();
		this.logros = usuario.getLogros();

		this.tokenDeAcceso = tokenDeAcceso;
	}
}
