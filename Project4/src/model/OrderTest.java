/**
 *  JUnit test class to test Order
 *  @author Shankar Kohli, Eshaan Gandhi
 */

package model;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest {

    /**
     * Method to test if item  is added successfully, checks whether orderlines size is appropriate 
     */
    @Test
    public void addTest(){
        Order object  = new Order();
        ArrayList<Extra> extras = new ArrayList<Extra>();
        extras.add(Extra.Lettuce);
        extras.add(Extra.Mustard);
        Sandwich sandwich = new Chicken(extras);
        OrderLine test = new OrderLine(1, sandwich, sandwich.price());
        object.add(test);
        assertEquals(object.getOrderlines().size(), 1);
        object.add(test);
        assertEquals(object.getOrderlines().size(), 2);
    }

    /**
     * Method to test if total order price is accurate with extras and without
     */
    @Test
    public void getPriceTest(){
        //get price of order with only plain Chicken Sandwich
        Order object  = new Order();
        ArrayList<Extra> extras = new ArrayList<Extra>();
        Sandwich sandwich = new Chicken(extras);
        OrderLine  test = new OrderLine(object.getLineNumber(), sandwich, sandwich.price());
        object.add(test);
        assertEquals(object.getPrice(), 8.99);

        //get price of order with Chicken Sandwich and one Extra (Lettuce)
        Order object2  = new Order();
        ArrayList<Extra> extras2 = new ArrayList<Extra>();
        extras2.add(Extra.Lettuce);
        Sandwich sandwich2 = new Chicken(extras2);
        OrderLine  test2 = new OrderLine(object.getLineNumber(), sandwich2, sandwich2.price());
        object2.add(test2);
        assertEquals(object2.getPrice(), 10.98);

        //get price of order with one Beef Sandwich, one Fish Sandwich
        object2.clear();
        ArrayList<Extra> extras3 = new ArrayList<Extra>();
        Sandwich beefSand = new Beef(extras3);
        Sandwich fishSand = new Fish(extras3);
        OrderLine beef1 = new OrderLine(object2.getLineNumber(), beefSand, beefSand.price());
        OrderLine fish1 = new OrderLine(object2.getLineNumber(), fishSand, fishSand.price());
        object2.add(beef1);
        object2.add(fish1);
        assertEquals(object2.getPrice(), 23.98);
    }


    /**
     * Method to test remove, checks whether orderlines array size and price is appropriate after removal, and if line numbers are updated appropriately
     */
    @Test
    public void removeTest(){
        Order object2 = new Order();
        ArrayList<Extra> extras3 = new ArrayList<Extra>();
        Sandwich beefSand = new Beef(extras3);
        Sandwich fishSand = new Fish(extras3);
        OrderLine beef1 = new OrderLine(object2.getLineNumber(), beefSand, beefSand.price());
        OrderLine fish1 = new OrderLine(object2.getLineNumber(), fishSand, fishSand.price());
        object2.add(beef1);
        object2.add(fish1);

        //base case
        assertEquals(object2.getOrderlines().size(), 2);
        assertEquals(object2.getPrice(), 23.98);
        assertEquals(object2.getLineNumber(), 2);


        object2.remove(beef1);

        //after removal
        assertEquals(object2.getOrderlines().size(), 1);
        assertEquals(object2.getPrice(), 12.99);
        assertEquals(object2.getLineNumber(), 1);

        //test lineNumber reordering
        Sandwich sandwich2 = new Chicken(extras3);
        OrderLine test2 = new OrderLine(object2.getLineNumber(), sandwich2, sandwich2.price());
        object2.add(test2);
        object2.add(beef1);
        assertEquals(object2.getOrderlines().size(), 3);
        //remove middle order
        object2.remove(test2);
        assertEquals(object2.getOrderlines().get(1).getLineNumber(), 2);

    }


    /**
     * Method to test if clear() empties orderlines array
     */
    @Test
    public void testClear(){
        Order object2 = new Order();
        ArrayList<Extra> extras3 = new ArrayList<Extra>();
        Sandwich beefSand = new Beef(extras3);
        Sandwich fishSand = new Fish(extras3);
        OrderLine beef1 = new OrderLine(object2.getLineNumber(), beefSand, beefSand.price());
        OrderLine fish1 = new OrderLine(object2.getLineNumber(), fishSand, fishSand.price());
        object2.add(beef1);
        object2.add(fish1);
        assertEquals(object2.getOrderlines().size(), 2);
        object2.clear();
        assertEquals(object2.getOrderlines().size(), 0);
    }


    /**
     * Method to test constructor for Order
     */
    @Test
    public void testConstructor(){
        Order object = new Order();
        assertEquals(object.getLineNumber(), 0);
    }

    /**
     * Method to test toString() function for Order
     */
    @Test
    public void testToString(){
        Order object = new  Order();
        ArrayList<Extra> extras = new ArrayList<Extra>();
        extras.add(Extra.Lettuce);
        Sandwich sandwich = new Chicken(extras);
        OrderLine order = new OrderLine(object.getLineNumber(), sandwich, sandwich.price());
        object.add(order);
        String x  = "-Serial Number: 1\nSandwich Type: Chicken Sandwich\n-Basic Ingredients:\n--Fried Chicken\n--Spicy Sauce\n--Pickles\nExtra Ingredients:\n--Lettuce\n-Price: $10.98\n\nTotal Price: $10.98";
        assertEquals(object.toString(),x);
    }

    /**
     * Method to test getter method getLineNumber()
     */
    @Test
    public void testGetLineNumber(){
        Order object = new  Order();
        ArrayList<Extra> extras = new ArrayList<Extra>();
        extras.add(Extra.Lettuce);
        Sandwich sandwich = new Chicken(extras);
        OrderLine order = new OrderLine(object.getLineNumber(), sandwich, sandwich.price());
        assertEquals(object.getLineNumber(), 0);
        object.add(order);
        assertEquals(object.getLineNumber(), 1);
    }

    /**
     * Method to test getter method for orderlines, getOrderLines()
     */
    @Test
    public void testGetOrderLines(){
        Order object = new  Order();
        ArrayList<Extra> extras = new ArrayList<Extra>();
        extras.add(Extra.Lettuce);
        Sandwich sandwich = new Chicken(extras);
        OrderLine order = new OrderLine(object.getLineNumber(), sandwich, sandwich.price());
        object.add(order);
        ArrayList<OrderLine> orderLinesTester = new ArrayList<OrderLine>();
        orderLinesTester.add(order);
        assertEquals(object.getOrderlines(), orderLinesTester );
    }
}