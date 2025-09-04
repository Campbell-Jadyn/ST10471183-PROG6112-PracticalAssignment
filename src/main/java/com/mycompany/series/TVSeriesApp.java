/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.series;

//import 
import java.util.Scanner;

public class TVSeriesApp {
    //main method now 
    public static void main(String [] args) {
    Series Manager = new Series () ;
    Scanner scan = new Scanner (System.in) ;
    int choice ;
    
    Manager.StartMenu();
    
    do {
    Manager.DisplayMenu() ; 
            
    try {
    choice = Integer.parseInt(scan.nextLine()) ;    
    
    switch (choice) {
        case 1: 
              Manager.CaptureSeries();
              break ;
              
        case 2:   
               Manager.SearchSeries() ;
               break ;
        case 3: 
              Manager.UpdateSeries() ;
              break ;
        case 4: 
              Manager.DeleteSeries() ;
              break ;
        case 5: 
              Manager.SeriesReport();
              break ;
        case 6: 
              Manager.ExitSeries();
              break ;
        default: 
              System.out.println("Invaild choice, please try again.");
    }//switch end 
    
    if (choice != 6) {
        System.out.println("Enter (1) to launch menu ");
        scan.nextLine() ;
    }//if end 
    
    } catch (NumberFormatException e) {
        System.out.println("Invaild choice, please enter a number between 1-6");
        choice = 0 ; //this will help the loop to continue
        System.out.println("\n Enter (1) to launch menu");
    }
    
    } while (choice != 6) ;
    
  scan.close(); 
}//end
}
