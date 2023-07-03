package com.pragma.powerup.domain.model;

import java.time.LocalDate;

public class Account extends ObjectModel{
    private String lastName;
    private String document;
    private String cellphone;
    private LocalDate birthdate;
    private String email;
    private String password;
    private Long idRole;

    public Account(Long id, String name, String lastName, String document, String cellphone, LocalDate birthdate, String email, String password, Long idRole) {
        super(id, name);
        this.lastName = lastName;
        this.document = document;
        this.cellphone = cellphone;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.idRole = idRole;
    }

    public Account(){

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }
}
