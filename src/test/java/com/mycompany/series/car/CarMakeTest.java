/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.series.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarMakeTest {
    
    public CarMake carRental;
    
    @BeforeEach
    public void setUp() {
        
        carRental = new CarMake();
        // Add test data
        Car testCar1 = new Car("0001", "Toyota", "Camry", "75", "Available");
        Car testCar2 = new Car("0002", "Honda", "Civic", "65", "Rented");
        carRental.addCar(testCar1);
        carRental.addCar(testCar2);
    }
    
    @Test
    public void TestSearchCar() {
        // Test searching for an existing car
        Car result = carRental.SearchCar("0001");
        
        assertNotNull(result, "Car should be found");
        assertEquals("0001", result.CarId, "Car ID should match");
        assertEquals("Toyota", result.CarMake, "Car make should match");
        assertEquals("Camry", result.CarModel, "Car model should match");
        assertEquals("75", result.RentalPricePerDay, "Rental price should match");
        assertEquals("Available", result.AvailabilityStatus, "Availability status should match");
    }
    
    @Test
    public void TestSearchCar_CarNotFound() {
        // Test searching for a non-existing car
        Car result = carRental.SearchCar("999");
        
        assertNull(result, "Car should not be found");
    }
    
    @Test
    public void TestUpdateCar() {
        // Test updating an existing car
        boolean updateResult = carRental.UpdateCar("0001", "Toyota", "Corolla", "80", "Rented");
        
        assertTrue(updateResult, "Update should be successful");
        
        Car updatedCar = carRental.SearchCar("0001");
        assertEquals("Corolla", updatedCar.CarModel, "Car model should be updated");
        assertEquals("80", updatedCar.RentalPricePerDay, "Rental price should be updated");
        assertEquals("Rented", updatedCar.AvailabilityStatus, "Availability status should be updated");
    }
    
    @Test
    public void TestRemoveCar() {
        // Test removing an existing car
        boolean removeResult = carRental.RemoveCar("0001");
        
        assertTrue(removeResult, "Remove should be successful");
        
        Car removedCar = carRental.SearchCar("0001");
        assertNull(removedCar, "Car should no longer exist after removal");
    }
    
    @Test
    public void TestRemoveCar_CarNotFound() {
        // Test removing a non-existing car
        boolean removeResult = carRental.RemoveCar("9999");
        
        assertFalse(removeResult, "Remove should fail for non-existing car");
    }
    
    @Test
    public void TestCarRentalPrice_PriceValid() {
        // Test valid rental prices
        assertTrue(carRental.isValidRentalPrice("50"), "Price 50 should be valid");
        assertTrue(carRental.isValidRentalPrice("100"), "Price 100 should be valid");
        assertTrue(carRental.isValidRentalPrice("2000"), "Price 2000 should be valid");
        assertTrue(carRental.isValidRentalPrice("75.50"), "Price 75.50 should be valid");
    }
    
    @Test
    public void TestCarRentalPrice_PriceInvalid() {
        // Test invalid rental prices
        assertFalse(carRental.isValidRentalPrice("49"), "Price 49 should be invalid");
        assertFalse(carRental.isValidRentalPrice("2001"), "Price 2001 should be invalid");
        assertFalse(carRental.isValidRentalPrice("abc"), "Non-numeric price should be invalid");
        assertFalse(carRental.isValidRentalPrice(""), "Empty price should be invalid");
        assertFalse(carRental.isValidRentalPrice("-100"), "Negative price should be invalid");
    }
    
    @Test
    public void TestAvailabilityStatus_StatusValid() {
        // Test valid availability statuses
        assertTrue(carRental.isValidAvailabilityStatus("Available"), "Available should be valid");
        assertTrue(carRental.isValidAvailabilityStatus("Rented"), "Rented should be valid");
        assertTrue(carRental.isValidAvailabilityStatus("available"), "available (lowercase) should be valid");
        assertTrue(carRental.isValidAvailabilityStatus("RENTED"), "RENTED (uppercase) should be valid");
    }
    
    @Test
    public void TestAvailabilityStatus_StatusInvalid() {
        // Test invalid availability statuses
        assertFalse(carRental.isValidAvailabilityStatus("Maintenance"), "Maintenance should be invalid");
        assertFalse(carRental.isValidAvailabilityStatus("Sold"), "Sold should be invalid");
        assertFalse(carRental.isValidAvailabilityStatus(""), "Empty status should be invalid");
        assertFalse(carRental.isValidAvailabilityStatus("123"), "Numeric status should be invalid");
    }
    
    @Test
    public void TestCarList() {
        // Test that cars are properly stored and retrieved
        assertEquals(2, carRental.getCarList().size(), "Should have 2 cars initially");
        
        // Add a new car
        Car newCar = new Car("0003", "Ford", "Focus", "70", "Available");
        carRental.addCar(newCar);
        
        assertEquals(3, carRental.getCarList().size(), "Should have 3 cars after adding one");
        
        // Remove a car
        carRental.RemoveCar("0003");
        assertEquals(2, carRental.getCarList().size(), "Should have 2 cars after removing one");
    }
}
