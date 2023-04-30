package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {
    @Test
    public void testConstructor() {
        String make = "Toyota";
        String model = "Corolla";
        int year = 2021;
        int mileage = 0;
        Car car = new Car(make, model, year, mileage);
        assertEquals(make, car.getMake());
        assertEquals(model, car.getModel());
        assertEquals(year, car.getYear());
        assertEquals(mileage, car.getMileage());
    }

    @Test
    public void testDrive() {
        int initialMileage = 10000;
        int milesDriven = 500;
        Car car = new Car("Honda", "Civic", 2018, initialMileage);
        car.drive(milesDriven);
        assertEquals(initialMileage + milesDriven, car.getMileage());
    }

    @Test
    public void testToString() {
        String make = "Toyota";
        String model = "Corolla";
        int year = 2021;
        int mileage = 10000;
        Car car = new Car(make, model, year, mileage);
        String expectedString = year + " " + make + " " + model + ", " + mileage + " miles";
        String actualString = car.toString();
        assertEquals(expectedString, actualString);
    }
}
