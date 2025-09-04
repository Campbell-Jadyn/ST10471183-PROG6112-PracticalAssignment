/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.series.car;

//1st subclass 
// CarRental.java
import java.util.ArrayList;
import java.util.Scanner;

public class CarMake extends Car {
    public ArrayList<Car> carList;
    public Scanner scanner;
    
    // Constructor
    public CarMake () {
        this.carList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    // Display main menu
    public void displayMenu() {
        System.out.println("=====================================");
        System.out.println("       CAR RENTAL MANAGEMENT");
        System.out.println("=====================================");
        System.out.println("1. Add a new Car");
        System.out.println("2. Search for a Car");
        System.out.println("3. Update Car details");
        System.out.println("4. Remove a Car");
        System.out.println("5. Display Car Report");
        System.out.println("6. Exit Application");
        System.out.println("=====================================");
        System.out.print("Enter your choice (1-6): ");
    }
    
    // Add a new car
    public void AddCar() {
        System.out.println("\n--- ADD NEW CAR ---");
        
        System.out.print("Enter Car ID: ");
        String carId = scanner.nextLine();
        
        // Check if car ID already exists
        if (findCarById(carId) != null) {
            System.out.println("Car ID already exists!");
            return;
        }
        
        System.out.print("Enter Car Make: ");
        String carMake = scanner.nextLine();
        
        System.out.print("Enter Car Model: ");
        String carModel = scanner.nextLine();
        
        String rentalPrice = getValidRentalPrice();
        
        System.out.print("Enter Status (Available/Rented): ");
        String availabilityStatus = getValidAvailabilityStatus();
        
        // Create and add new car
        Car newCar = new Car(carId, carMake, carModel, rentalPrice, availabilityStatus);
        carList.add(newCar);
        
        System.out.println("\nCar details have been successfully saved!");
    }
    
    // Get valid rental price with validation
    public String getValidRentalPrice() {
        String rentalPrice;
        while (true) {
            System.out.print("Enter Rental Price (50-2000): ");
            rentalPrice = scanner.nextLine();
            
            if (isValidRentalPrice(rentalPrice)) {
                break;
            } else {
                if (!isNumeric(rentalPrice)) {
                    System.out.println("Please enter a valid number for rental price.");
                } else {
                    System.out.println("Rental price must be between 50 and 2000.");
                }
            }
        }
        return rentalPrice;
    }
    
    // Get valid availability status
    public String getValidAvailabilityStatus() {
        String status;
        while (true) {
            status = scanner.nextLine();
            if (isValidAvailabilityStatus(status)) {
                break;
            } else {
                System.out.println("Please enter 'Available' or 'Rented'.");
                System.out.print("Enter Status (Available/Rented): ");
            }
        }
        return status;
    }
    
    // Validate rental price
    public boolean isValidRentalPrice(String price) {
        if (!isNumeric(price)) {
            return false;
        }
        
        double priceValue = Double.parseDouble(price);
        return priceValue >= 50 && priceValue <= 2000;
    }
    
    // Validate availability status
    public boolean isValidAvailabilityStatus(String status) {
        return status.equalsIgnoreCase("Available") || status.equalsIgnoreCase("Rented");
    }
    
    // Check if string is numeric
    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // Search for a car by ID
    public Car SearchCar(String carId) {
        return findCarById(carId);
    }
    
    // Interactive search method
    public void interactiveSearchCar() {
        System.out.println("\n--- SEARCH CAR ---");
        System.out.print("Enter Car ID to search: ");
        String carId = scanner.nextLine();
        
        Car car = findCarById(carId);
        
        if (car != null) {
            System.out.println("\n--- CAR FOUND ---");
            displayCarDetails(car);
        } else {
            System.out.println("No car data could be found for ID: " + carId);
        }
    }
    
    // Update car details
    public boolean UpdateCar(String carId, String newMake, String newModel, String newPrice, String newStatus) {
        Car car = findCarById(carId);
        if (car != null) {
            car.CarMake = newMake;
            car.CarModel = newModel;
            car.RentalPricePerDay = newPrice;
            car.AvailabilityStatus = newStatus;
            return true;
        }
        return false;
    }
    
    // Interactive update method
    public void interactiveUpdateCar() {
        System.out.println("\n--- UPDATE CAR ---");
        System.out.print("Enter Car ID to update: ");
        String carId = scanner.nextLine();
        
        Car car = findCarById(carId);
        
        if (car != null) {
            System.out.println("Current Car Details:");
            displayCarDetails(car);
            
            System.out.print("Enter new Car Make: ");
            String newMake = scanner.nextLine();
            
            System.out.print("Enter new Car Model: ");
            String newModel = scanner.nextLine();
            
            String newPrice = getValidRentalPrice();
            
            System.out.print("Enter new Availability Status (Available/Rented): ");
            String newStatus = getValidAvailabilityStatus();
            
            car.CarMake = newMake;
            car.CarModel = newModel;
            car.RentalPricePerDay = newPrice;
            car.AvailabilityStatus = newStatus;
            
            System.out.println("Car updated successfully!");
        } else {
            System.out.println("Car not found!");
        }
    }
    
    // Remove car
    public boolean RemoveCar(String carId) {
        Car car = findCarById(carId);
        if (car != null) {
            carList.remove(car);
            return true;
        }
        return false;
    }
    
    // Interactive remove method
    public void interactiveRemoveCar() {
        System.out.println("\n--- REMOVE CAR ---");
        System.out.print("Enter Car ID to remove: ");
        String carId = scanner.nextLine();
        
        Car car = findCarById(carId);
        
        if (car != null) {
            System.out.println("Car to be removed:");
            displayCarDetails(car);
            
            System.out.print("Are you sure you want to remove this car? (Yes/No): ");
            String confirmation = scanner.nextLine();
            
            if (confirmation.equalsIgnoreCase("Y") || confirmation.equalsIgnoreCase("YES")) {
                carList.remove(car);
                System.out.println("Car removed successfully!");
            } else {
                System.out.println("Remove operation cancelled.");
            }
        } else {
            System.out.println("Car not found!");
        }
    }
    
    // Generate and display car report
    public void CarReport() {
        System.out.println("\n--- CAR RENTAL REPORT ---");
        System.out.println("=====================================");
        
        if (carList.isEmpty()) {
            System.out.println("No car data available.");
        } else {
            System.out.printf("%-8s %-12s %-15s %-8s %-12s%n", "ID", "Make", "Model", "Price", "Status");
            System.out.println("-----------------------------------------------------");
            
            for (Car car : carList) {
                System.out.printf("%-8s %-12s %-15s %-8s %-12s%n", 
                    car.CarId, 
                    car.CarMake, 
                    car.CarModel, 
                    "R" + car.RentalPricePerDay, 
                    car.AvailabilityStatus);
            }
            
            // Display summary statistics
            int totalCars = carList.size();
            int availableCars = 0;
            int rentedCars = 0;
            double totalRevenue = 0.0;
            
            for (Car car : carList) {
                if (car.AvailabilityStatus.equalsIgnoreCase("Available")) {
                    availableCars++;
                } else {
                    rentedCars++;
                    totalRevenue += Double.parseDouble(car.RentalPricePerDay);
                }
            }
            
            System.out.println("-----------------------------------------------------");
            System.out.println("SUMMARY:");
            System.out.println("Total Cars: " + totalCars);
            System.out.println("Available Cars: " + availableCars);
            System.out.println("Rented Cars: " + rentedCars);
            System.out.println("Daily Revenue from Rented Cars: R" + String.format("%.2f", totalRevenue));
        }
        System.out.println("=====================================");
    }
    
    // Exit application
    public void ExitCarRentalApplication() {
        System.out.println("Thank you for using Car Rental Management System!");
        System.out.println("Goodbye!");
        scanner.close();
    }
    
    // Helper method to find car by ID
    public Car findCarById(String carId) {
        for (Car car : carList) {
            if (car.CarId.equals(carId)) {
                return car;
            }
        }
        return null;
    }
    
    // Helper method to display car details
    public void displayCarDetails(Car car) {
        System.out.println("Car ID: " + car.CarId);
        System.out.println("Car Make: " + car.CarMake);
        System.out.println("Car Model: " + car.CarModel);
        System.out.println("Rental Price Per Day: R" + car.RentalPricePerDay);
        System.out.println("Availability Status: " + car.AvailabilityStatus);
    }
    
    // Getter for car list (for testing purposes)
    public ArrayList<Car> getCarList() {
        return carList;
    }
    
    // Add car method (for testing purposes)
    public void addCar(Car car) {
        carList.add(car);
    }
}