package com.sistema.blog.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LoginDTO {

	private String usernameOrEmail;
	private String password;

}
