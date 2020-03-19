package com.example.demo.service;

import com.example.demo.model.Color;
import com.example.demo.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class DogRepository {

    List<Dog> dogs=new ArrayList<>();

    public DogRepository() {
        dogs.add(new Dog(1,"Max", Color.GOLDEN,"Golden Retriever",true));
        dogs.add(new Dog(2,"Oli", Color.GOLDEN,"Labrador",true));
        dogs.add(  new Dog(3,"Kiki", Color.GOLDEN,"Akita Inu",true));
        dogs.add( new Dog(4,"Rex", Color.BROWN,"Border Collie",true));
        dogs.add( new Dog(5,"Zen", Color.GOLDEN,"Chow Chow",true));

    }

    public DogRepository(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public void addDog(Dog dog){
        dogs.add(dog);
    }

    public void deleteDog(int idDog){
        for (Dog adog : dogs ){
            if (adog.getIdDog()==idDog){
                dogs.remove(adog);
                break;

            }
        }
        System.out.println("dog deleted");
    }

    public List<Dog> getDogs() {
        return dogs;
    }
    public Dog getDog(int idDog) {

        for (Dog adog : dogs ){
            if (adog.getIdDog()==idDog){
               return  adog;

            }
        }
        return null;
    }

    public void updateDog( Dog dog){
        int idDog=dog.getIdDog();
        for (Dog adog : dogs ){
            if (adog.getIdDog()==idDog){
                dogs.remove(adog);
                dogs.add(dog);
                break;
            }
        }
        System.out.println("updated");

    }
}
