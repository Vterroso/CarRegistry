package com.vterroso.carregistry.service.impl;

import com.vterroso.carregistry.model.Car;
import com.vterroso.carregistry.repository.CarRepository;
import com.vterroso.carregistry.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CarServiceImpl implements CarService {

    @Value("${car.defaultBrand}")
    private String defaultBrand;

    @Autowired
    private CarRepository carRepository;

    @Override
    public void logDefaultBrand() {
        log.info("Default car brand: {}", defaultBrand);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Integer id) {
        return carRepository.findById(id);
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
        log.info("Car added: {}", car);
    }

    @Override
    public Car updateCar(Integer id, Car car) {
        car.setId(id);
        carRepository.update(car);
        log.info("Car updated: {}", car);
        return car;
    }

    @Override
    public void deleteCar(Integer id) {
        carRepository.deleteById(id);
        log.info("Car deleted with id: {}", id);
    }
}
