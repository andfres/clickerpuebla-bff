package com.clicker.entidades;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Post")
@Table(name = "post")
public class Parametros {
    public String tipo;
    public int cantidad;
}
