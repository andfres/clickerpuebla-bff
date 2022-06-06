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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerId managerId = (ManagerId) o;
        return managerID == managerId.managerID && userID.equals(managerId.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, managerID);
    }
}