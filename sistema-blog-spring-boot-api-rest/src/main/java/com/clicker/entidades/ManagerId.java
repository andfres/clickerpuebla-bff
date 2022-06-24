package com.clicker.entidades;

import lombok.Data;

import java.io.Serializable;

@Data
public class ManagerId implements Serializable {
    private String userEmail;
    private Long managerID;


}