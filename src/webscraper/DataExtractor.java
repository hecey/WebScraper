/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author kat
 */
public class DataExtractor {

    public static String getUrlCodeAsString(String url) {
        URL urlObj = null;
        try {
            urlObj = new URL(url);
        } catch (MalformedURLException e) {

            return "The url was malformed!";
        }

        URLConnection urlCon = null;
        BufferedReader in = null;
        String outputText = "";
        try {
            urlCon = urlObj.openConnection();
            in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            String line = "";
            while ((line = in.readLine()) != null) {
                outputText += line;
            }
            in.close();
        } catch (IOException e) {
            return "There was an error connecting to the URL";
        }
        return outputText;
    }

    public static boolean hasExtradtedCode(String html) {
        if (html.startsWith("The url was malformed")
                || html.startsWith("There was an error connecting to the URL")) {
            System.out.println(html);
            return false;
        }
        return true;
    }

    private static int extractNumberFromText(String text) {
        int spaceIndex = text.indexOf(" ");
        String numberExtracted = text.substring(0, spaceIndex);
        if (NumberUtils.isCreatable(numberExtracted)) {
            return Integer.valueOf(numberExtracted);
        } else {
            return 0;
        }
    }

    private static int extractOrderNumber(String text) {

        text = text.substring(0, text.length() - 1);
        return Integer.valueOf(text);
    }

    public static EntriesCollection extractData(String html, int numberOfEntries) {
        Document doc = Jsoup.parse(html);
        Elements entriesExtracted = doc.select("table.itemlist tr");
        int numberOfEntriesObtained = 0;
        String title = "";
        int points = 0;
        int orderNumber = 0;
        int commentsNumber = 0;

        EntriesCollection entriesCollection = EntriesCollection.getInstance();
        int tdCount = 0;
        for (Element element : entriesExtracted) {
            tdCount++;
            //Obtain orderNumber
            if (element.selectFirst("td.title") != null
                    && NumberUtils.isCreatable(element.selectFirst("td.title").text())) {

                orderNumber = extractOrderNumber(element.selectFirst("td.title").text());
            }
            //Obtain title
            if (element.selectFirst("a.storylink") != null) {
                title = element.selectFirst("a.storylink").text();

            }
            //Obtain points
            if (element.selectFirst("span.score") != null) {
                points = extractNumberFromText(element.selectFirst("span.score").text());

            }
            //Obtain commentsNumber
            if (element.selectFirst("a:contains(comments)") != null) {
                commentsNumber = extractNumberFromText(element.selectFirst("a:contains(comments)").text());

            }
            
            if (element.text().equals("")) {

                entriesCollection.addEntry(title, points, orderNumber, commentsNumber);
                title="";
                points=0;
                orderNumber=0;
                commentsNumber=0;
                numberOfEntriesObtained++;

                if (numberOfEntriesObtained + 1 > numberOfEntries) {
                    break;
                }
            }
        }

        return entriesCollection;
    }
}
