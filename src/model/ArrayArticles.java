/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.ToIntFunction;
import controller.Configuration;


/**
 *
 * @author kat
 */
public class ArrayArticles implements Collection {

    private static ArrayArticles instance = null;
    ArrayList<Item> entriesCollection;
    private static final String NEW_LINE = Configuration.NEW_LINE;
    public static int MAX_NUMBER_OF_ENTRIES = Configuration.MAX_NUMBER_OF_ENTRIES;
    private int i;

    protected ArrayArticles() {
        entriesCollection = new ArrayList<Item>();
    }

    public static ArrayArticles getInstance() {
        if (instance == null) {
            instance = new ArrayArticles();
        }
        return instance;
    }

    public void addEntry(Item entry) {

        if (entriesCollection.size() < MAX_NUMBER_OF_ENTRIES) {
            entriesCollection.add(entry);
        }

    }

    public void displayEntries() {
        int size = entriesCollection.size();
        System.out.format("%" + Configuration.orderHeaderLenght + "s | "
                + "%" + Configuration.orderHeaderLenght + "s | "
                + "%-" + Configuration.titleHeaderLenght + "s | "
                + "%" + Configuration.pointsHeaderLenght + "s | "
                + "%" + Configuration.commentsHeaderLenght + "s | "
                + NEW_LINE,
                Configuration.numberHeaderText,
                Configuration.orderHeaderText,
                Configuration.titleHeaderText,
                Configuration.pointsHeaderText,
                Configuration.commentsHeaderText);
        i = 0;
        entriesCollection.forEach((entry) -> {

            i++;
            System.out.format("%" + Configuration.numberHeaderLenght + "d | "
                    + "%" + Configuration.orderHeaderLenght + "d | "
                    + "%-" + Configuration.titleHeaderLenght + "s | "
                    + "%" + Configuration.pointsHeaderLenght + "d | "
                    + "%" + Configuration.commentsHeaderLenght + "d | "
                    + NEW_LINE,
                    i,
                    entry.getOrderNumber(),
                    entry.getTitle(),
                    entry.getPoints(), entry.getCommentsNumber());
        });

        System.out.println(NEW_LINE + size + " records presented..." + NEW_LINE + NEW_LINE);
    }

    public <T> ArrayArticles ordeyByNumberOf(ToIntFunction<? super Item> keyExtractor) {

        entriesCollection.sort((Comparator<? super Item>) Comparator.comparingInt(keyExtractor));

        return this;
    }

    public ArrayArticles ordeyByComments() {

        entriesCollection.sort(Comparator.comparingInt(Item::getCommentsNumber));

        return this;
    }

    public ArrayArticles ordeyByPoints() {

        entriesCollection.sort(Comparator.comparingInt(Item::getPoints));

        return this;
    }

    public ArrayArticles FilterByTitleMoreThan(int number) {

        entriesCollection.removeIf(a -> countWords(a.getTitle()) < number);

        return this;
    }

    public ArrayArticles FilterByTitleLessThanOrEqual(int number) {

        entriesCollection.removeIf(a -> countWords(a.getTitle()) > number);

        return this;
    }

    public boolean hasEntries() {
        if (entriesCollection == null) {
            return false;
        }
        if (entriesCollection.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayArticles removeAllEntries() {
        if (entriesCollection != null) {
            entriesCollection.clear();
        }

        return this;

    }

    private int countWords(String string) {
        String trimmed = string.trim();

        return trimmed.isEmpty() ? 0 : trimmed.split("\\s+").length;
    }
}
