/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kat
 */
public class EntriesCollectionTest {

    private EntriesCollection instance;
    private final int number = 5;

    private String title;
    private int orderNumber;
    private int points;
    private int commentsNumber;

    public EntriesCollectionTest() {
        this.instance = EntriesCollection.getInstance();

    }

    /**
     * Test of getInstance method, of class EntriesCollection.
     */
    @Test
    public void testGetInstanceIsCreated() {
        System.out.println("getInstance");
        EntriesCollection expResult = null;
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

    private void testData() {
        title = "";
        for (int i = 0; i < 10; i++) {

            // for (int x = 0; x < i; x++) 
            title += "title" + i + " ";

            points = i * 2;
            orderNumber = i;
            commentsNumber = 100 - i;

            instance.addEntry(new Entry.Builder()
                    .orderNumber(orderNumber)
                    .title(title)
                    .points(points)
                    .commentsNumber(commentsNumber)
                    .build());
            if (i == 10) {
                title = "";
            }
        }

    }
}
