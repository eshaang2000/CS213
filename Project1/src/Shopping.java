/**
 *  Class to create user interface class  handles the input commands, output data and messages.
 *  @author Eshaan Gandhi, Shankar Kohli
 */

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;
import java.lang.Thread;

public class Shopping {

    ShoppingBag bag = new ShoppingBag(); //ShoppingBag object

    /**
     * Method to handle user input and call appropriate method.
     */
    public void run() {
        System.out.println("Let's start shopping!");
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (scanner.hasNextLine()) {
            String[] tokens = scanner.nextLine().split("\\s");
            if (tokens[i].equals("A")) {
                GroceryItem item = new GroceryItem(tokens[i + 1], Double.parseDouble(tokens[i + 2]), Boolean.parseBoolean(tokens[i + 3]));
                addItem(item);
            } else if (tokens[i].equals("R")) {
                GroceryItem item = new GroceryItem(tokens[i + 1], Double.parseDouble(tokens[i + 2]), Boolean.parseBoolean(tokens[i + 3]));
                removeItem(item);
            } else if (tokens[i].equals("P")) {
                displayItems();
            } else if (tokens[i].equals("C")) {
                checkOut();
            } else if (tokens[i].equals("Q")) {
                quit();
            } else {
                System.out.println("Invalid command!");
            }

        }

    }

    /**
     * Adds item to shopping bag.
     * @param item GroceryItem Item to add.
     */
    public void addItem(GroceryItem item) {
        bag.add(item);
        System.out.println(item.getName() + " added to the bag.");
    }

    /**
     * Removes item from shopping bag.
     * @param item GroceryItem Item to remove.
     */
    public void removeItem(GroceryItem item) {

        if (bag.remove(item)) {
            System.out.println(item.getName() + " " + item.getPrice() + " removed.");
        } else {
            System.out.println("Unable to remove, this item is not in the bag.");
        }
    }

    /**
     * Displays items in shopping bag.
     */
    public void displayItems() {
        if (bag.getSize() == 0) {
            System.out.println("The bag is empty!");
        } else {
            String wordForm = bag.getSize() == 1 ? "item" : "items";
            System.out.println("**You have " + bag.getSize() + " " + wordForm + " in the bag.");
            bag.print();
            System.out.println("**End of list");
        }
    }

    /**
     * Check out all items in shopping bag.
     */
    public void checkOut() {
        if (bag.getSize() == 0) {
            System.out.println("Unable to check out, the bag is empty!");
        } else {
            String wordForm = bag.getSize() == 1 ? "item" : "items";
            System.out.println("**Checking out " + bag.getSize() + " " + wordForm + ".");
            bag.print();
            System.out.println("*Sales total: " + "$" + String.format("%.02f", bag.salesPrice()));
            System.out.println("*Sales tax: " + "$" + String.format("%.02f", bag.salesTax()));
            System.out.println("*Total amount paid: " + "$" + String.format("%.02f", (bag.salesTax() + bag.salesPrice())));
            bag.setSize(0);
        }
    }

    /**
     * Quit program after checking out all items.
     */
    public void quit() {
        if (bag.getSize() != 0) {
            String wordForm = bag.getSize() == 1 ? "item" : "items";
            System.out.println("**Checking out " + bag.getSize() + " " + wordForm + ".");
            bag.print();
            System.out.println("*Sales total: " + "$" + String.format("%.02f", bag.salesPrice()));
            System.out.println("*Sales tax: " + "$" + String.format("%.02f", bag.salesTax()));
            System.out.println("*Total amount paid: " + "$" + String.format("%.02f", (bag.salesTax() + bag.salesPrice())));
            bag.setSize(0);
        } else {
            System.out.println("Thanks for shopping with us!");
            System.exit(0);
        }
    }
}