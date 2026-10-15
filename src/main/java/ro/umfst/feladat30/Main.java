/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.feladat30;

/**
 *
 * @author boldi
 */
public class Main {
    public static void main(String[] args) {
        // good one, author, publisher, language and image are missing but thats fine
        News ok = new News("New park in the city", "the council approved it", null, null,
                "BBC", "http://bbc.com/1", null, null);
        System.out.println("created: " + ok.getTitle());
        System.out.println("language: " + ok.getLanguage());
        System.out.println("author: " + ok.getAuthor());
        System.out.println("cover image: " + ok.getCoverImage());

        // bad ones, each should throw
        tryToCreate("", "BBC", "http://bbc.com/2");
        tryToCreate("Some title", null, "http://bbc.com/3");
        tryToCreate("Some title", "BBC", "   ");
    }

    // small helper so we dont write the same try catch 3 times
    private static void tryToCreate(String title, String source, String url) {
        try {
            new News(title, "desc", null, null, source, url, "en", null);
            System.out.println("created (this shouldnt happen)");
        } catch (IllegalArgumentException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
