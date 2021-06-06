/**
 * Abstract class to define characteristics of sandwiches, adds, removes ingredients
 *  @author Shankar Kohli, Eshaan Gandhi
 */

package model;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {
    static final int MAX_EXTRAS = 6;
    static final double PER_EXTRA = 1.99;
    protected ArrayList<Extra> extras;

    /**
     * Constructor to create sandwich with extras passed in
     * @param extras
     */
    public Sandwich(ArrayList<Extra> extras) {
        this.extras = extras;
    }

    /**
     * Constructor to create sandwich with extras, initializes extras array
     */
    public Sandwich() {
        extras = new ArrayList<Extra>();
    }

    /**
     * Abtract method to find price of sandwich
     * @return price
     */
    public abstract double price();


    /**
     * Method to remove an extra from sandwich
     * @param obj, Extra to be removed
     * @return true on success, false on failure
     */
    @Override
    public boolean remove(Object obj) {
        if(extras.size() == 0){
            return false;
        }
        Extra ingredient = (Extra) obj;
        if (extras.contains(ingredient)) {
            extras.remove(ingredient);
            return true;
        }


        return false;
    }

    /**
     * Method to add an extra to a sandwich
     * @param obj, Extra to be added
     * @return true on success, false on failure
     */
    @Override
    public boolean add(Object obj) {
        Extra ingredient = (Extra)obj;
        if (extras.contains(ingredient)) {
            return false;
        }
        else if (extras.size() >= MAX_EXTRAS) {
            return false;
        }

        extras.add(ingredient);
        return true;

    }

    /**
     * Method to return string representation of sandwich
     * @return
     */
    public String toString() {
        String out = "Extra Ingredients:" + "\n";
        for (int i = 0; i < extras.size(); i++) {
            out += "--" + extras.get(i) + "\n";
        }
        out += "-Price: $" + price();
        return out;
    }


    /**
     * Abstract method to getBasicIngredients in String form for a sandwich
     * @return String, basic ingredients
     */
    public abstract String getBasicIngredientsString();
}