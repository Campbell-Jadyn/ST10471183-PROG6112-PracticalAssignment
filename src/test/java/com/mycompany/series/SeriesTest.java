/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.series;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class SeriesTest {
 public Series series ;

@BeforeEach 
public void Start () {
series = new Series ();

SeriesModel test1 = new SeriesModel ("0001", "Bones", "16", "62");
SeriesModel test2 = new SeriesModel ("0002", "Stranger Things", "14", "42") ;

series.addSeries(test1) ;
series.addSeries(test2);
}

@Test
public void TestSearchSeries () {

SeriesModel result = series.SearchSeries("0001") ;

assertNotNull(result, "Series should be found") ;
assertEquals("0001", result.seriesID, "Series ID should match") ;
assertEquals("Bones", result.seriesName, "Series name should match") ;
assertEquals("16", result.seriesAge, "Series age should match");
assertEquals("62", result.seriesNumberOfEpisodes, "NUmber of episodes should match") ;
}
        
@Test 
public void TestSearchSeries_SeriesNotFound () {

SeriesModel result = series.SearchSeries("999") ;
assertNull(result, "Series should not be found") ;
}

@Test
public void TestUpdateSeries () {

boolean UpdateResults = series.UpdateSeries("0001", "Bones","18","65") ;
assertTrue(UpdateResults, "Update should be successfully");

SeriesModel Results = series.SearchSeries("0001") ;
assertEquals("Bones Updated", Results.seriesName, "Series name should be updated") ;
assertEquals("18", Results.seriesAge, "Series age should be updated");
assertEquals("65", Results.seriesNumberOfEpisodes, "Number of episodes should be updated");
}

@Test
    public void TestDeleteSeries() {
        // Test deleting an existing series
        boolean deleteResult = series.DeleteSeries("0001");
        
        assertTrue(deleteResult, "Delete should be successful");
        
        SeriesModel deletedSeries = series.SearchSeries("0001");
        assertNull(deletedSeries, "Series should no longer exist after deletion");
    }
    
    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        // Test deleting a non-existing series
        boolean deleteResult = series.DeleteSeries("999");
        
        assertFalse(deleteResult, "Delete should fail for non-existing series");
    }
    
    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        // Test valid age restrictions
        assertTrue(series.isCorrectAgeRestriction("2"), "Age 2 should be valid");
        assertTrue(series.isCorrectAgeRestriction("10"), "Age 10 should be valid");
        assertTrue(series.isCorrectAgeRestriction("18"), "Age 18 should be valid");
    }
    
    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        // Test invalid age restrictions
        assertFalse(series.isCorrectAgeRestriction("1"), "Age 1 should be invalid");
        assertFalse(series.isCorrectAgeRestriction("19"), "Age 19 should be invalid");
        assertFalse(series.isCorrectAgeRestriction("abc"), "Non-numeric age should be invalid");
        assertFalse(series.isCorrectAgeRestriction(""), "Empty age should be invalid");
        assertFalse(series.isCorrectAgeRestriction("-5"), "Negative age should be invalid");
    }


}//end 



