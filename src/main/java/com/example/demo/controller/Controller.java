package com.example.demo.controller;

import com.example.demo.model.Dog;
import com.example.demo.model.DogOwner;
import com.example.demo.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.DogOwnerRepository;
import com.example.demo.service.DogRepository;
import com.example.demo.service.OwnerRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    private DogOwnerRepository dogOwnerRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private DogRepository dogRepository;



 @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getDogs() {
        System.out.println("get dogs");
            return new ResponseEntity<List<Dog>>(dogRepository.getDogs(), HttpStatus.OK);
    }

    @GetMapping("/dogs/{dogId}")
    public ResponseEntity<Dog> getDog(@PathVariable int dogId) {
        Dog dog = dogRepository.getDog(dogId);
        if (dog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(dog, HttpStatus.OK);
        }
    }
    @GetMapping("/dogs/idOwner")
    public ResponseEntity<List<Dog>> getDogs(@PathVariable int idOwner) {
        return new ResponseEntity<List<Dog>>(dogOwnerRepository.getDogsForOwner(idOwner), HttpStatus.OK);
    }
    @PostMapping("/dogs")
    public ResponseEntity addDog(@RequestBody Dog dog) {
        try {
            dogRepository.addDog(dog);
            return new ResponseEntity( HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }
    }

    @DeleteMapping("/dogs/{dogId}")
    public ResponseEntity deleteDog(@PathVariable int dogId) {
        try {
            dogRepository.deleteDog(dogId);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/dogs")
    public ResponseEntity updateDog(@RequestBody Dog dog) {
        dogRepository.updateDog(dog);
        try {
            dogRepository.updateDog(dog);
            return new ResponseEntity( HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/owners")
    public ResponseEntity<List<Owner>> getOwners() {
        return new ResponseEntity<List<Owner>>( ownerRepository.getOwners(), HttpStatus.OK);
    }

    @GetMapping("/owners/{ownerId}")
    public ResponseEntity<Owner> getOwner(@PathVariable int ownerId) {
         Owner owner = (Owner) ownerRepository.getOwner(ownerId);
        if (owner == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Owner>(owner, HttpStatus.OK);
        }
    }


    @GetMapping("/dogowners/{ownerId}")
    public ResponseEntity<List<Dog>> getDogsForOwner(@PathVariable int ownerId) {
        List<Dog> dogs= dogOwnerRepository.getDogsForOwner(ownerId);
        if (dogs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Dog>>(dogs, HttpStatus.OK);
        }
    }

    @PostMapping("/dogowners/{ownerId}/{dogId}")
    public ResponseEntity addDogOwner(@PathVariable int ownerId,@PathVariable int dogId) {
        try {
            dogOwnerRepository.addDogOwner(new DogOwner(ownerId,dogId));
            return new ResponseEntity( HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }
    }



}
