package com.clicker.controlador;

import com.clicker.dto.*;
import com.clicker.entidades.*;
import com.clicker.excepciones.ResourceNotFoundException2;
import com.clicker.repositorio.UsuarioRepositorio;

import com.clicker.servicio.UsuarioServicio;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/game")
public class GameControlador {


	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private UsuarioServicio usuarioServicio;





//	@PutMapping("/dinero")
//	public ResponseEntity<?> actualizarDinero(@Valid @RequestBody DineroDTO dineroDTO, HttpServletRequest request){
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
//			String email = claims.get("sub").toString();
//
//			Usuario usuario = usuarioRepositorio.findByEmail(email)
//					.orElseThrow(() -> new ResourceNotFoundException2("usuarioServicio", "actualizarEdifcios"));
//			usuarioServicio.actualizarDinero( dineroDTO,  usuario);
//
//			return new ResponseEntity<>("DInero actualizado" ,HttpStatus.OK);
//
//		} catch (Exception e) {
//			System.out.println("Could not get all claims Token from passed token");
//			return new ResponseEntity<>("fue mal" ,HttpStatus.BAD_REQUEST);
//
//		}
//	}



	@PreAuthorize("hasRole('USER')")
	@PutMapping("/guardarDatos")
	public ResponseEntity<?> actualizarDatos(@Valid @RequestBody DatosDTO datosDTO , HttpServletRequest request){
		try {

			System.out.println("GUARDADO DATOS");
			String token = request.getHeader(HttpHeaders.AUTHORIZATION);
			token = token.split(" ")[1];
			Claims claims;

			claims = Jwts.parser()
					.setSigningKey("JWTSecretKey")
					.parseClaimsJws(token)
					.getBody();

			String email = claims.get("sub").toString();
			Usuario usuario = usuarioRepositorio.findByEmail(email)
					.orElseThrow(() -> new ResourceNotFoundException2("usuarioServicio", "actualizarEdifcios"));

			usuarioServicio.actualizarEdificios(datosDTO.getEdificios(), usuario);
			usuarioServicio.actualizarManagers(datosDTO.getManagers(), usuario);
			usuarioServicio.actualizarMejoras(datosDTO.getMejoras(), usuario);
			usuarioServicio.actualizarLogros(datosDTO.getLogros(), usuario);
			usuario.setDinero(datosDTO.getDinero());
			usuario.setDineroTotal(datosDTO.getDineroTotal());

			usuarioRepositorio.save(usuario);
			return new ResponseEntity<>("Datos actualizados" ,HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>("fue mal" ,HttpStatus.BAD_REQUEST);
		}
	}




	@GetMapping ("/recuperarDatos")

	public ResponseEntity<?> recuperarDatos(HttpServletRequest request){
		System.out.println("Devolviendo Datos");
		try {
		String token = request.getHeader(HttpHeaders.AUTHORIZATION);
		token = token.split(" ")[1];
		Claims claims;

			claims = Jwts.parser()
					.setSigningKey("JWTSecretKey")
					.parseClaimsJws(token)
					.getBody();


			String email = claims.get("sub").toString();
//			System.out.println(email);

			Usuario user = usuarioRepositorio.findByEmail(email)
					.orElseThrow(() -> new ResourceNotFoundException2("usuarioServicio", "actualizarEdifcios"));

//			System.out.println(user);

			return ResponseEntity.ok(new RegistroRespuestaDTO(token, user));

		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>("fue mal" ,HttpStatus.BAD_REQUEST);
		}
	}

}