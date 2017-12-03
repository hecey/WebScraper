/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kat
 */
public class EntryTest {

    String title = "Test Title";
    int orderNumber = 1;
    int points = 4;
    int comments = 5;
    Entry instance;

    public EntryTest() {
        instance = new Entry(title, points, orderNumber, comments);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getTitle method, of class Entry.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");

        String expResult = title;
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPoints method, of class Entry.
     */
    @Test
    public void testGetPoints() {
        System.out.println("getPoints");

        int expResult = points;
        int result = instance.getPoints();
        assertEquals(expResult, result);

    }

    /**
     * Test of getOrderNumber method, of class Entry.
     */
    @Test
    public void testGetOrderNumber() {
        System.out.println("getOrderNumber");

        int expResult = orderNumber;
        int result = instance.getOrderNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCommentsNumber method, of class Entry.
     */
    @Test
    public void testGetCommentsNumber() {
        System.out.println("getCommentsNumber");

        int expResult = comments;
        int result = instance.getCommentsNumber();
        assertEquals(expResult, result);
    }

}