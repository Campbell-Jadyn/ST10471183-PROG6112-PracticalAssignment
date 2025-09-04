/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.series.car;

// Base class 

public class Car {
    public String CarId;
    public String CarMake;
    public String CarModel;
    public String RentalPricePerDay;
    public String AvailabilityStatus;
    
    // Constructor
    public  Car (String carId, String carMake, String carModel, String rentalPricePerDay, String availabilityStatus) {
        this.CarId = carId;
        this.CarMake = carMake;
        this.CarModel = carModel;
        this.RentalPricePerDay = rentalPricePerDay;
        this.AvailabilityStatus = availabilityStatus;
    }
    
    // Default constructor
    public Car () {
        this.CarId = "";
        this.CarMake = "";
        this.CarModel = "";
        this.RentalPricePerDay = "";
        this.AvailabilityStatus = "Available";
    }
}
