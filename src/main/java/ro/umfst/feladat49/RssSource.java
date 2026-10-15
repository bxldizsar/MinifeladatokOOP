/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.feladat49;

/**
 *
 * @author boldi
 */
public class RssSource {
    private final String name;
    private final String url;
    private final String language;

    public RssSource(String name, String url, String language) 
    {
        if (name == null || name.isBlank()) 
        {
            throw new IllegalArgumentException("source name is required");
        }
        if (url == null || url.isBlank()) 
        {
            throw new IllegalArgumentException("url is required");
        }
        // simple check so we dont get "punctul.ro" or random text
        if (!url.startsWith("http://") && !url.startsWith("https://")) 
        {
            throw new IllegalArgumentException("url must start with http:// or https://");
        }
        if (language == null || language.isBlank()) 
        {
            throw new IllegalArgumentException("language is required");
        }
        this.name = name;
        this.url = url;
        this.language = language;
    }

    public String getName() 
    {
        return name; 
    }
    public String getUrl() 
    { 
        return url; 
    }
    public String getLanguage() 
    { 
        return language; 
    }

    @Override
    public String toString() 
    {
        return name + " (" + language + ") - " + url;
    }
}
