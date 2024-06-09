package com.vterroso.carregistry.controller;

import com.vterroso.carregistry.model.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CarController {
    ResponseEntity<List<Car>> getCarData();
    ResponseEntity<Car> getCarById(@PathVariable Integer id);
    ResponseEntity<String> addCar(@RequestBody Car car);
    ResponseEntity<Car> updateCar(@PathVariable Integer id, @RequestBody Car car);
    ResponseEntity<String> deleteCar(@PathVariable Integer id);
}
