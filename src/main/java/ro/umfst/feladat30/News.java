/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.feladat30;

/**
 *
 * @author boldi
 */
public class News {
    private final String title;
    private final String description;
    private final String author;
    private final String publisher;
    private final String source;
    private final String url;
    private final String language;
    private final String coverImage;

    public News(String title, String description, String author, String publisher,
                String source, String url, String language, String coverImage) {
        // required fields
        if (isEmpty(title)) {
            throw new IllegalArgumentException("title is required");
        }
        // source + url is the primary key in the db, so both are needed
        if (isEmpty(source)) {
            throw new IllegalArgumentException("source is required");
        }
        if (isEmpty(url)) {
            throw new IllegalArgumentException("url is required");
        }

        this.title = title;
        this.description = description;
        this.author = author;       // can be null, a lot of feeds dont have it
        this.publisher = publisher; // same here
        this.source = source;
        this.url = url;

        // no language given -> "unknown" so the ui doesnt show null
        if (isEmpty(language)) {
            this.language = "unknown";
        } else {
            this.language = language;
        }

        // can be null, the default image is handled by CoverImageResolver not here
        this.coverImage = coverImage;
    }

    private static boolean isEmpty(String s) {
        return s == null || s.isBlank();
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }
    public String getSource() { return source; }
    public String getUrl() { return url; }
    public String getLanguage() { return language; }
    public String getCoverImage() { return coverImage; }
}
