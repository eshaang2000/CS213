/**
 *  JUnit test class to test Checking
 *  @author Shankar Kohli, Eshaan Gandhi
 */

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckingTest {

    /**
     * Checks for accurate monthly fee, no direct deposit, base case of $25
     */
    @Test
    public void normalMonthlyFee() {
        Profile holder = new Profile("Shankar", "Kohli");
        Date date = new Date("1/2/2020");
        Account test = new Checking(holder, 0.00, date, false);
        assertEquals(25, test.monthlyFee());

    }

    /**
     * Checks if monthly fee is appropriately waived based on balance
     */
    @Test
    public void waivedMonthlyFee() {
        Profile holder = new Profile("Shankar", "Kohli");
        Date date = new Date("1/2/2020");
        Account test = new Checking(holder, 1501, date, false);
        assertEquals(0, test.monthlyFee());
    }

    /**
     * Checks if monthly fee is waived in balance boundary cases
     */
    @Test
    public void boundaryMonthlyFee() {
        Profile holder = new Profile("Shankar", "Kohli");
        Date date = new Date("1/2/2020");
        Account test = new Checking(holder, 1500, date, false);
        assertEquals(0, test.monthlyFee());
    }

    /**
     * Checks if monthly fee is appropriately waived based on direct deposit
     */
    @Test
    public void directDepositMonthlyFee() {
        Profile holder = new Profile("Shankar", "Kohli");
        Date date = new Date("1/2/2020");
        Account test = new Checking(holder, 1000, date, false);
        assertEquals(25, test.monthlyFee());

        Account test2 = new Checking(holder, 1000, date, true);
        assertEquals(0, test2.monthlyFee());

    }

    /**
     * Checks  if monthly interest is accurate for a positive balance, negative balance, and zero balance
     */
    @Test
    public void monthlyInterest() {
        Profile holder = new Profile("Shankar", "Kohli");
        Date date = new Date("1/2/2020");
        Account test = new Checking(holder, 0, date, false);
        assertEquals(0, test.monthlyInterest());

        test.setBalance(-1);
        assertEquals(0, test.monthlyInterest());

        test.setBalance(12);
        assertEquals(0.0005, test.monthlyInterest());

    }
}