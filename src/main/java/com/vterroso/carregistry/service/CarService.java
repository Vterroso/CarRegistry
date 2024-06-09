package com.vterroso.carregistry.service;

import com.vterroso.carregistry.model.Car;

import java.util.List;

public interface CarService {
    void logDefaultBrand();
    List<Car> getAllCars();
    Car getCarById(Integer id);
    void addCar(Car car);
    Car updateCar(Integer id, Car car);
    void deleteCar(Integer id);
}