package com.example;

//imports javafx components

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Dashboard {

    private final ObservableList<ForumPost> posts; // Holds list of post info
    private final ListView<ForumPost> postListView; // Viewable interactive vertical list
    private final TextField inputField; // text inputs
    private final TextField creator; // text inputs
    private final TextField title; // text inputs
    private final Button postButton; // Submit
    private final VBox view; // positions in vertical column


    public Dashboard() {
        posts = FXCollections.observableArrayList(); // initializes lists
        postListView = new ListView<>(posts); // initializes lists
        postListView.getStylesheets().add(getClass().getResource("styles.css").toExternalForm()); //add stylesheet
        postListView.setCellFactory(param -> new ForumPostCell()); // Set object styles


        // initializes input box with placeholder text + dimension
        inputField = new TextField();
        inputField.setPromptText("Enter your message...");
        //sets text input styles
        inputField.setPrefWidth(100);
        inputField.setPadding(new Insets(15, 50, 15, 50));

        // initializes input box with placeholder text + dimension
        creator = new TextField();
        creator.setPromptText("What's your name?...");
        //sets text input styles
        creator.setPrefWidth(100);
        creator.setPadding(new Insets(15, 50, 15, 50));

        // initializes input box with placeholder text + dimension
        title = new TextField();
        title.setPromptText("Enter your title...");
        //sets text input styles
        title.setPrefWidth(100);
        title.setPadding(new Insets(15, 50, 15, 50));

        // initializes input box with placeholder text + dimension + styles + functions
        postButton = new Button("Post");
        //setbutton styles
        postButton.getStyleClass().add("button");
        postButton.setPadding(new Insets(10, 50, 10, 50));
        postButton.setOnAction(e -> addPost()); // This will now call addPost which also saves to Firebase
        postButton.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // // Optionally, set minimum and maximum width
        inputField.setMinWidth(100); // Minimum width
        inputField.setMaxWidth(300); // Maximum width

        creator.setMinWidth(100); // Minimum width
        creator.setMaxWidth(300);// Maximum width

        title.setMinWidth(100); // Minimum width
        title.setMaxWidth(300);// Maximum width

        // button hover styles
        postButton.setOnMouseEntered(e -> postButton.setStyle(
                "-fx-background-color: #195379; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 20;"));
        postButton.setOnMouseExited(e -> postButton.setStyle(
                "-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 20;"));

        // vertical box area
        VBox inputArea = new VBox(20, creator, title, inputField, postButton);

        // view returned by app (has Dashboard on top, input area on)
        view = new VBox(10, postListView, inputArea);

        // styles
        postButton.setStyle(
                "-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 20;");
        view.setStyle("-fx-background-color:rgb(0, 0, 0); -fx-text-fill: white;");
        inputField.setStyle("-fx-alignment: center; -fx-text-fill: black; -fx-border-radius: 20; ");
        creator.setStyle("-fx-alignment: center; -fx-text-fill: black; -fx-border-radius: 20; ");
        title.setStyle("-fx-alignment: center; -fx-text-fill: black; -fx-border-radius: 20; ");
        inputArea.setStyle("-fx-alignment: center;");
    }

    private void addPost() {
        String text = inputField.getText(); // get input text
        String create = creator.getText(); // get input text
        String titleName = title.getText(); // get input text
        if ((!text.isEmpty() && !create.isEmpty()) && !titleName.isEmpty()) { // if text fields aren't empty
            ForumPost newPost = new ForumPost(text, create, titleName);
            // Save post to Firebase
            posts.add(newPost); // push() generates a unique key
            // posts.add(newPost); // No longer needed to add directly, Firebase listener will do it

            inputField.clear(); // clear prompts
            creator.clear(); // clear prompts
            title.clear(); // clear prompts
        }
    }

    //calls dashboard, button, and text inputs vertically when new object created
    public VBox getView() {
        return view;
    }
}