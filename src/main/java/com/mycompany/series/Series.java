/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.series;

//Second class, methods will be made here 

//imports
import java.util.ArrayList ;
import java.util.Scanner ;


public class Series {
    ArrayList<SeriesModel> seriesList ;
    Scanner scan ;
 
// Constructor
public Series () {
this.seriesList = new ArrayList<>();
this.scan = new Scanner(System.in);
} //constructor 

//Start of menu 
public void StartMenu (){
System.out.println("LATEST SERIES - 2025");
        System.out.println("***********************************");
        System.out.println("Enter any key to launch menu: ");
        String StartMenu = scan.nextLine();
} //end 

//Start of display menu 
public void DisplayMenu (){
    System.out.println("-----------------------------------------");
    System.out.println("Please select one of the following menu items: ");
    System.out.println("1. Capture a new series ");
    System.out.println("2. Search for a series ");
    System.out.println("3. Update series age restriction ");
    System.out.println("4. Delete a series ");
    System.out.println("5. Print series report - 2025 ");
    System.out.println("6. Exit the application ");
    System.out.println("-------------------------------------------");
    System.out.println("Please enter a number (1-6): ");
} //end 

//Age restriction
//Start of capturing a series 
public void CaptureSeries (){
    System.out.println("-----------------------------------------");
    System.out.println("\n CAPTURE A NEW SERIES ");
    System.out.println("------------------------------------------");
    
    System.out.print("Enter Series ID: ");
    String seriesID = scan.nextLine() ; 
    
    // Checks if series ID already exists
        if (findSeriesID(seriesID) != null) {
            System.out.println("Series ID already exists!");
            return;
        }
        
        System.out.print("Enter Series Name: ");
        String seriesName = scan.nextLine() ;
        
        String seriesAge = getCorrectAgeRestriction ();
        
        System.out.print("Enter the number of episodes: ");
        String seriesNumberOfEpisodes = scan.nextLine() ;
        
        //if the user would like to add or create new series
        SeriesModel newSeries = new SeriesModel (seriesID, seriesName, seriesAge, seriesNumberOfEpisodes);
        seriesList.add(newSeries); 
        
        System.out.println("\n Series processed successfully!!! ");
}// end

public String getCorrectAgeRestriction () {

    String seriesAge;
    while (true) {
    System.out.print("Enter Age Restriction (2-18): ");
seriesAge = scan.nextLine();

    if (isCorrectAgeRestriction(seriesAge)) {
    break;
}//end if 
    else {
    if (!Number(seriesAge)){
    System.out.println("Incorrect age restriction, please try again ");
}//2 end if 
    else {
    System.out.println("Age restriction must be inbetween 2 and 18. ");
}//2 end else 
}//1 end else 
}//end while
   return seriesAge ;
}//end

 public boolean isCorrectAgeRestriction (String Age) {
       
    if (!Number(Age)) {
return false ;
}//if end 

int ageValue = Integer.parseInt(Age);
        return ageValue >= 2 && ageValue <= 18;
    }//end 


//Ensuring the String will convert into a number 
    public boolean Number(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }//end 
    
    //Help to find a series by using a the seriesID
    public SeriesModel findSeriesID(String seriesId) {
        for (SeriesModel series : seriesList) {
            if (series.seriesID.equals(seriesId)) {
                return series;
            }
        }
        return null;
    }//end 
  

//Search Series
    
//this will help search for the series ID
    public SeriesModel SearchSeries (String seriesID) {
    return findSeriesID(seriesID) ;
}//end 
    

//Search method
    public void SearchSeries (){
    System.out.println("-----------------------------------------");
    System.out.println("\n SEARCH FOR A SERIES ");
    System.out.println("------------------------------------------");    
    
        System.out.print("Enter a Series ID to search for: ");
        String seriesID = scan.nextLine();
        
        SeriesModel Series = findSeriesID(seriesID); 
        
        if (Series != null) {
            System.out.println("\n--- SERIES FOUND ---");
            ShowSeriesDetails(Series);
        } //if end 
        else {
            System.out.println("No series could be found for ID: " + seriesID);
        } //else end 
    
    }//end

    //method to how the series details
    public void ShowSeriesDetails (SeriesModel Series) {
        System.out.println("Series ID: " + Series.seriesID);
        System.out.println("Series Name: " + Series.seriesName);
        System.out.println("Age restriction: " + Series.seriesAge);
        System.out.println("Number of Episodes: " + Series.seriesNumberOfEpisodes);
    }//end
    
    
    
    //Update Series 
    //this is to update the series details 
    public boolean UpdateSeries (String seriesID, String newName, String newAge, String newEpisodes){
    SeriesModel Series = findSeriesID(seriesID);  
    
    if (Series != null) {
    Series.seriesName = newName ;
    Series.seriesAge = newAge ;
    Series.seriesNumberOfEpisodes = newEpisodes ;
    return true ;
    }
    return false ;
    } //end 
    
    //asking the user 
    public void UpdateSeries () {
    System.out.println("-----------------------------------------");
    System.out.println("\n UPDATE THE A SERIES ");
    System.out.println("------------------------------------------");
    
        System.out.print("Enter a Series ID to update: ");
        String seriesID = scan.nextLine() ;
    
        SeriesModel Series = findSeriesID(seriesID); 
        
        if (Series != null) {
            System.out.println("Current Series details: ");
            ShowSeriesDetails(Series);
            
            System.out.print("Enter the new Series details: ");
            String newName = scan.nextLine() ;
            
            String newAge = getCorrectAgeRestriction () ;
            
            System.out.print("Enter the new number of Episodes: ");
            String newEpisodes = scan.nextLine() ;
            
    Series.seriesName = newName ;
    Series.seriesAge = newAge ;
    Series.seriesNumberOfEpisodes = newEpisodes ;
    
    System.out.println("Series has been successfully updated ");
    }//if end 
        else {
            System.out.println("Series not found ");
        }
        }//end
    
    //Delete series
    
    public boolean DeleteSeries (String seriesID) {
    SeriesModel Series = findSeriesID(seriesID);
    if (Series != null) {
    seriesList.remove(Series) ;
    return true ;
    }//if end
    return false ;
    }//end
    
    //asking the user to delete the series 
    public void DeleteSeries() {
    System.out.println("-----------------------------------------");
    System.out.println("\n DELETE A SERIES ");
    System.out.println("------------------------------------------");
    
        System.out.print("Enter a Series ID to delete: ");
        String seriesID = scan.nextLine() ;
        
        SeriesModel Series = findSeriesID(seriesID);
        
        if (Series != null) {
            System.out.println("Name of series that is deleted: ");
            ShowSeriesDetails(Series);
            
            System.out.print("Would you like to delete this Series? (Yes/No): ");
            String answer = scan.nextLine() ;
            
            if (answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("YES")) {
            seriesList.remove(Series) ;
                System.out.println("Series has been successfully deleted ");
            }//2nd if end 
            else {
                System.out.println("Series has been deleted ");
            }//else end
            }//if end 
        else {
            System.out.println("Series is not found ");
        }//2nd else end 
       }//end 
        
    //make and show the series report 
    public void SeriesReport () {
    System.out.println("-----------------------------------------");
    System.out.println("\n TV SERIES REPORT - 2025 ");
    System.out.println("------------------------------------------");
    
           if (seriesList.isEmpty ()) {
               System.out.println("Series data is unavailable. ");
           }//if end    
           else {
               System.out.printf("%-10s %-20s %-5s %-10s %n", "ID", "Name", "Age", "Episodes");
               System.out.println("---------------------------------------------");
           
               for (SeriesModel Series : seriesList) {
                   System.out.printf("%-10s %-20s %-5s %-10s %n", Series.seriesID, Series.seriesName, Series.seriesAge, Series.seriesNumberOfEpisodes);
               }//2nd if end 
           }//else end 
        System.out.println("---------------------------------------------------");
        
    }//end 
        
    
    //creating the choose to exit the application 
    public void ExitSeries (){
        System.out.println("Thank you for using the TV Series System!");
        System.out.println("Goodbye.");
        scan.close();
    }//end 
    
    //test purpose 
    public ArrayList<SeriesModel> getSeriesList () {
    return seriesList ;
    }//end
    
    //test purpose
    public void addSeries(SeriesModel series) {
    seriesList.add(series);
    }//end
    
}//end of file 