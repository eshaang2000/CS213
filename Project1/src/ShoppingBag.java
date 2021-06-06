/**
 *  Class to build a container for a GroceryItem objects.
 *  @author Eshaan Gandhi, Shankar Kohli
 */
public class ShoppingBag {
    private GroceryItem[] bag; // array-based implementation of the bag
    private int size; // number of items currently in the bag

    /**
     * Constructor initializes the ShoppingBag object
     */
    public ShoppingBag() {
        size = 0;
        bag = new GroceryItem[5]; //initial capacity is 5
    }

    /**
     * Testbed Main to test ShoppingBag Class
     * @param args not required
     */
    public static void main(String[] args) {
        //Constructor
        ShoppingBag testBag = new ShoppingBag();

        //Test remove() on empty bag
        System.out.println("***Test Case: remove() on empty bag");
        System.out.println("Bag Size: " + testBag.size);
        System.out.println("Attempting to remove: Grapes: $2.99: is taxable");
        System.out.println("*Return Value: " + Boolean.toString(testBag.remove(new GroceryItem("Grapes", 2.99, true))));
        System.out.println();

        //Test add() and grow(), adding 6 items, display contents of bag and size
        System.out.println("***Test Case: Add 6 objects, check if added, check if bag grew***");
        testBag.add(new GroceryItem("Apples", 1.99, false));
        testBag.add(new GroceryItem("Bananas", 2.99, true));
        testBag.add(new GroceryItem("Apples", 1.99, false));
        testBag.add(new GroceryItem("Bananas", 2.99, false));
        testBag.add(new GroceryItem("Apples", 1.99, true));
        testBag.add(new GroceryItem("Bananas", 2.99, false));
        System.out.println("**You have " + testBag.getSize() + " item(s) in the bag");
        testBag.print();
        System.out.println("**End of list");
        System.out.println("Size: " + testBag.size);
        System.out.println();

        //Test remove() and display return value, print contents of bag
        //One valid removal, one invalid
        System.out.println("***Test Case: Remove from bag");
        System.out.println("**Attempting to remove: Apples: $1.99: tax free");
        System.out.println("*Return value: " + Boolean.toString(testBag.remove(new GroceryItem("Apples", 1.99, false))));
        System.out.println("**You have " + testBag.getSize() + " item(s) in the bag");
        testBag.print();
        System.out.println("**End of list");
        System.out.println("Size: " + testBag.size);
        System.out.println();
        System.out.println("**Attempting to remove: not_present: $1.00: is taxable");
        System.out.println("*Return Value: " + Boolean.toString(testBag.remove(new GroceryItem("not_present", 1.00, true))));
        System.out.println("**You have " + testBag.getSize() + " item(s) in the bag");
        testBag.print();
        System.out.println("**End of list");
        System.out.println("Size: " + testBag.size);
        System.out.println();

        //Test grow()
        System.out.println("***Test Case: grow()");
        System.out.println("Capacity of bag before grow() invocation: " + testBag.bag.length);
        testBag.grow();
        System.out.println("Capacity of bag after grow() invocation: " + testBag.bag.length);
        System.out.println();

        //Test salesTax(): add taxable item to bag, check if salesTax() changes, add nontaxable item to bag check if salesTax() changes
        System.out.println("***Test Case: salesTax()");
        System.out.println("Current Sales Tax: $" + String.format("%.02f", testBag.salesTax()));
        System.out.println("Adding Taxable Item: Grapes: 3.99: is taxable");
        testBag.add(new GroceryItem("Grapes", 3.99, true));
        System.out.println("New Sales Tax: $" + String.format("%.02f", testBag.salesTax()));
        System.out.println("Adding Nontaxable Item: nontaxable: $3.99: tax free");
        testBag.add(new GroceryItem("nontaxable", 3.99, false));
        System.out.println("New Sales Tax: $" + String.format("%.02f", testBag.salesTax()));

    }

    /**
     * Finds the item in the ShoppingBag array.
     * @param item Item to be found in the array.
     * @return returns the index of the item in the array if found. Returns -1 if not found.
     */
    private int find(GroceryItem item) {
        for (int i = 0; i<size; i++) {
            GroceryItem check;
            check = bag[i];
            if (check.equals(item)) {
                return i; //return the index when the item is found
            }
        }
        return -1; //returns -1 if the item is not found in the bad array
    } // helper method to find an item

    /**
     * Grows the capacity of the array by 5 whenever needed
     */
    private void grow() {
        GroceryItem[] newBag = new GroceryItem[bag.length + 5];
        System.arraycopy(bag, 0, newBag, 0, bag.length);
        bag = newBag;
    } // helper method to grow the capacity

    /**
     * Adds an item to the grocery bag.
     * @param item Item to be added to the bag
     */
    public void add(GroceryItem item) {
        if (size + 1 > bag.length) {
            grow();
        }
        bag[size] = item;
        size++;
    }

    /**
     * Removes an item from the grocery bag.
     * @param item Item to be removed from the bag.
     * @return returns true if the removal was successful, false if not
     */
    public boolean remove(GroceryItem item) {
        int index = find(item);
        if (index == -1) { //the item was not found
            return false;
        }
        bag[index] = bag[size - 1];
        bag[size - 1] = null;
        size--;
        return true;
    }

    /**
     * Gets the total sales price of the shopping bag.
     * @return the total cost of the bag
     */
    public double salesPrice() {
        double ans = 0;
        for (int i = 0; i<size; i++) {
            ans += bag[i].getPrice();
        }
        return ans;
    }

    /**
     * Calculates the total sales tax to be collected through taxable items
     * @return Total sales tax
     */
    public double salesTax() {
        double ans = 0;
        double taxRate = 0.06625;
        for (int i = 0; i<size; i++) {
            if (bag[i].getTaxable())
                ans += bag[i].getPrice() * taxRate;
        }
        return ans;
    }

    /**
     * Prints  array using the toString function in the GroceryItem class
     */
    public void print() {
        for (int i = 0; i<size; i++) {
            if (bag[i] == null) {
                break;
            }
            System.out.println("·" + bag[i].toString());
        }
    }

    /**
     * Get size of the shopping bag.
     * @return size of the bag
     */
    public int getSize() {
        return size;
    }

    /**
     * Set size of the shopping bag
     * @param newSize The new size of the shopping bag.
     */
    public void setSize(int newSize) {
        size = newSize;
    }

} //class closed