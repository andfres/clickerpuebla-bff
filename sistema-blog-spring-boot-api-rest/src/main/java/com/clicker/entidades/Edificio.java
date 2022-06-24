package com.clicker.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "edificios")
public class Edificio {

	@EmbeddedId
	private  IdCombinado id;

	private int nivel = 1;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="fk_usuario")
	private Usuario usuario;
}
