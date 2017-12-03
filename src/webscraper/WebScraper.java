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
public class WebScraper {

    /**
     * @param args the command line arguments
     */
    private static int numberOfEntries = Configuration.numberOfEntries;
    private static int filterTitleParameter = Configuration.filterTitleParameter;
    private static String url = Configuration.url;

    public static void main(String[] args) {
        EntriesCollection entriesCollection = EntriesCollection.getInstance();
        int choice = 0;
        do {
            choice = Menu.getOption();

            switch (choice) {
                case 1:
                    System.out.println("Wait please.... obtaining data...");

                    entriesCollection.removeAllEntries();
                    entriesCollection = scrapeURL(url);

                    System.out.println("Data Extracted" + Configuration.newline);

                    entriesCollection.displayEntries();
                    break;
                case 2:
                    if (entriesCollection != null) {
                        entriesCollection
                                .ordeyByComments()
                                .displayEntries();
                    }
                    break;
                case 3:
                    if (entriesCollection != null) {
                        entriesCollection
                                .ordeyByPoints()
                                .displayEntries();
                    }
                    break;
                case 4:
                    if (entriesCollection != null) {
                        entriesCollection
                                .FilterByTitleMoreThan(filterTitleParameter)
                                .displayEntries();
                    }
                    break;
                case 5:
                    if (entriesCollection != null) {
                        entriesCollection
                                .FilterByTitleLessThanOrEqual(filterTitleParameter)
                                .displayEntries();
                        break;
                    }
                case 6:
                    System.out.println("End");
                    break;
                default:
                // The user input an unexpected choice.
            }
        } while (choice != 6);

    }

    public static EntriesCollection scrapeURL(String url) {

        String html = DataExtractor.getUrlCodeAsString("https://" + url);
        if (DataExtractor.hasExtradtedCode(html)) {

            EntriesCollection entriesCollection = DataExtractor.extractData(html, numberOfEntries);
            return entriesCollection;
        }
        return null;
    }

}
