package com.clicker.entidades;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
public class ManagerId implements Serializable {
    private String userEmail;

    private Long managerID;

    public ManagerId(Long userID, Long managerID) {
        this.userEmail = userEmail;
        this.managerID = managerID;
    }

    // equals() and hashCode()


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerId managerId = (ManagerId) o;
        return userEmail.equals(managerId.userEmail) && managerID.equals(managerId.managerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, managerID);
    }
}