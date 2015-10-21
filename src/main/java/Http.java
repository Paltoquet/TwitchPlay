import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by thibault on 20/10/2015.
 */
public class Http {


    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public static String getDefinition(String URL){
        Document doc;
        try {
            doc = Jsoup.connect("http://www.larousse.fr/dictionnaires/francais/" + URL).get();
            Elements def=doc.getElementsByClass("Definitions");
            return def.text();
        }
        catch(Exception e){
            e.printStackTrace();
        }
       return null;
    }
}