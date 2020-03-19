package com.example.demo.service;

import com.example.demo.model.Owner;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
@Service
public class OwnerRepository {

    List<Owner> owners= Arrays.asList(

            new Owner(1,"Karl Hoffenfield", new Date("02/05/99")),
            new Owner(2,"Anne  Miles", new Date("07/08/90")),
            new Owner(3,"Mark Smith", new Date("14/04/80"))
                                                                                    );

    public OwnerRepository(List<Owner> owners) {
        this.owners = owners;
    }

    public OwnerRepository() {
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public Owner getOwner(int idOwner){
        for (Owner o: owners){

            if (o.getIdOwner()==idOwner){
                return  o;
            }
        }
       return null;
    }



}
