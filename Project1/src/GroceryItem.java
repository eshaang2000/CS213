/**
 *  Class to build a GroceryItem Object, to be placed in a Shopping Bag
 *  @author Eshaan Gandhi, Shankar Kohli
 */
public class GroceryItem {
    private String name;
    private double price;
    private boolean taxable;

    /**
     *  Default constructor to initialize a GroceryItem Object
     */
    public GroceryItem() {
        this.name = null;
        this.price = 0;
        this.taxable = false;
    }

    /**
     * Parameterized constructor to initialize a GroceryItem Object
     * @param name name of the item
     * @param price price of the item
     * @param taxable boolean value to indicate whether item is taxable or not
     */
    public GroceryItem(String name, double price, boolean taxable) {
        this.name = name;
        this.price = price;
        this.taxable = taxable;
    }

    /**
     * Compares if two GroceryItem Objects are equal
     * @param obj object to be compared
     * @return return true if objects are equal, else returns false
     */
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        GroceryItem item = (GroceryItem) obj;

        if (item.name.equals(this.name)) {
            if (item.price == this.price) {
                if (item.taxable == this.taxable) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Generates a string from the data fields of an object
     * @return String with all data fields mapped out
     */
    public String toString() {
        String priceOut = String.format("%.02f", price);
        String ans = name + ": " + "$" + priceOut + " : ";
        if (!taxable) {
            ans += "tax free";
        } else {
            ans += "is taxable";
        }
        return ans;
    }

    /**
     * Gets private instance variable taxable
     * @return returns instance variable taxable
     */
    public boolean getTaxable() {
        return taxable;
    }

    /**
     * Gets private instance variable price
     * @return returns instance variable price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets private instance variable name
     * @return returns instance variable name
     */
    public String getName() {
        return name;
    }
}