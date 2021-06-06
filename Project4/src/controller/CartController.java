/**
 *  Controller class for second stage of GUI, order details
 *  @author Shankar Kohli, Eshaan Gandhi
 */

package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class CartController {

    Stage primaryStage;

    @FXML
    ListView<String> displayOrder;

    @FXML
    TextField priceLabel;

    @FXML
    TextArea filename;

    Order order = new Order();


    @FXML
    /**
     * Goes back to the Order menu GUI
     */
    public void back(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/OrderView.fxml"));
            VBox root = (VBox)loader.load();
            OrderController controller = loader.getController();
            controller.start(primaryStage, order);
            Scene scene = new Scene(root,1200,800);
            primaryStage.setScene(scene);
            primaryStage.setTitle("My Sandwich Store");
            primaryStage.setResizable(true);
            primaryStage.show();
        } catch(Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
    @FXML
    /**
     * Initializes the GUI 
     */
    public void start(Stage primaryStage, Order order) throws IOException{
        this.order = order;
        this.primaryStage = primaryStage;
        updateList();
    }


    @FXML
    /**
     * Updates the serial number if need be
     */
    private void updateList() {
        ArrayList<OrderLine> orderList = order.getOrderlines();
        displayOrder.getItems().clear();
        for(OrderLine i: orderList){
            displayOrder.getItems().add(i.toString());
        }
        findPrice();
    }

    /**
     * Add a sandwich to the order and update it
     * @param ol
     */
    public void addAndUpdate(OrderLine ol) {
        boolean status = order.add(ol);
        if(!status) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Problem");
            alert.setHeaderText("Error adding order.");
            alert.setContentText("Failed to add the sandwich.");
            alert.showAndWait();
        }
        updateList();
    }

    /**
     * Fidnds the price of the order and the label equal to it
     */
    void findPrice() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        double price = 0;
        ArrayList<OrderLine> orderlines = order.getOrderlines();
        if(orderlines.size() == 0) {
            priceLabel.setText(decimalFormat.format(0));
            return;
        }
        for (OrderLine ol : orderlines) {
            price += ol.getPrice();
        }
        priceLabel.setText("$"+decimalFormat.format(price));
    }

    /**
     * Duplicate the chosen item in the order list
     */
    @FXML
    public void duplicate(ActionEvent e) {
        int i = displayOrder.getSelectionModel().getSelectedIndex();
        if(i < 0 || i >= order.getOrderlines().size()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Problem");
            alert.setHeaderText("No sandwich selected.");
            alert.setContentText("You must select a sandwich.");
            alert.showAndWait();
            return;
        }
        OrderLine oline = order.getOrderlines().get(i);
        OrderLine newOline = new OrderLine(order.getLineNumber(), oline.getSandwich(), oline.getPrice());
        addAndUpdate(newOline);
    }

    @FXML
    /**
     * Remove the chosen item in the order list
     */
    public void remove(ActionEvent e) {
        int i = displayOrder.getSelectionModel().getSelectedIndex();
        if(i < 0 || i >= order.getOrderlines().size()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Problem");
            alert.setHeaderText("No sandwich selected.");
            alert.setContentText("You must select a sandwich.");
            alert.showAndWait();
            return;
        }
        order.remove(order.getOrderlines().get(i));
        updateList();
    }

    @FXML
    /**
     * Clear all options
     */
    public void clearAll(ActionEvent e){
        order = new Order();
        updateList();
    }

    /**
     * Helper function to call without action event
     */
    public void clear(){
        clearAll(new ActionEvent());
        back(new ActionEvent());
    }

    /**
     * Save the order details to a file
     */
    @FXML
    public void saveOrder(ActionEvent e) {
        updateList();
        String filenameText = filename.getText();
        File file = new File((filenameText));
        if(file.exists()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Problem");
            alert.setHeaderText("File name unusable");
            alert.setContentText("This file already exists.\n");
            alert.showAndWait();
            return;
        }
        try {
            file.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(order.toString());
            bw.flush();
            bw.close();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        clear();
    }
}
