package com.clicker.servicio;

import com.clicker.dto.*;
import com.clicker.entidades.*;
import com.clicker.excepciones.ResourceNotFoundException2;
import com.clicker.repositorio.EdificioRepositorio;
import com.clicker.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UsuarioServicio {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    EdificioRepositorio edificioRepositorio;

    @Transactional
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> obtenerPorEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }



    public void actualizarDinero(DineroDTO dineroDTO, Usuario usuario) {

        usuario.setDinero(dineroDTO.getDinero());

    }




    public void actualizarEdificios(List<EdificioDTO> edificiosDTO, Usuario usuario) {
        List<Edificio> edificios = new ArrayList<>();
        for (EdificioDTO dto : edificiosDTO) {
            Edificio edificio = new Edificio(
                    new IdCombinado(usuario.getEmail(), dto.getId()),
                    dto.getNivel(),
                    usuario
            );
            edificios.add(edificio);
        }

        usuario.setEdificios(edificios);
    }

    public void actualizarManagers(List<ManagerDTO> managersDTO, Usuario usuario) {
        List<Manager> managers = new ArrayList<>();
        for (ManagerDTO dto : managersDTO) {
            Manager manager = new Manager(
                    new IdCombinado(usuario.getEmail(), dto.getId()),
                    dto.isContratado(),
                    usuario
            );
            managers.add(manager);
        }
        usuario.setManagers(managers);
    }

    public void actualizarMejoras(List<MejoraDTO> mejoraDTO, Usuario usuario) {
        List<Mejora> mejoras = new ArrayList<>();
        for (MejoraDTO dto : mejoraDTO) {
            Mejora mejora = new Mejora(
                    new IdCombinado(usuario.getEmail(), dto.getId()),
                    dto.isAdquirida(),
                    dto.getParametros().getTipo(),
                    dto.getParametros().getCantidad(),
                    dto.getParametros().getAplica(),
                    usuario
            );
            mejoras.add(mejora);
        }
        usuario.setMejoras(mejoras);
    }


    public void actualizarLogros(List<LogroDTO> logrosDTO, Usuario usuario) {
        List<Logro> logros = new ArrayList<>();
        for (LogroDTO dto : logrosDTO) {
            Logro logro = new Logro(
                    new IdCombinado(usuario.getEmail(), dto.getId()),
                    dto.isLogrado(),
                    dto.getFecha().getDia(),
                    dto.getFecha().getHora(),
                    usuario
            );
            logros.add(logro);
        }
        usuario.setLogros(logros);
    }


}

