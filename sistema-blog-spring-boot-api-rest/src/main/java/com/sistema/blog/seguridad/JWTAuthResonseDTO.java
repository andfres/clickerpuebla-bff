package com.sistema.blog.seguridad;


import lombok.Data;

@Data
public class JWTAuthResonseDTO {

	private String tokenDeAcceso;
	private String tipoDeToken = "Bearer";

	public JWTAuthResonseDTO(String tokenDeAcceso) {
		super();
		this.tokenDeAcceso = tokenDeAcceso;
	}

	public JWTAuthResonseDTO(String tokenDeAcceso, String tipoDeToken) {
		super();
		this.tokenDeAcceso = tokenDeAcceso;
		this.tipoDeToken = tipoDeToken;
	}
}
