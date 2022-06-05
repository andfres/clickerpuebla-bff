package com.clicker.repositorio;

import java.util.Optional;

import com.clicker.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepositorio extends JpaRepository<Rol, Long>{

	public Optional<Rol> findByNombre(String nombre);
	
}
