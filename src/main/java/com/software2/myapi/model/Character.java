package com.software2.myapi.model;

public class Character {
private long id;
private String name;
private String power;

    public Character() {
    }

    public Character(long id, String name, String power) {
        this.id = id;
        this.name = name;
        this.power = power;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
