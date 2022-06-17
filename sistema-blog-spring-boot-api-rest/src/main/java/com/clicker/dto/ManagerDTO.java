package com.clicker.dto;

import com.clicker.entidades.ManagerId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@NoArgsConstructor
public class ManagerDTO {

    private Long managerID;
    private boolean contratado = false;

}
