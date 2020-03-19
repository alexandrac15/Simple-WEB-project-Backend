package com.example.demo.model;

public class Dog {

    private int idDog;
    private String name;
    private Color color;
    private String breed;
    private boolean isPlayful;


    public Dog(){};
    public Dog(int idDog, String name, Color color, String breed, boolean isPlayful) {
        this.idDog = idDog;
        this.name = name;
        this.color = color;
        this.breed = breed;
        this.isPlayful = isPlayful;
    }

    public int getIdDog() {
        return idDog;
    }

    public void setIdDog(int idDog) {
        this.idDog = idDog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isPlayful() {
        return isPlayful;
    }

    public void setPlayful(boolean playful) {
        isPlayful = playful;
    }

}
