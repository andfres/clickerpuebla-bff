package com.clicker.entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Entity
@Table(name = "usuarios",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"username"}),
                @UniqueConstraint(columnNames = {"email"})})

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue(strategy=GenerationType.SEQUENCE)

    private long id;

    private String nombre;
    private String username;

    @Email
    private String email;
    private String password;
    private long dinero;

//	@JoinTable(name = "usuarios_roles",
//			joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
//			inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
//	private Set<Rol> roles = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Rol> roles = new HashSet<>();

//    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
//    private List<Edificio> edificios;

    @OneToMany(mappedBy = "usuario",
            cascade = CascadeType.ALL)
    private List<Edificio> edificios = new ArrayList<Edificio>();




    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Manager> managers;



//    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
//    @JoinTable(name = "usuarios_roles",
//			joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
//			inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
//	private Set<Rol> edificios ;

//	private Set<Manager> managers = new HashSet<>();
//
//	@ManyToMany(fetch = FetchType.EAGER)
//	private Set<Rol> roles = new HashSet<>();



}
