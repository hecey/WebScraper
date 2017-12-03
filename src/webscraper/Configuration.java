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
public class Configuration {
    
    
    public static final int numberOfEntries = 30;
    public static int filterTitleParameter = 5;
    public static String url = "news.ycombinator.com/";
    
    public static int MAX_NUMBER_OF_ENTRIES = 40;
    
    public static String numberHeaderText = "N#";
    public static String titleHeaderText = "Title";
    public static String orderHeaderText = "O#";
    public static String pointsHeaderText = "Points";
    public static String commentsHeaderText = "Comments";
    
    public static int numberHeaderLenght = 5;
    public static int titleHeaderLenght = 80;
    public static int orderHeaderLenght = 5;
    public static int pointsHeaderLenght = 6;
    public static int commentsHeaderLenght = 8;
    
    public static String newline = System.getProperty("line.separator");
}
