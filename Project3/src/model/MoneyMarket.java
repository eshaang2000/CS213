package model;

/**
 *  Subclass of accountDatabase.Account, holds various Money Market account functions
 *  @author Shankar Kohli, Eshaan Gandhi
 */

public class MoneyMarket extends Account {

    private int withdrawals;

    /**
     * Constructor to instantiate fully parametrized accountDatabase.MoneyMarket object
     * @param holder accountDatabase.Profile holder
     * @param balance account balance
     * @param dateOpen account date open
     * @param withdrawals number of withdrawals performed
     */
    public MoneyMarket(Profile holder, double balance, Date dateOpen, int withdrawals) {
        super(holder, balance, dateOpen);
        this.withdrawals = withdrawals;
    }

    @Override
    /**
     * Calculates monthly interest for Money Market account
     * @return monthly interest for Money Market account
     */
    public double monthlyInterest() {
        double moneyMarketInterest = 0.0065;
        double balance = getBalance();
        double months = 12;
        if (balance<0) {
            return 0;
        }
        return balance * moneyMarketInterest / months;
    }

    @Override
    /**
     * Calculates monthly fee for Money Market account
     * @return monthly fee for Money Market acconut
     */
    public double monthlyFee() {
        double balance = getBalance();
        double waiveBalance = 2500;
        double monthlyFee = 12;
        if (balance >= waiveBalance && feeWaived(withdrawals)) {
            return 0;
        } else {
            return monthlyFee;
        }
    }

    /**
     * Checks if monthly fee is waived
     * @param withdrawals amount of withdrawals performed thus far on account
     * @return
     */
    public boolean feeWaived(int withdrawals) {
        if (withdrawals > 6) {
            return false;
        }
        return true;
    }

    /**
     * Getter method for withdrawals
     * @return number of withdrawals
     */
    public int getWithdrawals() {
        return withdrawals;
    }

    /**
     * Setter method for withdrawals
     * @param newWithdrawals number of withdrawals to be set
     */
    public void setWithdrawals(int newWithdrawals) {
        withdrawals = newWithdrawals;
    }

    @Override
    /**
     * Returns super.toString() and number of withdrawals
     * @return Returns super.toString() and number of withdrawals
     */
    public String toString() {
        if (withdrawals == 1) {
            return super.toString() + "*" + withdrawals + " withdrawal*";

        }
        return super.toString() + "*" + withdrawals + " withdrawals*";
    }

}