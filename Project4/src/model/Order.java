/**
 *  Class to manage orders, orderline, implements abstract methods add() and remove()
 *  @author Shankar Kohli, Eshaan Gandhi
 */

package model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Order implements Customizable {
    public static int lineNumber; //reset for each new order;
    private ArrayList<OrderLine> orderlines;

    /**
     * Constructor, initializes orderlines array and sets lineNumber to 0
     */
    public Order(){
        lineNumber = 0;
        orderlines = new ArrayList<OrderLine>();
    }

    /**
     * Method to get total price of all sandwiches in orderlines
     * @return total price of order
     */
    public double getPrice(){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        double totalPrice = 0;
        for(int i=0; i<orderlines.size(); i++){
            totalPrice+=orderlines.get(i).getPrice();
        }
        return Double.parseDouble(decimalFormat.format(totalPrice));
    }

    /**
     * Method to return string representation of orderlines array with total price
     * @return
     */
    public String toString(){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        String order = "";
        for(int i=0; i<orderlines.size(); i++){
            order+=orderlines.get(i).toString()+"\n";
        }
        order+="Total Price: $"+decimalFormat.format(getPrice());
        return order;
    }


    /**
     * Method to add OrderLine object to array orderlines
     * @param obj, OrderLine object to be added
     * @return true on success, false on failure
     */
    @Override
    public boolean add(Object obj){
        if(obj instanceof OrderLine){
            OrderLine order = (OrderLine)  obj;
            orderlines.add(order);
            order.setLineNumber(orderlines.size());
            lineNumber++;
            return true;

        }
        return false;
    }

    /**
     * Method to remove OrderLine object from array orderlines
     * @param obj, OrderLine object to be removed
     * @return true on success, false on failure
     */
    @Override
    public boolean remove(Object obj){
        if(obj instanceof  OrderLine){
            OrderLine order = (OrderLine) obj;
            orderlines.remove(order);
            for(int i = 0; i < orderlines.size(); i++){
                orderlines.get(i).setLineNumber(i+1);
            }
            lineNumber--;
        }
        return false;

    }

    /**
     * Getter method to return lineNumber
     * @return int lineNumber
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * Getter method ot return orderlines array
     * @return  ArrayList<OrderLine> orderlines
     */
    public ArrayList<OrderLine> getOrderlines() {
        return orderlines;
    }


    /**
     * Method to clear orderlines array, remove all orderlines
     */
    public void clear(){
        orderlines.clear();
    }


}