package com.pragma.powerup.domain.model;

public class ObjectModel {
    private Long id;
    private String name;

    public ObjectModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ObjectModel(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
