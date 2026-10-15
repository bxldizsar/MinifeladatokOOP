/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.feladat17;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
/**
 *
 * @author boldi
 */
public class RSSSource implements ContentSource 
{
    private final String name;
    private final String url;

    public RSSSource(String name, String url) 
    {
        this.name = name;
        this.url = url;
    }

    @Override
    public List<News> load() 
    {
        List<News> result = new ArrayList<>();
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            // timeout is a lab requirement, so a dead site cant freeze us forever
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            if (status != 200) 
            {
                System.out.println(name + ": feed not available, http status " + status);
                return result;
            }

            try (InputStream input = connection.getInputStream()) 
            {
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document doc = builder.parse(input);
                NodeList items = doc.getElementsByTagName("item");

                for (int i = 0; i < items.getLength(); i++)
                {
                    Element item = (Element) items.item(i);
                    String title = getText(item, "title");
                    // skip items with no title, News would throw for them anyway
                    if (title == null || title.isBlank())
                    {
                        continue;
                    }
                    result.add(new News(title, getText(item, "description"), name, getText(item, "link")));
                }
            }
        } catch (Exception e) 
        {
            // dont crash the app, just return what we have
            System.out.println(name + ": could not load rss: " + e.getMessage());
        } finally 
        {
            if (connection != null) 
            {
                connection.disconnect();
            }
        }
        return result;
    }

    // gets the text of the first child tag, or null if its missing
    private String getText(Element parent, String tag) {
        NodeList list = parent.getElementsByTagName(tag);
        if (list.getLength() == 0) 
        {
            return null;
        }
        return list.item(0).getTextContent();
    }
}
