package com.pragma.powerup.domain.model;

public class Employee extends ObjectModel{
    private String lastName;
    private String document;
    private String cellphone;
    private String email;
    private String password;
    private Long idRole;
    private Long idRestaurant;

    public Employee(Long id, String name, String lastName, String document, String cellphone, String email, String password, Long idRole, Long idRestaurant) {
        super(id, name);
        this.lastName = lastName;
        this.document = document;
        this.cellphone = cellphone;
        this.email = email;
        this.password = password;
        this.idRole = idRole;
        this.idRestaurant = idRestaurant;
    }

    public Employee(){

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

    public Long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
    }
}
