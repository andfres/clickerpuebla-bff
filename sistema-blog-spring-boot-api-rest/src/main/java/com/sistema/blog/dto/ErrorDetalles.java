package com.sistema.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
public class ErrorDetalles {

	private Date marcaDeTiempo;
	private String mensaje;
	private String detalles;




}
