package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

//    Button button;
    public static void main(String[] args) {
        launch(args);
    }
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        stage.setTitle("The title of the window");
//        button = new Button();
//        button.setText("Click me");
//        button.setOnAction(this);
//        StackPane layout = new StackPane();
//        layout.getChildren().add(button);
//        Scene scene = new Scene(layout, 300, 250);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    @Override
//    public void handle(ActionEvent actionEvent) {
//        System.out.println("Eshaan");
//    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            //BorderPane root = new BorderPane();
            BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("view/Transact.fxml"));
            Scene scene = new Scene(root, 640, 480);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setTitle("Transaction Manager");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
