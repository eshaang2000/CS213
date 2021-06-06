import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyMarketTest {

    /**
     * Checks for accurate monthly fee, 0 withdrawals, base case of $12 fee
     */
    @Test
    public void normalMonthlyFee() {
        Profile holder = new Profile("Shankar", "Kohli");
        Date date = new Date("1/2/2020");
        Account test = new MoneyMarket(holder, 0.00, date, 0);
        assertEquals(12, test.monthlyFee());

    }

    /**
     * Checks if monthly fee is appropriately waived based on balance
     */
    @Test
    public void waivedMonthlyFee() {
        Profile holder = new Profile("Shankar", "Kohli");
        Date date = new Date("1/2/2020");
        Account test = new MoneyMarket(holder, 2501, date, 0);
        assertEquals(0, test.monthlyFee());
    }

    /**
     * Checks if monthly fee is waived in balance boundary cases
     */
    @Test
    public void boundaryMonthlyFee() {
        Profile holder = new Profile("Shankar", "Kohli");
        Date date = new Date("1/2/2020");
        Account test = new MoneyMarket(holder, 2500, date, 0);
        assertEquals(0, test.monthlyFee());
    }

    /**
     * Checks if monthly fee is appropriately waived based on number of withdrawals
     */
    @Test
    public void maxWithdrawalsFeeMonthlyFee() {
        Profile holder = new Profile("Shankar", "Kohli");
        Date date = new Date("1/2/2020");
        Account test = new MoneyMarket(holder, 2600, date, 6);
        assertEquals(0, test.monthlyFee());

        ((MoneyMarket) test).setWithdrawals(7);
        assertEquals(12, test.monthlyFee());

    }

    /**
     * Checks  if monthly interest is accurate for a positive balance, negative balance, and zero balance
     */
    @Test
    public void monthlyInterest() {
        Profile holder = new Profile("Shankar", "Kohli");
        Date date = new Date("1/2/2020");
        Account test = new MoneyMarket(holder, 0, date, 6);
        assertEquals(0, test.monthlyInterest());

        test.setBalance(-1);
        assertEquals(0, test.monthlyInterest());

        test.setBalance(12);
        assertEquals(0.0065, test.monthlyInterest());

    }
}