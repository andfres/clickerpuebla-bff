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

	private long nivel = 1;

//	@ManyToOne( cascade = CascadeType.ALL)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_usuario")
	private Usuario usuario;

}
