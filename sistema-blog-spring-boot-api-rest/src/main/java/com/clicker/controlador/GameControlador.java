package com.clicker.controlador;

import com.clicker.dto.*;
import com.clicker.entidades.*;
import com.clicker.repositorio.RolRepositorio;
import com.clicker.repositorio.UsuarioRepositorio;
import com.clicker.seguridad.JWTAuthResonseDTO;
import com.clicker.seguridad.JwtTokenProvider;
import com.clicker.servicio.UsuarioServicio;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameControlador {

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


	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/manager")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody CambiarManagerDTO cambiarManagerDTO, HttpServletRequest request){
		String token = request.getHeader(HttpHeaders.AUTHORIZATION);

		token = token.split(" ")[1];
		System.out.println(token);

		Claims claims;
		try {
			claims = Jwts.parser()
					.setSigningKey("JWTSecretKey")
					.parseClaimsJws(token)
					.getBody();

			String email = claims.get("sub").toString();

			return new ResponseEntity<>("token:" + claims.toString() ,HttpStatus.OK);

		} catch (Exception e) {
			System.out.println("Could not get all claims Token from passed token");
			return new ResponseEntity<>("fue mal" ,HttpStatus.BAD_REQUEST);

		}
	}



//	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/dinero")
	public ResponseEntity<?> actualizarDinero(@Valid @RequestBody DineroDTO dineroDTO, HttpServletRequest request){
		String token = request.getHeader(HttpHeaders.AUTHORIZATION);
		token = token.split(" ")[1];
		System.out.println(token);
		Claims claims;
		try {
			claims = Jwts.parser()
					.setSigningKey("JWTSecretKey")
					.parseClaimsJws(token)
					.getBody();

			String email = claims.get("sub").toString();
			usuarioServicio.actualizarDinero( dineroDTO,  email);

			return new ResponseEntity<>("DInero actualizado" ,HttpStatus.OK);

		} catch (Exception e) {
			System.out.println("Could not get all claims Token from passed token");
			return new ResponseEntity<>("fue mal" ,HttpStatus.BAD_REQUEST);

		}
	}



	@PutMapping("/edificios")
	public ResponseEntity<?> actualizarEdificios(@Valid @RequestBody List<EdificioDTO> edificiosDTO , HttpServletRequest request){
		String token = request.getHeader(HttpHeaders.AUTHORIZATION);
		token = token.split(" ")[1];
		System.out.println(token);
		Claims claims;
		try {
			claims = Jwts.parser()
					.setSigningKey("JWTSecretKey")
					.parseClaimsJws(token)
					.getBody();

			String email = claims.get("sub").toString();
			usuarioServicio.actualizarEdificios( edificiosDTO,  email);

			return new ResponseEntity<>("Eficios actualizados" ,HttpStatus.OK);

		} catch (Exception e) {

			System.out.println(e);
			return new ResponseEntity<>("fue mal" ,HttpStatus.BAD_REQUEST);

		}
	}




	@PutMapping("/edificio")
	public ResponseEntity<?> guardarUnEdificio(@RequestBody EdificioDTO dineroDTO, HttpServletRequest request){


		Edificio3 edificio = new Edificio3(
				new IdCombinado(1L, 1L),
				30);
		return new ResponseEntity<>("guardado un edificioo" ,HttpStatus.OK);

	}



//	@PutMapping("/managers")
//	public ResponseEntity<?> actualizarManagers(@Valid @RequestBody ManagerDTO managerDTO, HttpServletRequest request){
//		String token = request.getHeader(HttpHeaders.AUTHORIZATION);
//		token = token.split(" ")[1];
//		System.out.println(token);
//		Claims claims;
//		try {
//			claims = Jwts.parser()
//					.setSigningKey("JWTSecretKey")
//					.parseClaimsJws(token)
//					.getBody();
//
//			System.out.println(claims.toString());
//			String email = claims.get("sub").toString();
//			usuarioServicio.actualizarEdificios( edificiosDTO,  email);
//
//			return new ResponseEntity<>("Eficios actualizados supestamente" ,HttpStatus.OK);
//
//		} catch (Exception e) {
//			System.out.println("Could not get all claims Token from passed token");
//			return new ResponseEntity<>("fue mal" ,HttpStatus.OK);
//		}
//	}


}