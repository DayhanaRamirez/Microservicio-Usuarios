package com.pragma.powerup.domain.model;

public class Account extends ObjectModel{
    private String lastName;
    private int document;
    private String cellphone;
    private String birthdate;
    private String email;
    private String password;
    private Long idRole;

    public Account(Long id, String name, String lastName, int document, String cellphone, String birthdate, String email, String password, Long idRole) {
        super(id, name);
        this.lastName = lastName;
        this.document = document;
        this.cellphone = cellphone;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.idRole = idRole;
    }

    public Account(String lastName, int document, String cellphone, String birthdate, String email, String password, Long idRole) {
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

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
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
