package controller;

import model.*;
import model.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.io.File;
import javax.swing.JFileChooser;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;


public class TransactionController {
    private AccountDatabase accDB = new AccountDatabase();

    @FXML
    private TextField firstNameOpen, lastNameOpen, balance, month, day, year, depositAmount, withdrawalAmount, firstNameClose, lastNameClose, firstNameDeposit, lastNameDeposit, firstNameWithdraw, lastNameWithdraw;

    @FXML
    private Button done;

    @FXML
    private RadioButton checkingButtonOpen, savingButtonOpen, moneyMarketButtonOpen;

    @FXML
    private RadioButton checkingButtonClose, savingButtonClose, moneyMarketButtonClose;

    @FXML
    private RadioButton checkingButtonDeposit, savingButtonDeposit, moneyMarketButtonDeposit;

    @FXML
    private RadioButton checkingButtonWithdrawal, savingButtonWithdrawal, moneyMarketButtonWithdrawal;

    @FXML
    private RadioButton printA, printL, printD;

    @FXML
    private CheckBox directDeposit, loyalCustomer;

    @FXML
    private TextArea transactionOutput;

    @FXML
    private TextField filename;

    @FXML
    /**
     * Event Handler for the clear message area button
     * @param event
     */
    void clear(ActionEvent event) {
        transactionOutput.clear();
    }
    @FXML
    /**
     * Event Handler for select checking radio button for tab open
     * @param event
     */
    void selectCheckingOpen(ActionEvent event) {
        savingButtonOpen.setSelected(false);
        moneyMarketButtonOpen.setSelected(false);
        directDeposit.setSelected(false);
        loyalCustomer.setSelected(false);
        directDeposit.setDisable(false);
        loyalCustomer.setDisable(true);
    }

    @FXML
    /**
     * Event Handler for the select savings radio button for tab open
     * @param event
     */
    void selectSavingsOpen(ActionEvent event) {
        checkingButtonOpen.setSelected(false);
        moneyMarketButtonOpen.setSelected(false);
        directDeposit.setSelected(false);
        loyalCustomer.setSelected(false);
        directDeposit.setDisable(true);
        loyalCustomer.setDisable(false);
    }

    @FXML
    /**
     * Event Handler for the select money market radio button for tab open
     * @param event
     */
    void selectMoneyMarketOpen(ActionEvent event) {
        checkingButtonOpen.setSelected(false);
        savingButtonOpen.setSelected(false);
        directDeposit.setSelected(false);
        loyalCustomer.setSelected(false);
        directDeposit.setDisable(true);
        loyalCustomer.setDisable(true);
    }

    @FXML
    /**
     * Event Handler for select checking radio button for tab close
     * @param event
     */
    void selectCheckingClose(ActionEvent event) {
        savingButtonClose.setSelected(false);
        moneyMarketButtonClose.setSelected(false);
    }

    @FXML
    /**
     * Event Handler for the select savings radio button for tab close
     * @param event
     */
    void selectSavingsClose(ActionEvent event) {
        checkingButtonClose.setSelected(false);
        moneyMarketButtonClose.setSelected(false);
    }

    @FXML
    /**
     * Event Handler for the select money market radio button for tab close
     * @param event
     */
    void selectMoneyMarketClose(ActionEvent event) {
        checkingButtonClose.setSelected(false);
        savingButtonClose.setSelected(false);
    }

    @FXML
    /**
     * Event Handler for the select checking radio button for tab deposit
     * @param event
     */
    void selectCheckingDeposit(ActionEvent event) {
        savingButtonDeposit.setSelected(false);
        moneyMarketButtonDeposit.setSelected(false);
    }

    @FXML
    /**
     * Event Handler for the select savings radio button for tab deposit
     * @param event
     */
    void selectSavingsDeposit(ActionEvent event) {
        checkingButtonDeposit.setSelected(false);
        moneyMarketButtonDeposit.setSelected(false);
    }

    @FXML
    /**
     * Event Handler for the select money market radio button for tab deposit
     * @param event
     */
    void selectMoneyMarketDeposit(ActionEvent event) {
        checkingButtonDeposit.setSelected(false);
        savingButtonDeposit.setSelected(false);
    }

    @FXML
    /**
     * Event Handler for the select checking radio button for tab deposit
     * @param event
     */
    void selectCheckingWithdraw(ActionEvent event) {
        savingButtonWithdrawal.setSelected(false);
        moneyMarketButtonWithdrawal.setSelected(false);
    }

    @FXML
    /**
     * Event Handler for the select savings radio button for tab deposit
     * @param event
     */
    void selectSavingsWithdraw(ActionEvent event) {
        checkingButtonWithdrawal.setSelected(false);
        moneyMarketButtonWithdrawal.setSelected(false);
    }

    @FXML
    /**
     * Event Handler for the select money market radio button for tab deposit
     * @param event
     */
    void selectMoneyMarketWithdraw(ActionEvent event) {
        checkingButtonWithdrawal.setSelected(false);
        savingButtonWithdrawal.setSelected(false);
    }


    /**
     * Helper function to grab first and last name of input for tab open
     * @return profile of account
     */
    Profile getProfile() {
        String first = firstNameOpen.getText();
        String last = lastNameOpen.getText();
        first = first.trim();
        last = last.trim();
        if ( first.trim().equals("") || last.trim().equals("") ) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Empty String for Name");
            alert.setContentText("Please enter a string for name.");
            alert.showAndWait();
            return null;
        }
        return new Profile(first, last);
    }

    /**
     * Helper function to grab first and last name of input for tab close
     * @return profile of account
     */
    Profile getProfileClose() {
        String first1 = firstNameClose.getText();
        String last1 = lastNameClose.getText();
        first1 = first1.trim();
        last1 = last1.trim();
        if ( first1.trim().equals("") || last1.trim().equals("") ) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Empty String for Name");
            alert.setContentText("Please enter a string for name.");
            alert.showAndWait();
            return null;
        }
        return new Profile(first1, last1);
    }

    /**
     * Helper function to grab first and last name of input for tab deposit
     * @return profile of account
     */
    Profile getProfileDeposit() {
        String first2 = firstNameDeposit.getText();
        String last2 = lastNameDeposit.getText();
        first2 = first2.trim();
        last2= last2.trim();
        if ( first2.trim().equals("") || last2.trim().equals("") ) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Empty String for Name");
            alert.setContentText("Please enter a string for name.");
            alert.showAndWait();
            return null;
        }
        return new Profile(first2, last2);
    }

    /**
     * Helper function to grab first and last name of input for tab withdraw
     * @return profile of account
     */
    Profile getProfileWithdraw() {

        String first2 = firstNameWithdraw.getText();
        String last2 = lastNameWithdraw.getText();
        first2 = first2.trim();
        last2 = last2.trim();
        if ( first2.trim().equals("") || last2.trim().equals("") ) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Empty String for Name");
            alert.setContentText("Please enter a string for name.");
            alert.showAndWait();
            return null;
        }
        return new Profile(first2, last2);
    }


    /**
     * Helper function to grab day, month, year of input
     * @return accountDatabase.Date of accountDatabase.Account
     */
    model.Date getDate() {
        //grab date -> check if valid date
        String dd;
        String mm;
        String yyyy;
        try {
            dd = day.getText();
            mm = month.getText();
            yyyy = year.getText();
        }
        catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Non numeric data has been entered.");
            alert.setContentText("Please enter a Integer for date fields.");
            alert.showAndWait();
            return null;
        }
        model.Date openDate = new model.Date(mm+"/"+dd+"/"+yyyy);
        if (!openDate.isValid()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Invalid accountDatabase.Date!.");
            alert.setContentText("Please enter a valid date.");
            alert.showAndWait();
            return null;
        }
        return openDate;
    }

    /**
     * Helper function to grab balance from input
     * @return Initial Balance of accountDatabase.Account
     */
    double getBalance() {
        double bal = 0.0;
        //grab balance -> check if valid balance
        try {
            bal = Double.parseDouble(balance.getText());
        }
        catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Non numeric data has been entered.");
            alert.setContentText("Please enter a double for balance.");
            alert.showAndWait();
            return -1;
        }
        if(bal < 0){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Negative number has been entered.");
            alert.setContentText("Please enter a positive number for balance.");
            alert.showAndWait();
            return -1;
        }
        return bal;
    }

    /**
     * Helper function to grab deposit balance from input
     * @return Deposit Amount Entered
     */
    double getDeposit() {
        double deposit = 0.0;
        //grab balance -> check if valid balance
        try {
            deposit = Double.parseDouble(depositAmount.getText());
        }
        catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Non numeric data has been entered.");
            alert.setContentText("Please enter a double for deposit.");
            alert.showAndWait();
            return -1;
        }
        if(deposit < 0){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Negative number has been entered.");
            alert.setContentText("Please enter a positive number for deposit.");
            alert.showAndWait();
            return -1;
        }
        return deposit;
    }

    /**
     * Helper function to grab withdrawal amount from input
     * @return withdrawal amount
     */
    double getWithdraw() {
        double withdrawal = 0.0;
        try {
            withdrawal = Double.parseDouble(withdrawalAmount.getText());
        }
        catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Non numeric data has been entered.");
            alert.setContentText("Please enter a double for withdrawal.");
            alert.showAndWait();
            return -1;
        }
        if(withdrawal < 0){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Negative number has been entered.");
            alert.setContentText("Please enter a positive number for withdrawal.");
            alert.showAndWait();
            return -1;
        }
        return withdrawal;
    }




    /**
     * Helper function to return an accountDatabase.Account Object from inputs
     * @return New accountDatabase.Account
     */
    public Account createAccount() {
        Profile prof = getProfile();
        if( prof == null ) {
            return null;
        }
        model.Date openDate = getDate();
        if( openDate == null ) {
            return null;
        }
        double bal = getBalance();
        if ( bal == -1 ) {
            return null;
        }
        Account acc = null;
        int withdraws = 0;
        Boolean isSpecial = false;

        //Check account type and any special type
        if (checkingButtonOpen.isSelected()) {
            isSpecial = directDeposit.isSelected();
            acc = new Checking(prof, bal, openDate, isSpecial);
        }
        else if (savingButtonOpen.isSelected()) {
            isSpecial = loyalCustomer.isSelected();
            acc = new Savings(prof, bal, openDate, isSpecial);
        }
        else if (moneyMarketButtonOpen.isSelected()) {
            acc = new MoneyMarket(prof, bal, openDate, withdraws);
        }
        else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("No accountDatabase.Account Selected.");
            alert.setContentText("Please select an account type.");
            alert.showAndWait();
            return null;
        }
    return acc;
    }


    @FXML
    /**
     * Action Handler for deposit amount in account
     * @param event
     */
    public void deposit(ActionEvent event){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        Profile prof = getProfileDeposit();
        char t;
        double depositAmount = getDeposit();
        if(prof == null){
            return;
        }
        if(depositAmount<0){
            return;
        }
//        accountDatabase.Date openDate = getDate();
//        if( openDate == null ) {
//            return;
//        }

        if ( checkingButtonDeposit.isSelected() ) {
            t = 'C';
        }
        else if ( savingButtonDeposit.isSelected() ) {
            t = 'S';
        }
        else if ( moneyMarketButtonDeposit.isSelected() ) {
            t = 'M';
        }
        else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("No accountDatabase.Account Selected.");
            alert.setContentText("Please select an account type.");
            alert.showAndWait();
            return;
        }
        Account acc = accDB.getAccount(accDB, prof, t);
        if (acc == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("accountDatabase.Account does not exist.");
            alert.showAndWait();
            return;
        }
        if(accDB.deposit(acc, depositAmount)){
            transactionOutput.appendText(decimalFormat.format(depositAmount)+" Deposited\n");
        }
        else{
            transactionOutput.appendText("Deposit failed\n");
        }

    }
    @FXML
    /**
     * Action handler for withdraw from account
     * @param event
     */
    public void withdraw(ActionEvent event){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        Profile prof = getProfileWithdraw();
        char t;
        double withdraw = getWithdraw();
        if(withdraw<0){
            return;
        }
        if( prof == null ) {
            return;
        }
        model.Date openDate = getDate();
        if( openDate == null ) {
            return;
        }

        if (checkingButtonWithdrawal.isSelected()) {
            t = 'C';
        }
        else if ( savingButtonWithdrawal.isSelected() ) {
            t = 'S';
        }
        else if ( moneyMarketButtonWithdrawal.isSelected() ) {
            t = 'M';
        }
        else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("No accountDatabase.Account Selected.");
            alert.setContentText("Please select an account type.");
            alert.showAndWait();
            return;
        }
        Account acc = accDB.getAccount(accDB, prof, t);
        if (acc == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("accountDatabase.Account does not exist.");
            alert.showAndWait();
            return;
        }
        int b = accDB.withdrawal(acc, withdraw);
        if(b == 0){
            transactionOutput.appendText(decimalFormat.format(withdraw)+" withdrawn from account\n");
        }
        else if(b==1){
            transactionOutput.appendText("Insufficent funds\n");
        }
        else{
            transactionOutput.appendText("accountDatabase.Account not found\n");
        }

    }

    void clearFields() {
        firstNameOpen.clear();
        lastNameOpen.clear();
        day.clear();
        month.clear();
        year.clear();
        balance.clear();
        directDeposit.setDisable(false);
        loyalCustomer.setDisable(false);
        checkingButtonOpen.setSelected(false);
        directDeposit.setSelected(false);
        savingButtonOpen.setSelected(false);
        loyalCustomer.setSelected(false);
        moneyMarketButtonOpen.setSelected(false);
    }

    @FXML
    /**
     * Event Handler for the open account button
     * @param event
     */
    void openAccount(ActionEvent event) {

        Account acc = createAccount();
        if ( acc == null ) {
//            clearFields();
            return;
        }

        if( !accDB.add(acc) ) {
            transactionOutput.appendText("accountDatabase.Account is already in the database.\n");
        } else {
            transactionOutput.appendText("accountDatabase.Account opened and added to the database.\n");
        }
        return;
    }

    @FXML
    /**
     * Event Handler for the close account button
     * @param event
     */
    void closeAccount(ActionEvent event) {
        Profile prof = getProfileClose();
        if( prof == null ) {
            return;
        }

        char type = ' ';

        if (checkingButtonClose.isSelected() ) {
            type = 'C';
//            directDepositC.setSelected(false);
        }
        else if (savingButtonClose.isSelected() ) {
            type = 'S';
//            loyalCustomerCheck.setSelected(false);
        }
        else if (moneyMarketButtonClose.isSelected() ) {
            type = 'M';
        }
        else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("No accountDatabase.Account Selected.");
            alert.setContentText("Please select an account type.");
            alert.showAndWait();
            return;
        }

        Account acc = accDB.getAccount(accDB,prof, type);

        //check if account exists
        if( acc == null ) {
            transactionOutput.appendText("accountDatabase.Account does not exist.\n"); //error
            return;
        }

        //attempts to remove the account, reports if there is an error
        if( !accDB.remove(acc) ) {
            transactionOutput.appendText("Error in Removing accountDatabase.Account.\n"); //error
        } else {
            transactionOutput.appendText("accountDatabase.Account closed and removed from the database.\n"); //success
        }
        return;
    }
    @FXML
    /**
     * Event handler for print button
     * @param event
     */
    public void printAccounts(ActionEvent event) throws Exception{
        if(printA.isSelected()==true)
            transactionOutput.appendText(accDB.printAccounts());
        else if(printL.isSelected()==true)
            transactionOutput.appendText(accDB.printByLastName());
        else if(printD.isSelected()==true)
            transactionOutput.appendText(accDB.printByDateOpen());
        else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("No option selected.");
            alert.setContentText("Please select an option to print.");
            alert.showAndWait();
            return;
        }
    }
    @FXML
    /**
     * Event Handler for the print all accounts radio button
     * @param event
     */
    void selectPrintA(ActionEvent event) {
        printL.setSelected(false);
        printD.setSelected(false);
        return;
    }

    @FXML
    /**
     * Event Handler for the print by last name radio button
     * @param event
     */
    void selectPrintL(ActionEvent event) {
        printA.setSelected(false);
        printD.setSelected(false);
        return;
    }

    @FXML
    /**
     * Event Handler for the print by day radio button
     * @param event
     */
    void selectPrintD(ActionEvent event) {
        printL.setSelected(false);
        printA.setSelected(false);
        return;
    }

    /**
     * Helper method to get file name in drobbox in javafx
     * @return file object of file
     */
    public File getTheFileName() {
        JFileChooser fileChooser = new JFileChooser();
        File file = null;
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        return file;
    }

    @FXML
    /**
     * Event handler for importing database
     */
    public void reader(ActionEvent event) throws Exception{
        File file = getTheFileName();
//        File file = new File("/home/eshaan/CS213/JavaFXFirst/src/database.txt");
//        accountDatabase.AccountDatabase accountDB = new accountDatabase.AccountDatabase();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
//                System.out.println(s);
                StringTokenizer tokenizer = new StringTokenizer(s, ",");
                while (tokenizer.hasMoreTokens()) {
//                    String command = tokenizer.nextToken();
//                    System.out.println(command);
                    try {
                        String accountType = tokenizer.nextToken();
//                        System.out.println(accountType);
                        String firstName = tokenizer.nextToken();
//                        System.out.println(firstName);
                        String lastname = tokenizer.nextToken();
//                        System.out.println(lastname);
                        double startingBalance = Double.parseDouble(tokenizer.nextToken());
//                        System.out.println(startingBalance);
                        Date date = new model.Date(tokenizer.nextToken());
//                        System.out.println(date.toString());
                        if (!date.isValid()) {
                            System.out.println(date.toString() + " is not a valid date!");
                            break;
                        }
                        if (accountType.equals("S")) {
//                            System.out.println("here");
                            boolean isLoyal = parseBoolean(tokenizer.nextToken());
//                            System.out.println(isLoyal);
                            Account acc = new Savings(new Profile(firstName, lastname), startingBalance, date, isLoyal);
//                            System.out.println("here"+accDB.add(acc));
                        } else if (accountType.equals("C")) {
                            boolean directDeposit = parseBoolean(tokenizer.nextToken());
                            Account acc = new Checking(new Profile(firstName, lastname), startingBalance, date, directDeposit);
                            accDB.add(acc);
                        } else if (accountType.equals("M")) {
                            int withdrawals = Integer.parseInt(tokenizer.nextToken());
                            Account acc = new MoneyMarket(new Profile(firstName, lastname), startingBalance, date, withdrawals);
                            accDB.add(acc);
                        }
                        accDB.printAccounts();
                    } catch (NumberFormatException ex) {
//                        ex.printStackTrace();
                    } catch(InputMismatchException ex){
//                        ex.printStackTrace();
                    }
                    catch (NoSuchElementException ex){
//                        ex.printStackTrace();
                    }
//                    finally {
//                        scanner.close();
//
//                    }
                }
            }
        }catch(FileNotFoundException fileEx) {
            throw new FileNotFoundException();
        }

    }

    /**
     * Helper method to parse boolean value from user input and throw InputMismatchException if it occurs
     * @param bool String value from user input to evaluate
     * @return true if bool evaluates to "true"/"TRUE", false if bool evaluates to "false"/"FALSE", otherwise throws InputMismatchException
     */
    private boolean parseBoolean(String bool){

        if(bool.equalsIgnoreCase("true")){
            return true;
        }else if(bool.equalsIgnoreCase("false")){
            return false;
        }else{
            throw new InputMismatchException("Input data type mismatch.");
        }
    }

    private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    /**
     * Exports the account database to a file
     * @return content to be exported
     */
    public String export() {
        String content = "";
        Account accounts[] = accDB.getAccounts();
        for(int i =0; i<accDB.getSize();i++){

            if(accounts[i].getClass().getName().equals("accountDatabase.Savings")){
                content+="S,";
            }
            else if(accounts[i].getClass().getName().equals("accountDatabase.Checking")){
                content+="C,";
            }
            else{
                content+="M,";
            }
            content+=accounts[i].getHolder().getFirstName()+","+accounts[i].getHolder().getLastName()+","+accounts[i].getBalance()+","+accounts[i].getDateOpen().toString()+",";
            if(accounts[i].getClass().getName().equals("accountDatabase.Savings")){
                Savings temp = (Savings)accounts[i];
                content+=Boolean.toString(temp.getLoyal());
            }
            else if(accounts[i].getClass().getName().equals("accountDatabase.Checking")){
                Checking temp = (Checking)accounts[i];
                content+=Boolean.toString(temp.getDirectDeposit());
            }
            else{
                MoneyMarket temp = (MoneyMarket) accounts[i];
                content+=Integer.toString(temp.getWithdrawals());
            }
            content+="\n";
        }
        return content;

    }

    @FXML
    /**
     * Export accounts into a text file
     * @param event the event object
     */
    void exportFile(ActionEvent event) {
        //gets the filename and makes a file object with it
        String fn = filename.getText();
        File file = new File((fn + ".txt"));

        //checks if file exists
        if(file.exists()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Cannot use this file name");
            alert.setContentText("This file already exists.\n");
            alert.showAndWait();
            return;
        }

        try {
            //create the file
            file.createNewFile();

            //go through the database and write the files in
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(export());
            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //writes to the log that the export was successful
        transactionOutput.appendText("Database information saved in file " + filename.getText() + ".txt\n");
        filename.clear();

        return;
    }

}
