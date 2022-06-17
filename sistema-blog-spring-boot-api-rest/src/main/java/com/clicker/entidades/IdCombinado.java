package com.clicker.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class IdCombinado implements Serializable {

    private Long userID;
    private Long elmentID;


// equals() and hashCode()


    public IdCombinado(Long userID, Long elmentID) {
        this.userID = userID;
        this.elmentID = elmentID;
    }
}