/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper;

/**
 *
 * @author katrina
 */
public class Entry {
    private String title;
    private int points;
    private int orderNumber;
    private int commentsNumber;

    public Entry(String title, int points, int orderNumber, int commentsNumber) {
        this.title = title;
        this.points = points;
        this.orderNumber = orderNumber;
        this.commentsNumber = commentsNumber;
    }

    public String getTitle() {
        return title;
    }

    public int getPoints() {
        return points;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getCommentsNumber() {
        return commentsNumber;
    }
    
    
    
}
