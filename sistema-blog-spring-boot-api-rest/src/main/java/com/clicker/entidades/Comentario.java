package com.clicker.entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Data
@NoArgsConstructor
@Entity
@Table(name = "comentarios")
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nombre;
	private String email;
	private String cuerpo;

	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "publicacion_id", nullable = false)
	private Publicacion publicacion;


}
