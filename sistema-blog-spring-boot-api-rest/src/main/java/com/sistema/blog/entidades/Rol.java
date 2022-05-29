package com.sistema.blog.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	//@Column(length = 60)
	private String nombre;


}
