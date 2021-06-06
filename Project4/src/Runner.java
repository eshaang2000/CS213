/**
 *  Driver class to  set stage, start application
 *  @author Shankar Kohli, Eshaan Gandhi
 */

import controller.CartController;
import controller.OrderController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Extra;
import model.Order;

public class Runner extends Application {

    /**
     * Driver method of our project. Takes the primary stage to display GUI.
     */
    public void start(Stage primaryStage) throws Exception {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/OrderView.fxml"));
            VBox root = (VBox)loader.load();
            OrderController controller = loader.getController();
            controller.start(primaryStage, new Order());
            Scene scene = new Scene(root,1200,800);
            primaryStage.setScene(scene);
            primaryStage.setTitle("My Sandwich Store");
            primaryStage.setResizable(true);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
            return;
        }
    }
    /**
     * Launches application
     * @param args arguments
     */
    public static void main(String[] args) {

        launch(args);
    }
}
