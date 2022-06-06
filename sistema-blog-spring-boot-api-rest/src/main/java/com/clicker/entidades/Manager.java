package com.clicker.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j

@Entity
@Table(name = "managers")
@IdClass(ManagerId.class)
public class Manager {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="MANAGER_ID", unique = true, nullable = false)
//	private long id;


    @Id
    private Long userID;

    @Id
    private Long managerID;

    // other fields, getters and setters

    private boolean contratado = false;


}
