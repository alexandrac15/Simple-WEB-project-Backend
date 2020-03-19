package com.example.demo.model;

public class DogOwner {
    private int dogId;
    private int ownerId;


    public DogOwner() {
    }

    public DogOwner(int ownerId, int dogId) {
        this.dogId = dogId;
        this.ownerId=ownerId;
    }

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
