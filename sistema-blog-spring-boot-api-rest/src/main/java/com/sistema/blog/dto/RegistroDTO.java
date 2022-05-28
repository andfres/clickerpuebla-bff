package com.sistema.blog.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistroDTO {

	private String nombre;
	private String username;
	private String email;
	private String password;

}
