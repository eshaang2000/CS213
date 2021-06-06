/**
 *  Fish subclass implementing abstract method price() and various functions
 *  @author Shankar Kohli, Eshaan Gandhi
 */

package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Fish extends Sandwich{

    static final double BASE_PRICE = 12.99;
    static final List<String> INGREDIENTS = List.of("Grilled Snapper", "Cilantro", "Lime");
    static final ArrayList<String> BASIC_INGREDIENTS = new ArrayList<>(INGREDIENTS);


    /**
     * Constructor for Fish,  inherits from superclass constructor
     */
    public Fish(){
        super();
    }

    /**
     * Constructor for Fish with Extra arraylist parameter, inherits from superclass constructor
     * @param extras
     */
    public Fish(ArrayList<Extra> extras) {
        super(extras);
    }


    /**
     * Method to calculate price of Fish sandwich with extras, overrides abstract method price() in Sandwich superclass
     * @return total price of sandwich
     */
    @Override
    public double price() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        int numExtras = extras.size();
        double finalPrice = BASE_PRICE + numExtras * PER_EXTRA;
        return Double.parseDouble(decimalFormat.format(finalPrice));
    }


    /**
     * Method to return string representation of Fish Sandwich with ingredients, inherits toString() from superclass Sandwich toString() and overrides
     * @return string representation of Fish Sandwich with ingredients
     */
    @Override
    public String toString() {
        String sandwich = "Fish Sandwich";
        sandwich += "\n-Basic Ingredients:\n";
        for (int i = 0; i < BASIC_INGREDIENTS.size(); i++) {
            sandwich += "--" + BASIC_INGREDIENTS.get(i) + "\n";
        }
        sandwich += super.toString();

        return sandwich;
    }

    /**
     * Method to get basic ingredients of Fish Sandwich
     * @return basic ingredients of Fish Sandwich
     */
    public String getBasicIngredientsString(){
        String ingredients = "The basic ingredients are\n";
        for (int i = 0; i < BASIC_INGREDIENTS.size(); i++) {
            ingredients += "--" + BASIC_INGREDIENTS.get(i) + "\n";
        }
        return ingredients;
    }

}
