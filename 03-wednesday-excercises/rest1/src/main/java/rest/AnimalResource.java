/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entities.Animal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Renz
 */
@Path("animal")
public class AnimalResource {
private static List<Animal> animal = new ArrayList();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
    }

    /**
     * Retrieves representation of an instance of rest.AnimalResource
     * @return an instance of java.lang.String
     */
    @GET
   // @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "Hello from my first web service";
    }

    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public String getString(){
        return "hello this is random";
    }
    
    public ArrayList<Animal> createAnimal(){
        animal.add(new Animal("Dog", 1994, "moo"));
        animal.add(new Animal("cat", 1994, "quack"));
        animal.add(new Animal("fugl", 1994, "woof"));
        animal.add(new Animal("fisk", 1994, "pip pip"));
        return (ArrayList<Animal>) animal;
    } 
    @GET
    @Path("/animal")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimal(){
        createAnimal();
        Random r = new Random();
        int x = r.nextInt(animal.size());
        Animal obj = animal.get(x);
        return new Gson().toJson(obj);
    }
}
    
