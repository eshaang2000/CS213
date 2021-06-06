/**
 *  Beef subclass implementing abstract method price() and various functions
 *  @author Shankar Kohli, Eshaan Gandhi
 */
package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Beef extends Sandwich {

    static final double BASE_PRICE = 10.99;
    static final List<String> INGREDIENTS = List.of("Roast Beef", "Provolone Cheese", "Mustard");
    static final ArrayList<String> BASIC_INGREDIENTS = new ArrayList<>(INGREDIENTS);

    /**
     * Constructor for Beef,  inherits from superclass constructor
     */
    public Beef(){
        super();
    }


    /**
     * Constructor for Beef with Extra arraylist parameter, inherits from superclass constructor
     * @param extras
     */
    public Beef(ArrayList<Extra> extras) {
        super(extras);
    }


    /**
     * Method to calculate price of Beef sandwich with extras, overrides abstract method price() in Sandwich superclass
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
     * Method to return string representation of Beef Sandwich with ingredients, inherits toString() from superclass Sandwich toString() and overrides
     * @return string representation of Beef Sandwich with ingredients
     */
    @Override
    public String toString() {
        String sandwich = "Beef Sandwich";
        sandwich += "\n-Basic Ingredients:\n";
        for (int i = 0; i < BASIC_INGREDIENTS.size(); i++) {
            sandwich += "--" + BASIC_INGREDIENTS.get(i) + "\n";
        }
        sandwich += super.toString();

        return sandwich;
    }


    /**
     * Method to get basic ingredients of Beef Sandwich
     * @return basic ingredients of Beef Sandwich
     */
    public String getBasicIngredientsString(){
        String ingredients = "The basic ingredients are\n";
        for (int i = 0; i < BASIC_INGREDIENTS.size(); i++) {
            ingredients += "--" + BASIC_INGREDIENTS.get(i) + "\n";
        }
        return ingredients;
    }
}
