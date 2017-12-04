/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper;

import controller.Configuration;
import controller.DataExtractor;
import model.Collection;
import model.ArrayArticles;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kat
 */
public class DataExtractorTest {

    private String html = "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"itemlist\">\n"
            + "              <tr class='athing' id='15832516'>\n"
            + "<tr class='athing' id='15819093'>\n"
            + "    <td align=\"right\" valign=\"top\" class=\"title\"><span class=\"rank\">1.</span></td>\n"
            + "    <td valign=\"top\" class=\"votelinks\">\n"
            + "        <center>\n"
            + "            <a id='up_15819093' href='vote?id=15819093&amp;how=up&amp;goto=news'>\n"
            + "                <div class='votearrow' title='upvote'></div>\n"
            + "            </a>\n"
            + "        </center>\n"
            + "    </td>\n"
            + "    <td class=\"title\"><a href=\"http://blog.system76.com/post/168050597573/system76-me-firmware-updates-plan\" class=\"storylink\">System76 ME Firmware Updates Plan</a><span class=\"sitebit comhead\"> (<a href=\"from?site=system76.com\"><span class=\"sitestr\">system76.com</span></a>)</span>\n"
            + "    </td>\n"
            + "</tr>\n"
            + "<tr>\n"
            + "    <td colspan=\"2\"></td>\n"
            + "    <td class=\"subtext\">\n"
            + "        <span class=\"score\" id=\"score_15819093\">501 points</span> by <a href=\"user?id=jcastro\" class=\"hnuser\">jcastro</a>\n"
            + "        <span class=\"age\"><a href=\"item?id=15819093\">8 hours ago</a></span>\n"
            + "        <span id=\"unv_15819093\"></span> | <a href=\"hide?id=15819093&amp;goto=news\">hide</a> | <a href=\"item?id=15819093\">177&nbsp;comments</a>\n"
            + "    </td>\n"
            + "</tr>\n"
            + "<tr class=\"spacer\" style=\"height:5px\"></tr>\n"
            + "</table>";

    public DataExtractorTest() {
    }

    /**
     * Test of getUrlCodeAsString method, of class DataExtractor.
     */
    @Test
    public void testGetUrlCodeAsStringHasSucceded() {
        System.out.println("getUrlCodeAsString");
        String url = "https://news.ycombinator.com/";
        boolean expResult = true;
        String result = DataExtractor.getUrlCodeAsString(url);
        assertEquals(expResult, DataExtractor.hasExtradtedCode(result));
        Collection collection;
    }

    /**
     * Test of getUrlCodeAsString method, of class DataExtractor.
     */
    @Test
    public void testGetUrlCodeAsStringHasFailed() {
        System.out.println("getUrlCodeAsString");
        String url = "https://newsycombinatorcom/";
        boolean expResult = false;
        String result = DataExtractor.getUrlCodeAsString(url);
        assertEquals(expResult, DataExtractor.hasExtradtedCode(result));

    }

    /**
     * Test of extractData method, of class DataExtractor.
     */
    @Test
    public void testExtractDataHasSucceded() {
        System.out.println("extractData");

        int numberOfEntries = 30;

        boolean expResult = true;

        Collection result = DataExtractor
                .extractData(html, Configuration.numberOfEntries, Configuration.item, ArrayArticles.getInstance());
        assertEquals(expResult, result.hasEntries());

    }

    public void testExtractDataHasFailed() {
        System.out.println("extractData");

        int numberOfEntries = 30;

        boolean expResult = true;

        Collection result = DataExtractor
                .extractData("", Configuration.numberOfEntries, Configuration.item, ArrayArticles.getInstance());
        assertEquals(expResult, result.hasEntries());

    }

}
