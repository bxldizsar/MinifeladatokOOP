/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.feladat17;
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
public class RSSSource implements ContentSource {
    private String name;
    private String url;

    public RSSSource(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public List<News> load() {
        List<News> result = new ArrayList<>();
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // parse() can take the url directly and downloads it
            Document doc = builder.parse(url);
            NodeList items = doc.getElementsByTagName("item");

            for (int i = 0; i < items.getLength(); i++) {
                Element item = (Element) items.item(i);
                String title = getText(item, "title");
                String description = getText(item, "description");
                String link = getText(item, "link");

                // skip items with no title, News would throw for them anyway
                if (title == null || title.isBlank()) {
                    continue;
                }
                result.add(new News(title, description, name, link));
            }
        } catch (Exception e) {
            // dont crash the app, just return what we have (empty list)
            System.out.println("could not load rss from " + url + ": " + e.getMessage());
        }
        return result;
    }

    // gets the text of the first child tag, or null if its missing
    private String getText(Element parent, String tag) {
        NodeList list = parent.getElementsByTagName(tag);
        if (list.getLength() == 0) {
            return null;
        }
        return list.item(0).getTextContent();
    }
}
