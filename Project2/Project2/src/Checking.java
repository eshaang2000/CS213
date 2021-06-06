/**
 *  Subclass of Account, holds various Checking account functions
 *  @author Shankar Kohli, Eshaan Gandhi
 */

public class Checking extends Account {

    private boolean directDeposit;

    /**
     * Constructor for Checking subclass
     * @param holder account holder
     * @param balance account balance
     * @param dateOpen account open date
     * @param directDeposit boolean value to check if account is direct deposit
     */
    public Checking(Profile holder, double balance, Date dateOpen, boolean directDeposit) {
        super(holder, balance, dateOpen);
        this.directDeposit = directDeposit;
    }

    /**
     * Calculate monthly interest for Checking subclass
     * @return monthly interest
     */
    public double monthlyInterest() {
        double checkingInterest = 0.0005;
        double months = 12;
        double balance = getBalance();
        if (balance<0) {
            return 0;
        }
        return balance * checkingInterest / months;
    }

    /**
     * Calculate monthly fee for Checking subclass
     * @return monthly fee
     */
    public double monthlyFee() {
        double balance = getBalance();
        double waiveBalance = 1500;
        double monthlyFee = 25;
        if (balance >= waiveBalance || directDeposit) {
            return 0;
        } else {
            return monthlyFee;
        }
    }

    /**
     *toString() method for Checking subclass
     * @return super.toString() with direct deposit status appended
     */
    @Override
    public String toString() {

        if (directDeposit) {
            return super.toString() + "*direct deposit account*";
        }

        return super.toString();
    }
}