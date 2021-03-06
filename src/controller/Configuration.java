/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Collection;
import model.Article;
import model.Item;
import model.ArrayArticles;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 *
 * @author katrina
 */
public class Configuration {

    public static final int numberOfEntries = 30;
    public static int filterTitleParameter = 5;
    public static String url = "news.ycombinator.com/";

    public static int MAX_NUMBER_OF_ENTRIES = 30;

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

    public static final String NEW_LINE = System.getProperty("line.separator");

    public static ToIntFunction<? super Item> comparatorKeyComments = Item::getCommentsNumber;
    public static ToIntFunction<? super Item> comparatorKeyPoints = Item::getPoints;
    
    public static Class<? extends Item> item= Article.class;
    public static Collection entriesCollection = ArrayArticles.getInstance();
    
    public static final String SEARCH_PARAMETER_ITEMS= "table.itemlist tr";
    public static final String SEARCH_PARAMETER_ORDER_NUMBER="td.title";
    public static final String SEARCH_PARAMETER_TITLE="a.storylink";
    public static final String SEARCH_PARAMETER_POINTS="span.score";
    public static final String SEARCH_PARAMETER_COMMENTS_NUMBER="a:contains(comments)";
    public static final String HTTPS_STRING="https://";

}
