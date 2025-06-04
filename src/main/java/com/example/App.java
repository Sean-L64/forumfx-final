package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//main scene

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Dashboard dashboardUI = new Dashboard(); // creates dashboard object

        // sets dimension and sczene from dashboard object and view variable to scene
        Scene scene = new Scene(dashboardUI.getView(), 1080, 720);

        // applies styles from stylesheet
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setTitle("ForumFX v0.0.01"); // title
        primaryStage.setScene(scene); // displays scene
        primaryStage.show(); // shows app
    }

    public static void main(String[] args) {

        launch(args);// launch the app
    }
}
