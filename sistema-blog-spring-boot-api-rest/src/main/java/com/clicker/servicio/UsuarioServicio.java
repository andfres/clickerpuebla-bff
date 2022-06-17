package com.clicker.servicio;

import com.clicker.dto.DineroDTO;
import com.clicker.dto.EdificioDTO;
import com.clicker.entidades.Edificio;
import com.clicker.entidades.IdCombinado;
import com.clicker.entidades.Usuario;
import com.clicker.excepciones.ResourceNotFoundException2;
import com.clicker.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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
               .orElseThrow(() -> new ResourceNotFoundException2("usuarioServicio", "actualizarDinero"));

        usuario.setDinero(dineroDTO.getDinero());
        Usuario usuarioActualizado = usuarioRepositorio.save(usuario);

    };

//
//    @Transactional
//    public void actualizarEdificios2(List<EdificioDTO> edificiosDTO , String email) {
//
//        Usuario usuario = usuarioRepositorio.findByEmail(email)
//                .orElseThrow(() -> new ResourceNotFoundException2("usuarioServicio", "actualizarEdifcios"));
//
//        List<Edificio2> edificios = new ArrayList<>();
//
//        for (EdificioDTO dto : edificiosDTO ) {
//            Edificio edificio = new Edificio(
//                    dto.getNivel(),
//                    usuario
//            );
//            edificios.add(edificio);
//        }
//
//       usuario.setEdificios(edificios);
//        Usuario usuarioActualizado = usuarioRepositorio.save(usuario);
//
//    };


    @Transactional
    public void actualizarEdificios(List<EdificioDTO> edificiosDTO , String email) {

        Usuario usuario = usuarioRepositorio.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException2("usuarioServicio", "actualizarEdifcios"));

        try {
            List<Edificio> edificios = new ArrayList<>();
            for (EdificioDTO dto : edificiosDTO ) {
                Edificio edificio = new Edificio(
                        new IdCombinado(usuario.getId(), dto.getId_pasado()),
                        dto.getNivel(),
                       usuario
                );
                edificios.add(edificio);
            }

            System.out.println(edificios.toString());
            usuario.setEdificios(edificios);
           Usuario usuarioActualizado = usuarioRepositorio.save(usuario);
        }catch (Exception e){
            e.printStackTrace();
        }


    };






}
