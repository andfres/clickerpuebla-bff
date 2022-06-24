package com.clicker.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Embeddable
public class IdCombinado implements Serializable {

    private String userEmail;
    private int elmentID;

}