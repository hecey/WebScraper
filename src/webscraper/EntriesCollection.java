/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.ToIntFunction;

/**
 *
 * @author kat
 */
public class EntriesCollection {

    private static EntriesCollection instance = null;
    ArrayList<Entry> entriesCollection;
    private static String newline = Configuration.newline;
    public static int MAX_NUMBER_OF_ENTRIES = Configuration.MAX_NUMBER_OF_ENTRIES;
    private int i;

    protected EntriesCollection() {
        entriesCollection = new ArrayList<>();
    }

    public static EntriesCollection getInstance() {
        if (instance == null) {
            instance = new EntriesCollection();
        }
        return instance;
    }

    public void addEntry(Entry entry) {

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
                + newline,
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
                    + newline,
                    i,
                    entry.getOrderNumber(),
                    entry.getTitle(),
                    entry.getPoints(), entry.getCommentsNumber());
        });

        System.out.println(newline + size + " records presented..." + newline + newline);
    }

    public <T> EntriesCollection ordeyByNumberOf(ToIntFunction <? super Entry> keyExtractor) {

        entriesCollection.sort((Comparator<? super Entry>) 
                Comparator.comparingInt(keyExtractor));

        return this;
    }

    public EntriesCollection ordeyByComments() {

        entriesCollection.sort(Comparator.comparingInt(Entry::getCommentsNumber));

        return this;
    }

    public EntriesCollection ordeyByPoints() {

        entriesCollection.sort(Comparator.comparingInt(Entry::getPoints));

        return this;
    }

    public EntriesCollection FilterByTitleMoreThan(int number) {

        ArrayList<Entry> secondList = new ArrayList<>();

        entriesCollection.forEach((a) -> {
            String trimmed = a.getTitle().trim();
            int words = trimmed.isEmpty() ? 0 : trimmed.split("\\s+").length;
            if (words > number) {
                secondList.add(a);
            }
        });

        entriesCollection = secondList;

        return this;
    }

    public EntriesCollection FilterByTitleLessThanOrEqual(int number) {
        ArrayList<Entry> secondList = new ArrayList<>();

        entriesCollection.forEach((a) -> {
            String trimmed = a.getTitle().trim();
            int words = trimmed.isEmpty() ? 0 : trimmed.split("\\s+").length;
            if (words <= number) {
                secondList.add(a);
            }
        });

        entriesCollection = secondList;

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

    public EntriesCollection removeAllEntries() {
        if (entriesCollection != null) {
            entriesCollection.clear();
        }

        return this;

    }
}
