/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.feladat31;

/**
 *
 * @author boldi
 */
public class Main 
{
    public static void main(String[] args) 
    {
        // good one
        Event ok = new Event("Hackathon", "24h coding", "hu", "2027-03-20 18:30:00", "Targu Mures");
        System.out.println("created: " + ok.getTitle() + " at " + ok.getLocation() + ", " + ok.getEventDateTime());

        // bad ones, each should throw
        tryToCreate("2026-13-40 18:30:00", "Targu Mures"); // month 13, day 40
        tryToCreate("20.03.2027", "Targu Mures");           // wrong format
        tryToCreate("2020-05-01 10:00:00", "Targu Mures");  // in the past
        tryToCreate("", "Targu Mures");                     // no date
        tryToCreate("2027-03-20 18:30:00", "   ");          // no location
    }

    // small helper so we dont write the same try catch 5 times
    private static void tryToCreate(String date, String location)
    {
        try 
        {
            new Event("Test event", "desc", "hu", date, location);
            System.out.println("created (this shouldnt happen)");
        } catch (IllegalArgumentException e) 
        {
            System.out.println("could not create event: " + e.getMessage());
        }
    }
}
