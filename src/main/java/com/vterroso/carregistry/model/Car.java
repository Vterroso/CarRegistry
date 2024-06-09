package com.vterroso.carregistry.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Car {
    @Schema(description = "Unique identifier of the car")
    private Integer id;
    @Schema(description = "Brand of the car")
    private String brand;
    @Schema(description = "Model of the car")
    private String model;
    @Schema(description = "Mileage of the car")
    private Integer mileage;
    @Schema(description = "Price of the car")
    private Double price;
    @Schema(description = "Year of the car")
    private Integer year;
    @Schema(description = "Description of the car")
    private String description;
    @Schema(description = "Color of the car")
    private String color;
    @Schema(description = "Fuel type of the car")
    private String fuelType;
    @Schema(description = "Number of doors of the car")
    private Integer numDoors;
}