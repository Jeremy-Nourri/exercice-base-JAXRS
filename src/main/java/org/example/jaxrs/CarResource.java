package org.example.jaxrs;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.example.jaxrs.entity.Car;

import java.util.List;

@Path("/cars")
public class CarResource {
    @GET
    @Path ("/one")
    @Produces("application/json")
    public Car car() {
        return new Car(1, "renault", 2022, "red");
    }

    @GET
    @Produces("application/json")
    public List<Car> cars() {
        return List.of(
                new Car(1, "renault", 2022, "red"),
                new Car(2, "peugeot", 2021, "blue")
        );
    }
}