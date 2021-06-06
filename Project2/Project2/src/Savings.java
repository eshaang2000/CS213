/**
 *  Subclass of Account, holds various Savings accounts functions
 *  @author Shankar Kohli, Eshaan Gandhi
 */

public class Savings extends Account {

    private boolean isLoyal;


    public Savings(Profile holder, double balance, Date  dateOpen, boolean isLoyal){
        super(holder, balance, dateOpen);
        this.isLoyal = isLoyal;
    }

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

    @Override
    public String toString(){
        if(isLoyal){
            return super.toString() + "*special Savings account*";
        }

        return super.toString();
    }

}
