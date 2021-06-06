package model;

/**
 *  Subclass of accountDatabase.Account, holds various accountDatabase.Savings accounts functions
 *  @author Shankar Kohli, Eshaan Gandhi
 */

public class Savings extends Account {

    private boolean isLoyal;


    /**
     * Parameterized constructor for accountDatabase.Savings account
     * @param holder accountDatabase.Profile to be allocated the account
     * @param balance the initial balance
     * @param dateOpen the date the account was opened
     * @param isLoyal boolean value if a customer is loyal or not
     */
    public Savings(Profile holder, double balance, Date dateOpen, boolean isLoyal){
        super(holder, balance, dateOpen);
        this.isLoyal = isLoyal;
    }


    @Override
    /**
     * Calulates monthly interest
     * @return the monthly interest of a account
     */
    public double monthlyInterest(){
        double savingsInterest;
        double months = 12;

        if(isLoyal){
            savingsInterest = 0.0035;
        }else{
            savingsInterest = 0.0025;
        }

        double balance = getBalance();
        if(balance < 0){
            return 0;
        }
        return balance * savingsInterest/months;
    }

    @Override
    /**
     * Calculated the monthly fee
     * @return monthly fee of the account
     */
    public double monthlyFee(){
        double balance = getBalance();
        double waiveBalance = 300;
        double monthlyFee = 5;
        if(balance >= waiveBalance){
            return 0;
        }else{
            return monthlyFee;
        }
    }

    /**
     * public getter of isLoyal boolean
     * @return boolean of isLoyal
     */
    public boolean getLoyal(){
        return isLoyal;
    }
    @Override
    /**
     * Returns the string of a profile
     */
    public String toString(){
        if(isLoyal){
            return super.toString() + "*special accountDatabase.Savings account*";
        }

        return super.toString();
    }

}
