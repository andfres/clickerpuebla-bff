package com.clicker.servicio;

import com.clicker.entidades.Edificio;
import com.clicker.repositorio.EdificioRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EdificiosServicio {

    @Autowired
    EdificioRepositorio edificioRepositorio;

    @Transactional
    public Edificio guardarEdificio(Edificio edificio) {
        return edificioRepositorio.save(edificio);
    }





}
