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
    private static int choice = 0;

    public static void main(String[] args) {
        Collection entriesCollection = ArrayArticles.getInstance();
        showAndValidateMenu(entriesCollection);

    }

    public static Collection scrapeURL(String url, Collection collection) {

        String html = DataExtractor.getUrlCodeAsString("https://" + url);
        if (DataExtractor.hasExtradtedCode(html)) {

            Collection entriesCollection = DataExtractor.extractData(html, numberOfEntries, Article.class, collection);
            return entriesCollection;
        }
        return null;
    }

    private static void showAndValidateMenu(Collection collection) {
        do {
            choice = Menu.getOption();
            
            switch (choice) {
                case 1:
                    System.out.println("Wait please.... obtaining data...");

                    collection.removeAllEntries();
                    collection = scrapeURL(url,collection);

                    System.out.println("Data Extracted" + Configuration.newline);

                    collection.displayEntries();
                    break;
                case 2:
                    if (collection != null) {
                        collection
                                .ordeyByComments()
                                .displayEntries();
                    }
                    break;
                case 3:
                    if (collection != null) {
                        collection
                                .ordeyByNumberOf(Configuration.comparatorKeyPoints)
                                .displayEntries();
                    }
                    break;
                case 4:
                    if (collection != null) {
                        collection
                                .FilterByTitleMoreThan(filterTitleParameter)
                                .displayEntries();
                    }
                    break;
                case 5:
                    if (collection != null) {
                        collection
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

}
