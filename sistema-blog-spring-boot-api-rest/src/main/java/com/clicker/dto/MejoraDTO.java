package com.clicker.dto;

import com.clicker.entidades.IdCombinado;
import com.clicker.entidades.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data

public class MejoraDTO {

    private int id;
    private boolean adquirida = false;
    private ParametrosDTO parametros;


}
