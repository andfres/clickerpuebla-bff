package com.clicker.dto;

import com.clicker.entidades.IdCombinado;
import com.clicker.entidades.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor

public class ManagerDTO {

    private int id;
    private boolean contratado = false;
    
}
