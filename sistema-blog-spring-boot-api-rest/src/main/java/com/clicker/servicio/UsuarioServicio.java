package com.clicker.servicio;

import com.clicker.dto.DineroDTO;
import com.clicker.entidades.Usuario;
import com.clicker.excepciones.ResourceNotFoundException;
import com.clicker.excepciones.ResourceNotFoundException2;
import com.clicker.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioServicio {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> obtenerPorEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }


    @Transactional
    public void actualizarDinero(DineroDTO dineroDTO, String email) {

        Usuario usuario = usuarioRepositorio.findByEmail(email)
               .orElseThrow(() -> new ResourceNotFoundException2("Publicacion", "email"));

        usuario.setDinero(dineroDTO.getDinero());

        Usuario usuarioActualizado = usuarioRepositorio.save(usuario);

    };




}
