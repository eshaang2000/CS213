/**
 * User interface class that handles the transactions and displays the results on the console
 *  @author Shankar Kohli, Eshaan Gandhi
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TransactionManager {

    /**
     * Run method for I/O, called by RunProject2
     */
    public void run() {
        System.out.println("Transaction processing starts....");
        AccountDatabase accountDB = new AccountDatabase();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
            while (tokenizer.hasMoreTokens()) {
                String command = tokenizer.nextToken(" ");

                try {
                    if (command.equals("OC")) {
                        String firstName = tokenizer.nextToken();
                        String lastname = tokenizer.nextToken();
                        double startingBalance = Double.parseDouble(tokenizer.nextToken());
                        Date date = new Date(tokenizer.nextToken());
                        if(!date.isValid()){
                            System.out.println(date.toString() + " is not a valid date!");
                            break;
                        }
                        boolean directDeposit = parseBoolean(tokenizer.nextToken());
                        Account acc = new Checking(new Profile(firstName, lastname), startingBalance, date, directDeposit);
                        if (!accountDB.add(acc)) {
                            System.out.println("Account is already in the database.");
                        } else {
                            System.out.println("Account opened and added to the database.");
                        }
                    } else if (command.equals("OS")) {
                        String firstName = tokenizer.nextToken();
                        String lastname = tokenizer.nextToken();
                        double startingBalance = Double.parseDouble(tokenizer.nextToken());
                        Date date = new Date(tokenizer.nextToken());
                        if(!date.isValid()){
                            System.out.println(date.toString() + " is not a valid date!");
                            break;
                        }
                        boolean loyalty = parseBoolean(tokenizer.nextToken());
                        Account acc = new Savings(new Profile(firstName, lastname), startingBalance, date, loyalty);
                        if (!accountDB.add(acc)) {
                            System.out.println("Account is already in the database.");
                        } else {
                            System.out.println("Account opened and added to the database.");
                        }
                    } else if (command.equals("OM")) {
                        String firstName = tokenizer.nextToken();
                        String lastname = tokenizer.nextToken();
                        int startingWithdrawals = 0;
                        double startingBalance = Double.parseDouble(tokenizer.nextToken());
                        Date date = new Date(tokenizer.nextToken());
                        if(!date.isValid()){
                            System.out.println(date.toString() + " is not a valid date!");
                            break;
                        }
                        Account acc = new MoneyMarket(new Profile(firstName, lastname), startingBalance, date,startingWithdrawals);
                        if (!accountDB.add(acc)) {
                            System.out.println("Account is already in the database.");
                        } else {
                            System.out.println("Account opened and added to the database.");
                        }

                    }

                    else if (command.equals("CC")) {
                        String firstName = tokenizer.nextToken();
                        String lastname = tokenizer.nextToken();
                        Account acc = accountDB.getAccount(accountDB, new Profile(firstName, lastname), 'C');
                        if (acc == null) {
                            System.out.println("Account does not exist.");
                        } else if (!accountDB.remove(acc)) {
                            System.out.println("Account does not exist.");
                        } else {
                            System.out.println("Account closed and removed from the database.");
                        }

                    } else if (command.equals("CS")) {

                        String firstName = tokenizer.nextToken();
                        String lastname = tokenizer.nextToken();
                        Account acc = accountDB.getAccount(accountDB, new Profile(firstName, lastname), 'S');
                        if (acc == null) {
                            System.out.println("Account does not exist.");
                        } else if (!accountDB.remove(acc)) {
                            System.out.println("Account does not exist.");
                        } else {
                            System.out.println("Account closed and removed from the database.");
                        }

                    } else if (command.equals("CM")) {

                        String firstName = tokenizer.nextToken();
                        String lastname = tokenizer.nextToken();
                        Account acc = accountDB.getAccount(accountDB, new Profile(firstName, lastname), 'M');
                        if (acc == null) {
                            System.out.println("Account does not exist.");
                        } else if (!accountDB.remove(acc)) {
                            System.out.println("Account does not exist.");
                        } else {
                            System.out.println("Account closed and removed from the database.");
                        }

                    }

                    else if (command.equals("DC")) {
                        String firstName = tokenizer.nextToken();
                        String lastname = tokenizer.nextToken();
                        double depositAmount = Double.parseDouble(tokenizer.nextToken());
                        Profile holder = new Profile(firstName, lastname);
                        Account acc = accountDB.getAccount(accountDB, holder, 'C');
                        if (acc == null) {
                            System.out.println("Account does not exist.");

                        }

                        //remove that account
                        else if (accountDB.deposit(acc, depositAmount)) {
                            System.out.println(String.format("%.02f",depositAmount) + " deposited to account.");

                        }
                    } else if (command.equals("DS")) {

                        String firstName = tokenizer.nextToken();
                        String lastname = tokenizer.nextToken();
                        double depositAmount = Double.parseDouble(tokenizer.nextToken());
                        Profile holder = new Profile(firstName, lastname);
                        Account acc = accountDB.getAccount(accountDB, holder, 'S');
                        if (acc == null) {
                            System.out.println("Account does not exist.");

                        } else if (accountDB.deposit(acc, depositAmount)) {
                            System.out.println(String.format("%.02f",depositAmount) + " deposited to account.");

                        }

                    } else if (command.equals("DM")) {
                        String firstName = tokenizer.nextToken();
                        String lastname = tokenizer.nextToken();
                        double depositAmount = Double.parseDouble(tokenizer.nextToken());
                        Profile holder = new Profile(firstName, lastname);
                        Account acc = accountDB.getAccount(accountDB, holder, 'M');
                        if (acc == null) {
                            System.out.println("Account does not exist.");

                        }
                        else if (accountDB.deposit(acc, depositAmount)) {
                            System.out.println(String.format("%.02f",depositAmount) + " deposited to account.");

                        }

                    }
                    else if (command.equals("WC")) {

                        String firstName = tokenizer.nextToken();
                        String lastname = tokenizer.nextToken();
                        double withdrawAmount = Double.parseDouble(tokenizer.nextToken());
                        Profile holder = new Profile(firstName, lastname);
                        Account acc = accountDB.getAccount(accountDB, holder, 'C');
                        if (acc == null) {
                            System.out.println("Account does not exist.");
                        }
                        else if (accountDB.withdrawal(acc, withdrawAmount) == 0) {
                            System.out.println(String.format("%.02f",withdrawAmount) + " withdrawn from account.");

                        } else if (accountDB.withdrawal(acc, withdrawAmount) == 1) {
                            System.out.println("Insufficient funds");
                        } else if (accountDB.withdrawal(acc, withdrawAmount) == -1) {
                            System.out.println("Account does not exist.");
                        }



                    } else if (command.equals("WS")) {
                        String firstName = tokenizer.nextToken();
                        String lastname = tokenizer.nextToken();
                        double withdrawAmount = Double.parseDouble(tokenizer.nextToken());
                        Profile holder = new Profile(firstName, lastname);
                        Account acc = accountDB.getAccount(accountDB, holder, 'S');
                        withdraw(accountDB, withdrawAmount, acc);
                    } else if (command.equals("WM")) {
                        String firstName = tokenizer.nextToken();
                        String lastname = tokenizer.nextToken();
                        double withdrawAmount = Double.parseDouble(tokenizer.nextToken());
                        Profile holder = new Profile(firstName, lastname);
                        Account acc = accountDB.getAccount(accountDB, holder, 'M');
                        withdraw(accountDB, withdrawAmount, acc);
                    } else if (command.equals("PA")) {
                        accountDB.printAccounts();
                    } else if (command.equals("PD")) {
                        accountDB.printByDateOpen();
                    } else if (command.equals("PN")) {
                        accountDB.printByLastName();
                    } else if (command.equals("Q")) {
                        System.out.println();
                        System.out.println("Transaction processing completed.");
                        System.exit(0);
                    } else {
                        System.out.println("Command '" + command + "' not supported!");
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input data type mismatch.");
                    break;
                } catch (InputMismatchException e){
                    System.out.println("Input data type mismatch.");
                    break;
                }


            }
        }
    }

    /**
     * Helper method to output withdrawal status
     * @param accountDB AccountDatabase object
     * @param withdrawAmount Amount to be withdrawn
     * @param acc Account to withdraw from
     */
    private void withdraw(AccountDatabase accountDB, double withdrawAmount, Account acc) {
        if (acc == null) {
            System.out.println("Account does not exist.");
        }
        else if (accountDB.withdrawal(acc, withdrawAmount) == 0) {
            System.out.println(String.format("%.02f",withdrawAmount) + " withdrawn from account.");

        } else if (accountDB.withdrawal(acc, withdrawAmount) == 1) {
            System.out.println("Insufficient funds.");
        } else if (accountDB.withdrawal(acc, withdrawAmount) == -1) {
            System.out.println("Account does not exist.");
        }



    }

    /**
     * Helper method to parse boolean value from user input and throw InputMismatchException if it occurs
     * @param bool String value from user input to evaluate
     * @return true if bool evaluates to "true"/"TRUE", false if bool evaluates to "false"/"FALSE", otherwise throws InputMismatchException
     */
    private static boolean parseBoolean(String bool){

        if(bool.equalsIgnoreCase("true")){
            return true;
        }else if(bool.equalsIgnoreCase("false")){
            return false;
        }else{
            throw new InputMismatchException("Input data type mismatch.");
        }
    }




}