package com.clicker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogroDTO {

    private int id;
    private boolean logrado = false;
    private FechaDTO fecha;


}
