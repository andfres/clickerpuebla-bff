package com.clicker.controlador;

import java.util.*;

import com.clicker.dto.RegistroRespuestaDTO;
import com.clicker.entidades.Edificio;
import com.clicker.entidades.Manager;
import com.clicker.excepciones.ResourceNotFoundException2;
import com.clicker.repositorio.UsuarioRepositorio;
import com.clicker.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clicker.dto.LoginDTO;
import com.clicker.dto.RegistroDTO;
import com.clicker.entidades.Rol;
import com.clicker.entidades.Usuario;
import com.clicker.repositorio.RolRepositorio;
import com.clicker.seguridad.JWTAuthResonseDTO;
import com.clicker.seguridad.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthControlador {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private RolRepositorio rolRepositorio;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private UsuarioServicio usuarioServicio;



	@PostMapping("/registrar")
	public ResponseEntity<?> registrarUsuario(@RequestBody RegistroDTO registroDTO){

		if(usuarioRepositorio.existsByUsername(registroDTO.getUsername())) {
			System.out.println("ya existe nombre");
			return new ResponseEntity<>("Ese nombre de usuario ya existe",HttpStatus.BAD_REQUEST);
		}

		if(usuarioRepositorio.existsByEmail(registroDTO.getEmail())) {
			System.out.println("ya existe email");
			return new ResponseEntity<>("Ese email de usuario ya existe",HttpStatus.BAD_REQUEST);
		}

		Usuario usuario = new Usuario();
		usuario.setNombre(registroDTO.getNombre());
		usuario.setUsername(registroDTO.getUsername());
		usuario.setEmail(registroDTO.getEmail());
		usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));

		Rol roles = rolRepositorio.findByNombre("ROLE_USER").get();
		usuario.setRoles(Collections.singleton(roles));

		usuarioRepositorio.save(usuario);

		System.out.println("Usuario registrado exitosamente");
		return new ResponseEntity<>("Usuario registrado exitosamente",HttpStatus.OK);
	}





	@PostMapping("/iniciarSesion")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginDTO loginDTO){

		if(!usuarioRepositorio.existsByEmail(loginDTO.getUsernameOrEmail())) {
			System.out.println("No existe ");
			return new ResponseEntity<>("Email o password invalidos",HttpStatus.BAD_REQUEST);
		}

		try{
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		//obtenemos el token del jwtTokenProvider
		String token = jwtTokenProvider.generarToken(authentication);

		System.out.println(token);

		Usuario user = usuarioRepositorio.findByEmail(authentication.getName())
				.orElseThrow(() -> new ResourceNotFoundException2("inicarsesion", "email"));

			return ResponseEntity.ok(new RegistroRespuestaDTO(token, user));

		}catch (Exception e){

			return new ResponseEntity<>("Email o password invalidos",HttpStatus.BAD_REQUEST);
		}
	}


}
