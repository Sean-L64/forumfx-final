package com.example;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;

//styling forum post

public class ForumPostCell extends ListCell<ForumPost> {
    @Override
    public void updateItem(ForumPost post, boolean empty) {
        super.updateItem(post, empty);

        if (empty || post == null) {
            setText(null);
            setGraphic(null);
        }

        else {
            // Title on top
            Label titleLabel = new Label(post.getTitle());
            titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white;");

            // Author near title
            Label authorLabel = new Label("By: " + post.getAuthor());
            authorLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #b0b0b0;");

            // Message in the center
            Label messageLabel = new Label("Message:     " + post.getMessage());
            messageLabel.setStyle("-fx-font-size: 14px; -fx-wrap-text: true; -fx-text-fill: white;");

            // Timestamp at the bottom
            Label timeLabel = new Label("Written: " + post.getTimestamp());
            timeLabel.setStyle("-fx-font-size: 10px; -fx-text-fill: #808080;");

            // Structure layout
            VBox vbox = new VBox(titleLabel, authorLabel, messageLabel, timeLabel);
            vbox.setSpacing(20);
            vbox.setAlignment(Pos.TOP_LEFT);
            vbox.setStyle("-fx-background-color: #202020;" +"-fx-padding: 30px;" +"-fx-background-radius: 9px;" +"-fx-border-radius: 15px;");

            setGraphic(vbox);
        }
    }
}
