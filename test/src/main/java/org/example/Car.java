package org.example;

public class Car {
    private final String make;
    private final String model;
    private final int year;
    private int mileage;

    public Car(String make, String model, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public void drive(int miles) {
        mileage += miles;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model + ", " + mileage + " miles";
    }
}

