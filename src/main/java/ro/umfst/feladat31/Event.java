/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.feladat31;
import java.sql.Timestamp;

/**
 *
 * @author boldi
 */
public class Event extends ContentItem 
{
    private final Timestamp eventDateTime;
    private final String location;

    public Event(String title, String description, String language,
                 String dateText, String location) 
    {
        // common fields are checked in ContentItem
        super(title, description, language);

        // 1. date not null
        if (dateText == null || dateText.isBlank()) 
        {
            throw new IllegalArgumentException("event date is required");
        }

        // 2. date format, valueOf throws a not very helpful exception so we wrap it
        Timestamp parsed;
        try 
        {
            parsed = Timestamp.valueOf(dateText.trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "wrong date format: \"" + dateText + "\", expected yyyy-mm-dd hh:mm:ss", e);
        }

        // 3. date has to be in the future
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (parsed.before(now)) {
            throw new IllegalArgumentException("event date must be in the future: " + dateText);
        }

        // 4. location not empty
        if (location == null || location.isBlank()) 
        {
            throw new IllegalArgumentException("location is required");
        }

        this.eventDateTime = parsed;
        this.location = location;
    }

    public Timestamp getEventDateTime() 
    {
        return eventDateTime; 
    }
    public String getLocation() 
    {
        return location; 
    }
}
