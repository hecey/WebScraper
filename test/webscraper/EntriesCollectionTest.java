/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper;

import model.Builder;
import model.Article;
import model.ArrayArticles;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kat
 */
public class EntriesCollectionTest {

    private ArrayArticles instance;
    private final int number = 5;

    private String title;
    private int orderNumber;
    private int points;
    private int commentsNumber;

    public EntriesCollectionTest() {
        this.instance = ArrayArticles.getInstance();

    }

    /**
     * Test of getInstance method, of class EntriesCollection.
     */
    @Test
    public void testGetInstanceIsCreated() {
        System.out.println("getInstance");
        ArrayArticles expResult = null;
        assertNotEquals(expResult, instance);

    }

    /**
     * Test of addEntry method, of class EntriesCollection.
     */
    @Test
    public void testAddEntry() {
        System.out.println("addEntry");
        testData();

        instance.displayEntries();
        instance.removeAllEntries();
    }

    /**
     * Test of displayEntries method, of class EntriesCollection.
     */
    @Test
    public void testDisplayEntries() {
        System.out.println("*************************************");
        System.out.println("displayEntries");
        System.out.println("*************************************");
        testData();

        instance.displayEntries();
        instance.removeAllEntries();
    }

    /**
     * Test of ordeyByComments method, of class EntriesCollection.
     */
    @Test
    public void testOrdeyByComments() {
        System.out.println("*************************************");
        System.out.println("ordeyByComments");
        System.out.println("*************************************");
        testData();
        instance.ordeyByComments();
        instance.displayEntries();
        instance.removeAllEntries();
    }

    /**
     * Test of ordeyByPoints method, of class EntriesCollection.
     */
    @Test
    public void testOrdeyByPoints() {
        System.out.println("*************************************");
        System.out.println("ordeyByPoints");
        System.out.println("*************************************");
        testData();
        instance.ordeyByPoints();
        instance.displayEntries();
        instance.removeAllEntries();
    }

    /**
     * Test of FilterByTitleMoreThan method, of class EntriesCollection.
     */
    @Test
    public void testFilterByTitleMoreThan() {
        System.out.println("*************************************");
        System.out.println("FilterByTitleMoreThan");
        System.out.println("*************************************");

        testData();
        instance.FilterByTitleMoreThan(number);
        instance.displayEntries();
        instance.removeAllEntries();
    }

    /**
     * Test of FilterByTitleLessThanOrEqual method, of class EntriesCollection.
     */
    @Test
    public void testFilterByTitleLessThanOrEqual() {
        System.out.println("*************************************");
        System.out.println("FilterByTitleLessThanOrEqual");
        System.out.println("*************************************");

        testData();
        instance.FilterByTitleLessThanOrEqual(number);
        instance.displayEntries();
        instance.removeAllEntries();
    }

    /**
     * Test of FilterByTitleLessThanOrEqualOrderbyPoinst method, of class EntriesCollection.
     */
    @Test
    public void testFilterByTitleLessThanOrEqualOrderbyPoinst() {
        System.out.println("*************************************");
        System.out.println("testFilterByTitleLessThanOrEqualOrderbyPoinst");
        System.out.println("*************************************");

        testData();
        instance.FilterByTitleLessThanOrEqual(number).ordeyByPoints().displayEntries();
        instance.removeAllEntries();
    }
    
    /**
     * Test of FilterByTitleMoreThanOrderbyComments method, of class EntriesCollection.
     */
    @Test
    public void testFilterByTitleMoreThanOrderbyComments() {
        System.out.println("*************************************");
        System.out.println("testFilterByTitleMoreThanOrderbyComments");
        System.out.println("*************************************");

        testData();
        instance.FilterByTitleMoreThan(number).ordeyByComments().displayEntries();
        instance.removeAllEntries();
    }
    
    private void testData() {
        title = "";
        int numberofEntries= 30;
        for (int i = 0; i < numberofEntries; i++) {

            // for (int x = 0; x < i; x++) 
            title += "title" + i + " ";

            points = i * 2;
            orderNumber = i;
            commentsNumber = 100 - i;

            instance.addEntry(
                    Builder.build(Article.class)
                            .setter(p -> p.setTitle(title))
                            .setter(p -> p.setOrderNumber(orderNumber))
                            .setter(p -> p.setPoints(points))
                            .setter(p -> p.setCommentsNumber(commentsNumber))
                            .get());
            
            if (i == 10) {
                title = "";
            }
        }

    }
}
