package model; /**
 *  Array based container class for database of accounts.
 *  @author Shankar Kohli, Eshaan Gandhi
 */

import java.text.DecimalFormat;

public class AccountDatabase {

    private Account[] accounts;
    private int size;

    /**
     * Constructor for AccountsDatabase
     * @param accounts Array of accounts
     * @param size size of array
     */
    public AccountDatabase(Account[] accounts, int size) {
        this.accounts = accounts;
        this.size = size;
    }

    /**
     * Default constructor, initializes size to 0, length of array to 5
     */
    public AccountDatabase() {
        accounts = new Account[5];
        size = 0;
    }

    /**
     * Public getter of the database
     * @return accounts array
     */
    public Account[] getAccounts() {
        return accounts;
    }

    /**
     * public getter of size
     * @return accounts current size
     */
    public int getSize() {
        return size;
    }

    /**
     * Finds the item in the accountDatabase.Account array.
     * @param account to be found in the array.
     * @return returns the index of the account in the array if found. Returns -1 if not found.
     */
    private int find(Account account) {
        for (int i = 0; i<size; i++) {
            if (accounts[i].equals(account)) {
                return i; //return the index when the item is found
            }
        }
        return -1; //returns -1 if the item is not found in the bad array
    } // helper method to find an item

    /**
     * Grows the capacity of the accountDatabase.Account array by 5 whenever needed
     */
    private void grow() {
        Account[] newAccounts = new Account[accounts.length + 5];
        System.arraycopy(accounts, 0, newAccounts, 0, accounts.length);
        accounts = newAccounts;
    }

    /**
     * Adds an account to the accountDatabase.Account array
     * @param account to be added to the array
     * @return false if account exists, true if account added successfully
     */
    public boolean add(Account account) {
        if (find(account) != -1) {
            return false;
        }

        if (size + 1 > accounts.length) {
            grow();
        }
        accounts[size] = account;
        size++;

        return true;
    } //return false if account exists

    /**
     * Removes an account to the accountDatabase.Account array
     * @param account to be removed from the array
     * @return false if account does not exist, true if account removed successfully
     */
    public boolean remove(Account account) {
        int index = find(account);
        if (index == -1) { //the item was not found
            return false;
        }
        accounts[index] = accounts[size - 1];
        accounts[size - 1] = null;
        size--;
        return true;
    } //return false if account doesn’t exist

    /**
     * Deposits given amount into account
     * @param account to deposit into
     * @param amount amount to deposit
     * @return false if account does not exist, true if deposit successful
     */
    public boolean deposit(Account account, double amount) {
        int index = find(account);
        if (index == -1) { //the item was not found
            return false;
        }
        if (amount<0){
            return false;
        }

        double newBalance = accounts[index].getBalance() + amount;
        accounts[index].setBalance(newBalance);

        return true;
    }

    /**
     * Withdraws given amount from account
     * @param account to withdraw from
     * @param amount amount to withdraw
     * @return return 0: withdrawal successful, 1: insufficient funds, -1 account doesn’t exist
     */

    public int withdrawal(Account account, double amount) {
        int index = find(account);
        if (index == -1) { //the item was not found
            return -1;
        }

        if (accounts[index].getBalance() - amount<0) { //account has insufficient funds
            return 1;
        }

        double newBalance = accounts[index].getBalance() - amount;
        accounts[index].setBalance(newBalance);
        if (accounts[index] instanceof MoneyMarket) {
            MoneyMarket test = (MoneyMarket) accounts[index];
            test.setWithdrawals(test.getWithdrawals() + 1);
            accounts[index] = test;
        }
        return 0;
    }

    /**
     * Sorts array by date in ascending order, calls helper method
     */
    private void sortByDateOpen() {
        dateSort(accounts, 0, size - 1);

    }

    /**
     * Sorts array by name in ascending order, calls helper method
     */
    private void sortByLastName() {
        nameSort(accounts, 0, size - 1);

    }

    /**
     * Prints array sorted by date in ascending order. Prints interest, monthly fee, and new balance.
     */
    public String printByDateOpen() {
        String output = "";
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        if (size == 0) {
            return "Database is empty.\n";

        }
        sortByDateOpen();
        output += "\n";
        output += "--Printing statements by last name--\n";
        output += "\n";
        for (int i = 0; i<size; i++) {
            if (accounts[i].getClass().getName() == "accountDatabase.MoneyMarket") {
                output += "*Money Market*" + accounts[i].toString() + "\n";
            }else{
                output += "*" + accounts[i].getClass().getName() + "*" + accounts[i].toString() + "\n";
            }
            output += "-interest: $ " + decimalFormat.format(accounts[i].monthlyInterest()) + "\n";
            output += "-fee: $ " + decimalFormat.format(accounts[i].monthlyFee()) + "\n";
            accounts[i].setBalance(accounts[i].getBalance() + accounts[i].monthlyInterest() - accounts[i].monthlyFee());
            output += "-new balance: $ " + decimalFormat.format(accounts[i].getBalance()) + "\n";
            if (i<size - 1) {
                output += "\n";
            } else {
                output += "--end of printing--\n";
            }

        }
        return output;
    }

    /**
     * Prints array sorted by name in ascending order. Prints interest, monthly fee, and new balance.
     */
    public String printByLastName() {
        String output = "";
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        if (size == 0) {
            return "Database is empty.\n";

        }
        sortByLastName();
        output += "\n";
        output += "--Printing statements by last name--\n";
        output += "\n";
        for (int i = 0; i<size; i++) {
            if (accounts[i].getClass().getName() == "accountDatabase.MoneyMarket") {
                output += "*Money Market*" + accounts[i].toString() + "\n";
            }else{
                output += "*" + accounts[i].getClass().getName() + "*" + accounts[i].toString() + "\n";
            }
            output += "-interest: $ " + decimalFormat.format(accounts[i].monthlyInterest()) + "\n";
            output += "-fee: $ " + decimalFormat.format(accounts[i].monthlyFee()) + "\n";
            accounts[i].setBalance(accounts[i].getBalance() + accounts[i].monthlyInterest() - accounts[i].monthlyFee());
            output += "-new balance: $ " + decimalFormat.format(accounts[i].getBalance()) + "\n";
            if (i<size - 1) {
                output += "\n";
            } else {
                output += "--end of printing--\n";
            }

        }
        return output;

    }

    /**
     * Prints unsorted Array. Prints type of account, profile, date opened, and any special account characteristics
     */
    public String printAccounts() {
        String output = "";
        if (size == 0) {
            return "Database is empty\n";
        }
        output += "--Listing accounts in the database--\n";
        for (int i = 0; i<size; i++) {
            if (accounts[i].getClass().getName() == "accountDatabase.MoneyMarket") {
                output += "*Money Market*" + accounts[i].toString() +"\n";
            } else {
                output+= ("*" + accounts[i].getClass().getName() + "*" + accounts[i].toString()) + "\n";
            }
        }
        return output += "--end of listing--\n";
    }

    /**
     *Helper method for Quicksort implementation to sort by dates in ascending order
     * @param arr Array of accounts to be sorted
     * @param low Starting index
     * @param high Ending index
     * @return partition index
     */
    public int dateSortHelper(Account arr[], int low, int high) {
        Account pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j<high; j++) {
            // If current element is smaller than the pivot
            if (arr[j].getDateOpen().compareTo(pivot.getDateOpen()) == -1) {
                i++;

                // swap arr[i] and arr[j]
                Account temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Account temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     *Recursive Quicksort implemention to sort by date in ascending order
     * @param arr Array of accounts to be sorted
     * @param low Starting index
     * @param high Ending index
     */
    public void dateSort(Account arr[], int low, int high) {
        if (low<high) {
            int partitionIndex = dateSortHelper(arr, low, high);

            // Recursively sort elements
            dateSort(arr, low, partitionIndex - 1);
            dateSort(arr, partitionIndex + 1, high);
        }
    }

    /**
     *Recursive Quicksort implemention to sort by name in ascending order
     * @param arr Array of accounts to be sorted
     * @param low Starting index
     * @param high Ending index
     */
    public void nameSort(Account arr[], int low, int high) {
        if (low<high) {
            int partitionIndex = nameSortHelper(arr, low, high);

            // Recursively sort elements
            nameSort(arr, low, partitionIndex - 1);
            nameSort(arr, partitionIndex + 1, high);
        }
    }

    /**
     *Helper method for Quicksort implementation to sort by name in ascending order
     * @param arr Array of accounts to be sorted
     * @param low Starting index
     * @param high Ending index
     * @return partition index
     */
    public int nameSortHelper(Account arr[], int low, int high) {
        Account pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j<high; j++) {
            // If current element is smaller than the pivot
            if (arr[j].getHolder().compareTo(pivot.getHolder()) == -1) {
                i++;

                // swap arr[i] and arr[j]
                Account temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Account temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * Finds account and returns it
     * @param accountDB the account database
     * @param name the profile of customer
     * @param accountType the account type
     * @return the instance of the account
     */
    public Account getAccount(AccountDatabase accountDB, Profile name, char accountType) {
        Account[] arr = accountDB.getAccounts();
        int size = accountDB.getSize();
        for (int i = 0; i<size; i++) {
            Profile temp = arr[i].getHolder();
            if (temp.equals(name)) {
                if (accountType == 'C') {
                    if (arr[i] instanceof Checking)
                        return arr[i];
                } else if (accountType == 'S') {
                    if (arr[i] instanceof Savings)
                        return arr[i];
                } else if (accountType == 'M') {
                    if (arr[i] instanceof MoneyMarket)
                        return arr[i];
                }
            }
        }
        return null;
    }


}