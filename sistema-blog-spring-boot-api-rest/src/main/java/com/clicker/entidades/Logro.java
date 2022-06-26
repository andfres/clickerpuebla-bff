package com.clicker.entidades;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "logros")
public class Logro {

    @EmbeddedId
    private  IdCombinado id;

    private boolean logrado = false;
    public String dia;
    public String hora;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="fk_usuario")
    private Usuario usuario;



}
