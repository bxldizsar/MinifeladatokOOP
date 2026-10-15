/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.feladat31;

/**
 *
 * @author boldi
 */
public class ContentItem 
{
    private final String title;
    private final String description;
    private final String language;

    public ContentItem(String title, String description, String language) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title is required");
        }
        this.title = title;
        this.description = description;
        this.language = language;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getLanguage() { return language; }
}
