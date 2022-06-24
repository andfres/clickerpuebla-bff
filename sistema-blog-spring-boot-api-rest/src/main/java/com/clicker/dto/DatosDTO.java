package com.clicker.dto;

import com.clicker.entidades.Edificio;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EdificiosDTO {
	private List<EdificioDTO> edificios = new ArrayList<>();

}
