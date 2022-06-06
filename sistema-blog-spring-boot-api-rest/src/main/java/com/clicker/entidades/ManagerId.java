package com.clicker.entidades;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
public class ManagerId implements Serializable {
    private Long userID;

    private Long managerID;

    public ManagerId(Long userID, Long managerID) {
        this.userID = userID;
        this.managerID = managerID;
    }

    // equals() and hashCode()


}