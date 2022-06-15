package com.clicker.controlador;

import java.util.*;

import com.clicker.dto.RegistroRespuestaDTO;
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

		System.out.println("------------------------------------------------");


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
		Rol roles = rolRepositorio.findByNombre("ROLE_ADMIN").get();
		usuario.setRoles(Collections.singleton(roles));



		Manager[] managers = {
				new Manager(usuario.getEmail(), 1L, false),
				new Manager(usuario.getEmail(), 2L, false),
				new Manager(usuario.getEmail(), 3L, false),
				new Manager(usuario.getEmail(), 5L, false),
				new Manager(usuario.getEmail(), 4L, false),
				new Manager(usuario.getEmail(), 6L, false),
		};
		List listaManagers = new ArrayList<Manager>(Arrays.asList(managers));

		usuario.setManagers(listaManagers);
		usuarioRepositorio.save(usuario);

		System.out.println("Usuario registrado exitosamente");
		return new ResponseEntity<>("Usuario registrado exitosamente",HttpStatus.OK);
	}

	@PostMapping("/iniciarSesionViejo")
	public ResponseEntity<JWTAuthResonseDTO> authenticateUserViejo(@RequestBody LoginDTO loginDTO){

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		//obtenemos el token del jwtTokenProvider
		String token = jwtTokenProvider.generarToken(authentication);

		usuarioRepositorio.findByEmail(authentication.getName());

		return ResponseEntity.ok(new JWTAuthResonseDTO(token));
	}

	@PostMapping("/iniciarSesion")
	public ResponseEntity<RegistroRespuestaDTO> authenticateUser(@RequestBody LoginDTO loginDTO){

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		//obtenemos el token del jwtTokenProvider
		String token = jwtTokenProvider.generarToken(authentication);

		Usuario user = usuarioRepositorio.findByEmail(authentication.getName())
				.orElseThrow(() -> new ResourceNotFoundException2("inicarsesion", "email"));

		return ResponseEntity.ok(new RegistroRespuestaDTO(token, user));
	}


}
