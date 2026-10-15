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
public interface ContentSource 
{
    // every source gives back a list of news, the caller doesnt care from where
    List<News> load();

}
