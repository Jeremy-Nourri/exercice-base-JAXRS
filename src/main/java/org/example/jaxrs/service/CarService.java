package org.example.jaxrs.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.jaxrs.data.FakeBDD;
import org.example.jaxrs.model.Car;

import java.util.List;


@ApplicationScoped
public class CarService {

    public boolean createCar(int id, String brand, int year, String color) {
        Car car = new Car(id, brand, year, color);
        FakeBDD.cars.add(car);
        return true;
    }

    public Car updateCar(int id, Car car) {
        Car carFound = FakeBDD.cars.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (carFound != null) {
            carFound = car;
        } else {
            return null;
        }
        return carFound;
    }


    public String deleteCar(int id) {
        Car carFound = FakeBDD.cars.stream()
                .filter(car -> car.getId() == id)
                .findFirst()
                .orElse(null);

        if (carFound != null) {
            FakeBDD.cars.remove(carFound);
            return "Car with id " + id + " deleted";
        } else {
            return "Car with id " + id + " not found";
        }
    }

    public List<Car> getCars() {
        return FakeBDD.cars;
    }

}
