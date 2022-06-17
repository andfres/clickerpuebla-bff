package com.clicker.entidades;

import javax.persistence.*;

@Entity
@Table(name = "edificios3")
public class Edificio3 {
	@EmbeddedId
	private  IdCombinado id;

	private long nivel = 1;


	public IdCombinado getId() {
		return id;
	}

	public void setId(IdCombinado id) {
		this.id = id;
	}

	public long getNivel() {
		return nivel;
	}

	public void setNivel(long nivel) {
		this.nivel = nivel;
	}


	public Edificio3(IdCombinado id, long nivel) {
		this.id = id;
		this.nivel = nivel;
	}

	public Edificio3() {
	}
}
