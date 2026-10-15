/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.feladat17;
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
        // a few sources from RSS.JSON (in the real lab project these come from the json file)
        List<ContentSource> sources = new ArrayList<>();
        sources.add(new RSSSource("Punctul", "https://punctul.ro/feed/"));
        sources.add(new RSSSource("Vasarhely.ma", "https://www.vasarhely.ma/feed/"));
        sources.add(new RSSSource("Marosvasarhelyi.info", "https://marosvasarhelyi.info/feed/"));
        sources.add(new MockSource());
        // sources.add(new DatabaseSource("news.db"));  // turn on after running DbSetup

        // same call for every source, we dont care if its rss, db or mock
        for (ContentSource source : sources) {
            List<News> news = source.load();
            System.out.println("---- " + news.size() + " news ----");
            for (News n : news) {
                System.out.println(n.getSource() + " | " + n.getTitle());
            }
        }
    }
}
