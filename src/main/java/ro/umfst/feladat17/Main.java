/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.feladat17;
import java.util.List;
/**
 *
 * @author boldi
 */
public class Main {
    public static void main(String[] args) {
        ContentSource source = new MockSource();
        // only this line changes if we want another source:
        // source = new DatabaseSource("news.db");

        List<News> news = source.load();
        for (News n : news) {
            System.out.println(n.getSource() + " | " + n.getTitle());
        }
    }
}
