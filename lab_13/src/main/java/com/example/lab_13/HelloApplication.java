package com.example.lab_13;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Group root = new Group();
        Canvas canvas1 = new Canvas(300,200);
        GraphicsContext gc = canvas1.getGraphicsContext2D();
        gc.fillOval(10,60,60, 30);
        gc.strokeLine(40,10,10,40);
        root.getChildren().add(canvas1);

        Scene scene1 = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}