/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.feladat17;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author boldi
 */

public class DatabaseSource implements ContentSource 
{
    private String dbPath;

    public DatabaseSource(String dbPath) 
    {
        this.dbPath = dbPath;
    }

    @Override
    public List<News> load() 
    {
        List<News> result = new ArrayList<>();
        String sql = "SELECT title, description, source, url FROM news";

        // try-with-resources closes everything for us
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) 
        {

            while (rs.next()) 
            {
                result.add(new News(
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("source"),
                        rs.getString("url")));
            }
        } catch (SQLException e) 
        {
            System.out.println("db error: " + e.getMessage());
        }
        return result;
    }
}