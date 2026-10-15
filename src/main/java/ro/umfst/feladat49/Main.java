/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.feladat49;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author boldi
 */
public class Main 
{
   public static void main(String[] args) 
   {
        // sources from RSS.JSON, the language is our addition
        List<RssSource> sources = new ArrayList<>();
        sources.add(new RssSource("Punctul", "https://punctul.ro/feed/", "ro"));
        sources.add(new RssSource("Radio Mures", "https://www.radiomures.ro/feed/", "ro"));
        sources.add(new RssSource("Vasarhely.ma", "https://www.vasarhely.ma/feed/", "hu"));
        sources.add(new RssSource("Marosvasarhelyi.info", "https://marosvasarhelyi.info/feed/", "hu"));

        for (RssSource s : sources) 
        {
            System.out.println(s);
        }

        // bad ones, each should throw
        tryToCreate("", "https://punctul.ro/feed/", "ro");
        tryToCreate("Punctul", "punctul.ro/feed/", "ro");
        tryToCreate("Punctul", "https://punctul.ro/feed/", " ");
    }

    // small helper so we dont write the same try catch 3 times
    private static void tryToCreate(String name, String url, String language) 
    {
        try 
        {
            new RssSource(name, url, language);
            System.out.println("created (this shouldnt happen)");
        } catch (IllegalArgumentException e) 
        {
            System.out.println("error: " + e.getMessage());
        }
    }
}
