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
public class MockSource implements ContentSource
{
    @Override
    public List<News> load()
    {
        // fixed data so tests always give the same result
        List<News> list = new ArrayList<>();
        list.add(new News("Test news 1", "first test description", "mock", "http://test.local/1"));
        list.add(new News("Test news 2", "second test description", "mock", "http://test.local/2"));
        return list;
    }
}
