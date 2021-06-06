/**
 *  Class to manage OrderLine objects and attributes
 *  @author Shankar Kohli, Eshaan Gandhi
 */


package model;

public class OrderLine {
    private int lineNumber;
    private Sandwich sandwich;
    private double price;

    /**
     * Parametrized constructor for OrderLine
     * @param lineNumber
     * @param sandwich
     * @param price
     */
    public OrderLine(int lineNumber, Sandwich sandwich, double price){
        this.lineNumber = lineNumber;
        this.sandwich = sandwich;
        this.price = price;
    }

    /**
     * Getter method to return price of OrderLine object
     * @return double price
     */
    public double getPrice(){
        return price;
    }

    /**
     * Getter method to return serial number of OrderLine object
     * @return int lineNumber
     */
    public int getLineNumber(){
        return lineNumber;
    }

    /**
     * Setter method to set lineNumber for OrderLine object
     * @param newNum
     */
    public void setLineNumber(int newNum){
        lineNumber = newNum;
    }

    /**
     * Method to return string representation of a sandwich
     * @return string representation
     */
    @Override
    public String toString(){
        String line = Integer.toString(lineNumber);
       return "-Serial Number: " + line + "\n" + "Sandwich Type: " + sandwich.toString() + "\n";
    }

    /**
     * Getter method to return sandwich attribute of OrderLine object
     * @return Sandwich sandwich
     */
    public Sandwich getSandwich(){
        return sandwich;
    }
}
