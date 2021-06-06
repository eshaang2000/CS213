/**
 *  Controller for first stage of GUI, sandwich ordering and store
 *  @author Shankar Kohli, Eshaan Gandhi
 */

package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

/**
 * Class to control the Sandwich GUI
 * @author Eshaan Gandhi, Shankar Kohli
 */
public class OrderController {
    @FXML
    TextArea output1;
    @FXML
    ComboBox<String> comboBox;
    @FXML
    ListView<Extra> extras;
    @FXML
    ImageView imagePlace;
    @FXML
    ListView<Extra> selectedExtras;
    @FXML
    TextArea priceCurrent;
    @FXML
    TextArea basicIngredients;
    @FXML
    Stage primaryStage;

    Order order = new Order();
    Sandwich currentSandwich;

    @FXML
    /**
     * Displays the extra ingredients on the GUI
     */
    public void displayExtras(){
        for(Extra i: Extra.values()){
            extras.getItems().add(i);
        }
    }

    /**
     * Ititializer method to set everything up when the GUI is switched
     * @param primaryStage Primary stage for the GUI
     * @param order The order object
     * @throws IOException
     */
    public void start(Stage primaryStage, Order order) throws IOException {
        this.order = order;
        this.primaryStage = primaryStage;
        comboBox.getItems().add("Chicken");
        comboBox.getItems().add("Beef");
        comboBox.getItems().add("Fish");
        comboBox.getSelectionModel().selectFirst();
        chooseSandwich();
    }


    @FXML
    /**
     * Allows the user to choose the sandwich and changes the images accordingly
     */
    public void chooseSandwich(){
        if(comboBox.getSelectionModel().getSelectedItem().equals("Chicken")) {
            currentSandwich = new Chicken();
            basicIngredients.clear();
            basicIngredients.appendText(currentSandwich.getBasicIngredientsString());
            try {
                FileInputStream input = new FileInputStream("src/view/chicken.jpeg");
                Image i = new Image(input);
                imagePlace.setImage(i);
                imagePlace.setX(5);
                imagePlace.setY(5);
                imagePlace.setFitWidth(450);
                imagePlace.setPreserveRatio(true);
                input.close();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(comboBox.getSelectionModel().getSelectedItem().equals("Beef")) {
            currentSandwich = new Beef();
            basicIngredients.clear();
            basicIngredients.appendText(currentSandwich.getBasicIngredientsString());
            try {
                FileInputStream input = new FileInputStream("src/view/beef.jpeg");
                Image i = new Image(input);
                imagePlace.setImage(i);
                imagePlace.setX(5);
                imagePlace.setY(5);
                imagePlace.setFitWidth(450);
                imagePlace.setPreserveRatio(true);
                input.close();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }

        }
        else if(comboBox.getSelectionModel().getSelectedItem().equals("Fish")) {
            currentSandwich = new Fish();
            basicIngredients.clear();
            basicIngredients.appendText(currentSandwich.getBasicIngredientsString());
            try {
                FileInputStream input = new FileInputStream("src/view/fish.jpeg");
                Image i = new Image(input);
                imagePlace.setImage(i);
                imagePlace.setX(5);
                imagePlace.setY(5);
                imagePlace.setFitWidth(450);
                imagePlace.setPreserveRatio(true);
                input.close();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }

        }

        clearSelection();
        priceCurrent.clear();
        priceCurrent.appendText("$ "+computePrice());
    }

    @FXML
    /**
     * Allows you to add extra ingredients to your sandwich
     */
    public void addExtra(ActionEvent e) {
        if(extras.getSelectionModel().getSelectedItem() ==null) {
            output1.setText(output1.getText()+"Nothing selcted\n");
            return;
        }
        boolean flag = currentSandwich.add(extras.getSelectionModel().getSelectedItem());
        if(flag == false){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Problem");
            alert.setHeaderText("Cannot add any more extras.");
            alert.setContentText("You can only add 6 toppings");
            alert.showAndWait();
            return;
        }
        selectedExtras.getItems().add(extras.getSelectionModel().getSelectedItem());
        extras.getItems().remove(extras.getSelectionModel().getSelectedItem());
        priceCurrent.clear();
        priceCurrent.appendText("$ "+ computePrice());
    }

    @FXML
    /**
     * Removes extra ingredients if you don't want it
     */
    public void removeExtra(ActionEvent e) {
        if(selectedExtras.getSelectionModel().getSelectedItem() ==null) {
            output1.setText(output1.getText()+"Nothing selected\n");
            return;
        }
        boolean flag = currentSandwich.remove(selectedExtras.getSelectionModel().getSelectedItem());
        if(flag == false){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Problem");
            alert.setHeaderText("Cannot remove any more extras.");
            alert.setContentText("You can only remove added extras");
            alert.showAndWait();
            return;
        }
        extras.getItems().add(selectedExtras.getSelectionModel().getSelectedItem());
        selectedExtras.getItems().remove(selectedExtras.getSelectionModel().getSelectedItem());
        priceCurrent.clear();
        priceCurrent.appendText("$ "+ computePrice());
    }

    /**
     * Clears selections and reverts to default
     * @param e event
     */
    @FXML
    public void clearSelection(ActionEvent e) {
        selectedExtras.getSelectionModel().clearSelection();
        extras.getSelectionModel().clearSelection();
        comboBox.getSelectionModel().selectFirst();
        selectedExtras.getItems().clear();
        extras.getItems().clear();
        displayExtras();
        priceCurrent.clear();
//        chooseSandwich();
        if(currentSandwich instanceof Chicken){
            currentSandwich = new Chicken();
        }

        if(currentSandwich instanceof Chicken){
            currentSandwich = new Chicken();
        }

        if(currentSandwich instanceof Chicken){
            currentSandwich = new Chicken();
        }
        priceCurrent.appendText("$ "+ computePrice());
    }

    /**
     * Clears selection and reverts to default
     */
    public void clearSelection(){
        selectedExtras.getSelectionModel().clearSelection();
        extras.getSelectionModel().clearSelection();
        selectedExtras.getItems().clear();
        extras.getItems().clear();
        displayExtras();
        if(currentSandwich instanceof Chicken){
            currentSandwich = new Chicken();
        }

        if(currentSandwich instanceof Chicken){
            currentSandwich = new Chicken();
        }

        if(currentSandwich instanceof Chicken){
            currentSandwich = new Chicken();
        }
//        chooseSandwich();

    }

    /**
     * Computes the price of the current sandwich
     * @return double value of the price of the sandwich
     */
    public double computePrice(){
        return currentSandwich.price();
    }


    /**
     * Adds the made sadwich to the order
     * @param e Action event handler
     */
    public void addToOrder(ActionEvent e){
        OrderLine orderLine = new OrderLine(order.getLineNumber(), currentSandwich, currentSandwich.price());
        order.add(orderLine);
        output1.clear();
        output1.appendText(order.toString());
        clearSelection();
    }


    /**
     * Switches stage to cart
     * @param e event
     */
    @FXML
    public void showOrder(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/CartView.fxml"));
            VBox root = (VBox)loader.load();
            controller.CartController controller = loader.getController();
            controller.start(primaryStage, order);

            Scene scene = new Scene(root,800,800);
            primaryStage.setScene(scene);
            primaryStage.setTitle("My Sandwich Store");
            primaryStage.setResizable(true);
            primaryStage.show();
        } catch(Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}
