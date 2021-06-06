/**
 *  JUnit Runner class to run DateTest, MoneyMarketTest, and CheckingTest
 *  @author Shankar Kohli, Eshaan Gandhi
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DateTest.class,
        MoneyMarketTest.class,
        CheckingTest.class
})

public class JUnitRunner {

}