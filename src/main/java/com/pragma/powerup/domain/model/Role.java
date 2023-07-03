package com.pragma.powerup.domain.model;

public class Role extends ObjectModel{
     private String description;

    public Role(Long id, String name, String description) {
        super(id, name);
        this.description = description;
    }

    public Role() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
