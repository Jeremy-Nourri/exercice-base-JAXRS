package org.example.jaxrs.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.jaxrs.model.Car;
import org.example.jaxrs.service.CarService;

import java.util.List;

@Path("/cars")
public class CarController {

    CarService carService = new CarService();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> cars() {
        return carService.getCars();
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean createCar(@FormParam("id") int id,@FormParam("brand") String brand, @FormParam("year") int year, @FormParam("color") String color) {
        carService.createCar(id, brand, year, color);
           return true;
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car updateCar(@PathParam("id") int id, Car car) {
        return carService.updateCar(id, car);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCar(@PathParam("id") int id) {
        return carService.deleteCar(id);
    }
}