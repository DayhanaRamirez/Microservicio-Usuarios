package com.pragma.powerup.infrastructure.output.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "empleados")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "numero_documento")
    private String document;

    @Column(name = "celular")
    private String cellphone;

    @Column(name = "correo", unique = true)
    private String email;

    @Column(name = "clave")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    private RoleEntity roleEntity;

    @Column(name = "id_restaurante")
    private Long idRestaurant;
}
