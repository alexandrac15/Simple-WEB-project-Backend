package com.example.demo.service;

import com.example.demo.model.Dog;
import com.example.demo.model.DogOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DogOwnerRepository {

    List<DogOwner> dogsAndOwners=new ArrayList<>();
    @Autowired
    DogRepository dogRepository;

    public DogOwnerRepository(DogRepository dr){
        this.dogRepository=dr;
    };

    public DogOwnerRepository() {
         dogsAndOwners.add(new DogOwner(1,2));
    }

    public void addDogOwner (DogOwner dogOwner){
        dogsAndOwners.add(dogOwner);
    }

    public void deleteDogOwner(DogOwner dogOwner){
        dogsAndOwners.remove(dogOwner);
    }

    public List<Dog> getDogsForOwner(int idOwner){
        List<Dog> dogs = new ArrayList<>();

        for (DogOwner dogowner : dogsAndOwners ){
            if (dogowner.getOwnerId()==idOwner){
                  dogs.add(dogRepository.getDog(dogowner.getDogId()));
            }
        }
       return dogs;
    }
}
