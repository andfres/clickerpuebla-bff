package com.clicker.repositorio;

import java.util.List;

import com.clicker.entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepositorio extends JpaRepository<Comentario, Long>{

	public List<Comentario> findByPublicacionId(long publicacionId); 
	
}
