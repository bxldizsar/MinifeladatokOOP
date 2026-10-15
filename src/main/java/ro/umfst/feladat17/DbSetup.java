/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.feladat17;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author boldi
 */
public class DbSetup {
     // run this once to make a test db with some rows in it
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:news.db");
             Statement st = conn.createStatement()) {

            st.executeUpdate("CREATE TABLE IF NOT EXISTS news ("
                    + "title TEXT NOT NULL, "
                    + "description TEXT, "
                    + "source TEXT NOT NULL, "
                    + "url TEXT NOT NULL, "
                    + "PRIMARY KEY (source, url))");

            // INSERT OR IGNORE so running it twice doesnt give a duplicate key error
            st.executeUpdate("INSERT OR IGNORE INTO news VALUES "
                    + "('Db news 1', 'saved in sqlite', 'db', 'http://db.local/1')");
            st.executeUpdate("INSERT OR IGNORE INTO news VALUES "
                    + "('Db news 2', 'also from sqlite', 'db', 'http://db.local/2')");

            System.out.println("db ready");
        } catch (SQLException e) {
            System.out.println("setup failed: " + e.getMessage());
        }
    }
}
