/**
 *  JUnit test class to test Date
 *  @author Shankar Kohli, Eshaan Gandhi
 */

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateTest {

    /**
     * Method to check if date is valid, base case. The date is a valid date.
     */
    @Test
    public void isValidDate() {
        Date validDate = new Date("11/1/2020");
        assertTrue(validDate.isValid());

    }

    /**
     * Checks invalidity of month. Checks for month > 12, month = 0, and month<0
     */
    @Test
    public void isInvalidMonth() {
        Date invalidMonth = new Date("13/1/2020");
        assertFalse(invalidMonth.isValid());

        Date invalidMonth2 = new Date("0/1/2020");
        assertFalse(invalidMonth2.isValid());

        Date invalidMonth3 = new Date("-2/1/2020");
        assertFalse(invalidMonth3.isValid());

    }

    /**
     * Checks invalidity of day. Checks for day > 30 for 30 day months, day > 31 for 31 day months, day = 0, and day<0
     */
    @Test
    public void isInvalidDay() {
        Date invalidDay = new Date("12/40/2020");
        assertFalse(invalidDay.isValid());

        Date invalidDay2 = new Date("12/0/2020");
        assertFalse(invalidDay2.isValid());

        Date invalidDay3 = new Date("12/-1/2020");
        assertFalse(invalidDay3.isValid());

        Date invalidDay4 = new Date("9/31/2020");
        assertFalse(invalidDay4.isValid());

        Date invalidDay5 = new Date("10/32/2020");
        assertFalse(invalidDay5.isValid());
    }

    /**
     * Checks if February 29th is valid given a year
     */
    @Test
    public void FebruaryDays() {
        Date validDate = new Date("2/29/2020");
        assertTrue(validDate.isValid());

        Date invalidDate = new Date("2/29/2019");
        assertTrue(validDate.isValid());

    }

    /**
     * Checks if year is invalid, year<0
     */
    @Test
    public void isInvalidYear() {

        Date invalidYear2 = new Date("2/20/-1");
        assertFalse(invalidYear2.isValid());

    }

}