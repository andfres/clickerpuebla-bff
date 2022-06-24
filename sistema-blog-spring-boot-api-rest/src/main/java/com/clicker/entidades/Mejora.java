package com.clicker.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mejoras")
public class Mejora {

    @EmbeddedId
    private  IdCombinado id;

    private boolean adquirida = false;
    private String tipo;
    private int cantidad;
    private String aplica;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="fk_usuario")
    private Usuario usuario;
}

