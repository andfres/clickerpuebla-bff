package com.clicker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DatosDTO {
	private List<EdificioDTO> edificios = new ArrayList<>();
	private List<ManagerDTO> managers = new ArrayList<>();
	private List<MejoraDTO> mejoras = new ArrayList<>();
	private List<LogroDTO> logros = new ArrayList<>();
	private Long dinero;
	private Long dineroTotal;
}
