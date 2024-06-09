package com.vterroso.carregistry.repository;

import com.vterroso.carregistry.model.Car;

import java.util.List;

public interface CarRepository {
    List<Car> findAll();
    Car findById(Integer id);
    void save(Car car);
    void update(Car car);
    void deleteById(Integer id);
}
