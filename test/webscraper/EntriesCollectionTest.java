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
        //String title, int points, int orderNumber, int commentsNumber

        instance.addEntry("Test1", 1, 1, 3);
        instance.addEntry("Test2", 3, 2, 1);
        instance.displayEntries();

    }

    /**
     * Test of displayEntries method, of class EntriesCollection.
     */
    @Test
    public void testDisplayEntries() {
        System.out.println("*************************************");
        System.out.println("displayEntries");
        System.out.println("*************************************");
         instance.addEntry("Test1", 1, 1, 3);
        instance.addEntry("Test2", 3, 2, 1);
        instance.displayEntries();

    }

    /**
     * Test of ordeyByComments method, of class EntriesCollection.
     */
    @Test
    public void testOrdeyByComments() {
        System.out.println("*************************************");
        System.out.println("ordeyByComments");
        System.out.println("*************************************");
         instance.addEntry("Test1", 1, 1, 3);
        instance.addEntry("Test2", 3, 2, 1);
        instance.ordeyByComments();
        instance.displayEntries();

    }

    /**
     * Test of ordeyByPoints method, of class EntriesCollection.
     */
    @Test
    public void testOrdeyByPoints() {
        System.out.println("*************************************");
        System.out.println("ordeyByPoints");
        System.out.println("*************************************");
         instance.addEntry("Test1", 1, 1, 3);
        instance.addEntry("Test2", 3, 2, 1);
        instance.ordeyByPoints();
        instance.displayEntries();
    }

    /**
     * Test of FilterByTitleMoreThan method, of class EntriesCollection.
     */
    @Test
    public void testFilterByTitleMoreThan() {
        System.out.println("*************************************");
        System.out.println("FilterByTitleMoreThan");
        System.out.println("*************************************");

        //String title, int points, int orderNumber, int commentsNumber
        instance.addEntry("Test1 Test2 Test3 Test4 Test5 Test6", 1, 3, 3);
        instance.addEntry("Test1 Test2 Test3 Test4 Test5", 1, 4, 3);
         instance.addEntry("Test1", 1, 1, 3);
        instance.addEntry("Test2", 3, 2, 1);
        instance.FilterByTitleMoreThan(number);
        instance.displayEntries();

    }

    /**
     * Test of FilterByTitleLessThanOrEqual method, of class EntriesCollection.
     */
    @Test
    public void testFilterByTitleLessThanOrEqual() {
        System.out.println("*************************************");
        System.out.println("FilterByTitleLessThanOrEqual");
        System.out.println("*************************************");
        //String title, int points, int orderNumber, int commentsNumber
        instance.addEntry("Test1 Test2 Test3 Test4 Test5 Test6", 1, 5, 3);
        instance.addEntry("Test1 Test2 Test3 Test4 Test5", 1, 6, 3);
        instance.addEntry("Test2", 3, 7, 1);
        instance.FilterByTitleLessThanOrEqual(number);
        instance.displayEntries();
    }
}
