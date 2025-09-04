/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.series.car;

//Main Class

//imports
import java.util.Scanner;

public class MainClass {
    
    public static void main(String[] args) {
        CarMake carRentalManager = new CarMake();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        System.out.println("Welcome to Car Rental Management System!");
        System.out.println("Loading system...\n");
        
        do {
            carRentalManager.displayMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        carRentalManager.AddCar();
                        break;
                    case 2:
                        carRentalManager.interactiveSearchCar();
                        break;
                    case 3:
                        carRentalManager.interactiveUpdateCar();
                        break;
                    case 4:
                        carRentalManager.interactiveRemoveCar();
                        break;
                    case 5:
                        carRentalManager.CarReport();
                        break;
                    case 6:
                        carRentalManager.ExitCarRentalApplication();
                        break;
                    default:
                        System.out.println("Invalid choice! Please select 1-6.");
                }
                
                if (choice != 6) {
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1-6.");
                choice = 0; // Continue loop
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
            
        } while (choice != 6);
        
        scanner.close();
    }
}
