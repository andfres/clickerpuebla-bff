package com.clicker.repositorio;

import com.clicker.entidades.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EdificioRepositorio extends JpaRepository<Edificio, Long>{


}
