package com.nagel.lab3template;

public class Plant {

    private int id;
    private String name;
    private String description;
    private String latinName;

    public Plant(int id, String name, String description, String latinName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.latinName = latinName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }
}
