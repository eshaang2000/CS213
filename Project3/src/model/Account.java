package model; /**
 * Abstract class that defines common account features for all account types, such as balance, holder, and date opened
 * @author Shankar Kohli, Eshaan Gandhi
 */

import java.text.DecimalFormat;

public abstract class Account {
    private Profile holder;
    private double balance;
    private Date dateOpen;

    /**
     * Default constructor for accountDatabase.Account superclass
     */
    public Account() {
        holder = null;
        balance = 0;
        dateOpen = null;

    }

    /**
     * Parametrized accountDatabase.Account constructor
     * @param holder account holder
     * @param balance account balance
     * @param dateOpen date account opened
     */
    public Account(Profile holder, double balance, Date dateOpen) {
        this.holder = holder;
        this.balance = balance;
        this.dateOpen = dateOpen;
    }

    /**
     * Getter method to get balance
     * @return account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Getter method to get date account was opened
     * @return dateOpen
     */
    public Date getDateOpen() {
        return dateOpen;
    }

    /**
     * Getter method to get account holder
     * @return holder of account
     */
    public Profile getHolder() {
        return holder;
    }

    /**
     * Debit account
     * @param amount amount to debit account by
     */
    public void debit(double amount) {
        balance -= amount;
    } //decrease the balance by amount

    /**
     * Credit account
     * @param amount amount to credit account by
     */
    public void credit(double amount) {
        balance += amount;
    } //increase the balance by amount

    /**
     * Superclass toString() method
     * @return string representation of class fields, including holder, balance, and dateOpen
     */
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        return (holder.getFirstName() + " " + holder.getLastName() + "* $" + decimalFormat.format(balance) + "*" + dateOpen.toString());
    }

    /**
     * Abstract method to calculate monthly interest
     * @return monthly interest
     */
    public abstract double monthlyInterest();

    /**
     * Abstract method to calculate monthly fee
     * @return monthly fee
     */
    public abstract double monthlyFee();

    /**
     * Equals method to compare two accounts
     * @param obj accountDatabase.Account to be compared
     * @return true if accounts are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        Account acc = (Account) obj;
        if (acc.getHolder().equals(this.holder)) {
            if (acc.getBalance() == this.balance) {
                if (acc.getDateOpen().compareTo(this.dateOpen) == 0) {
                    if (acc.getClass().getName() == this.getClass().getName()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Setter method for balance
     * @param newBalance new balance
     */
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    /**
     * Setter method for dateOpen
     * @param date to be set
     */
    public void setDateOpen(Date date) {
        this.dateOpen = date;
    }

    /**
     * Setter method for account holder
     * @param profile profile to be set
     */
    public void setHolder(Profile profile) {
        this.holder = profile;
    }

}