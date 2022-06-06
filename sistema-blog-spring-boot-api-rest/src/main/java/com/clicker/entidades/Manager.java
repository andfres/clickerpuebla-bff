package com.clicker.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    private boolean contratado = false;


}
