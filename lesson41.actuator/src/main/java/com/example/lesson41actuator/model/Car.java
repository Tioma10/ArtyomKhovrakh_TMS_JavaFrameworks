package com.example.lesson41actuator.model;

import jakarta.validation.constraints.NotBlank;

public class Car {
    private int id;

    @NotBlank(message = "Model is required")
    private String model;

    @NotBlank(message = "Brand is required")
    private String brand;

    public Car() {}

    public Car(int id, String model, String brand) {
        this.id = id;
        this.model = model;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}