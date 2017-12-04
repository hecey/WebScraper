/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper;

import java.util.Scanner;

/**
 *
 * @author kat
 */
public class Menu {

    public static int getOption() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Extract Data from URL again");
        System.out.println("2 - Ordered by amount of comments");
        System.out.println("3 - Ordered by points");
        System.out.format("4 - Filter all previous entries with More Than %s Words in the title"
                + Configuration.newline, Configuration.filterTitleParameter);
        System.out.format("5 - Filter all previous entries with less than or equal to %s words"
                + Configuration.newline, Configuration.filterTitleParameter);
        System.out.println("6 - Quit");
        do {
            while (!input.hasNextInt()) {
                System.out.println("That's not a number!");
                input.next(); // this is important!
            }
            selection = input.nextInt();
        } while (selection <= 0);
        return selection;

    }

}
