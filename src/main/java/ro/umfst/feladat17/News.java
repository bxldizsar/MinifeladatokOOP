/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.feladat17;

/**
 *
 * @author boldi
 */
public class News 
{
    private String title;
    private String description;
    private String source;
    private String url;

    public News(String title, String description, String source, String url) 
    {
        // title is the only thing we really cant live without
        if (title == null || title.isBlank()) 
        {
            throw new IllegalArgumentException("title is required");
        }
        this.title = title;
        this.description = description;
        this.source = source;
        this.url = url;
    }

    public String getTitle() 
    { 
        return title;
    }
    public String getDescription() 
    { 
        return description;
    }
    public String getSource() 
    { 
        return source; 
    }
    public String getUrl() 
    { 
        return url;
    }
}
