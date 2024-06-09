package com.vterroso.carregistry.controller.impl;

import com.vterroso.carregistry.controller.CarController;
import com.vterroso.carregistry.model.Car;
import com.vterroso.carregistry.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cars")
@Tag(name = "Car", description = "Endpoints for managing cars")
public class CarControllerImpl implements CarController {

    @Autowired
    private CarService carService;

    @Override
    @GetMapping
    @Operation(summary = "Get all cars", description = "Retrieve a list of all cars")
    public ResponseEntity<List<Car>> getCarData() {
        log.info("Getting car data");
        List<Car> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Find car by ID", description = "Find a car by its ID")
    public ResponseEntity<Car> getCarById(@PathVariable Integer id) {
        log.info("Getting car with id: {}", id);
        Car car = carService.getCarById(id);
        if (car != null) {
            return new ResponseEntity<>(car, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @PostMapping
    @Operation(summary = "Add a new car", description = "Add a new car to the registry")
    public ResponseEntity<String> addCar(@RequestBody Car car) {
        log.info("Adding car: {}", car);
        carService.addCar(car);
        return new ResponseEntity<>("Car added successfully!", HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    @Operation(summary = "Update car by ID", description = "Update an existing car by its ID")
    public ResponseEntity<Car> updateCar(@PathVariable Integer id, @RequestBody Car car) {
        log.info("Updating car with id: {}", id);
        Car updatedCar = carService.updateCar(id, car);
        if (updatedCar != null) {
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete car by ID", description = "Delete an existing car by its ID")
    public ResponseEntity<String> deleteCar(@PathVariable Integer id) {
        log.info("Deleting car with id: {}", id);
        carService.deleteCar(id);
        return new ResponseEntity<>("Car deleted successfully!", HttpStatus.NO_CONTENT);
    }
}