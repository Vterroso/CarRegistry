package com.vterroso.carregistry.repository.impl;

import com.vterroso.carregistry.model.Car;
import com.vterroso.carregistry.repository.CarRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository {
    private final List<Car> cars = new ArrayList<>();

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public Car findById(Integer id) {
        return cars.stream().filter(car -> car.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void save(Car car) {
        cars.add(car);
    }

    @Override
    public void update(Car car) {
        Car existingCar = findById(car.getId());
        if (existingCar != null) {
            int index = cars.indexOf(existingCar);
            cars.set(index, car); // Update the car
        }
    }

    @Override
    public void deleteById(Integer id) {
        cars.removeIf(car -> car.getId().equals(id));
    }
}

