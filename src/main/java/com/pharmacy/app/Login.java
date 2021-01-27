package com.pharmacy.app;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.checkerframework.checker.units.qual.A;

import java.net.URL;
import java.util.ResourceBundle;

public class Login extends AnchorPane {


    private final Label userNameLabel;
    private final TextField userId;

    private final Label passWordLabel;
    private final PasswordField passwordField;

    private final Button login;

    private final Label errorMessage;

    private Main application;

    public Login() {
        userNameLabel = new Label("Username");
        userNameLabel.setLayoutX(14.0);
        userNameLabel.setLayoutY(67.0);

        userId = new TextField();
        userId.setPromptText("Username");
        userId.setLayoutY(86.0);
        userId.setPrefWidth(415.0);

        passWordLabel = new Label("Password");
        passWordLabel.setLayoutX(14.0);
        passWordLabel.setLayoutY(139.0);

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setLayoutY(157.0);
        passwordField.setPrefWidth(415.0);

        login = new Button("Login");
        login.setPrefHeight(70.0);
        login.setPrefWidth(400.0);
        login.setDefaultButton(true);
        login.setOnAction(this::processLogin);

        errorMessage = new Label("");

        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setPrefHeight(300.0);
        anchorPane2.setPrefWidth(500.0);

        VBox vBox = new VBox();
        vBox.setPrefHeight(300.0);
        vBox.setPrefWidth(421.0);
        vBox.setSpacing(5.0);
        vBox.setAlignment(Pos.CENTER);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPrefHeight(25.0);
        hBox.setPrefWidth(418.0);
        hBox.getChildren().add(errorMessage);

        Image image = new Image(getClass().getResourceAsStream("/images/LoginLogo.png"));
        ImageView imageView = new ImageView(image);
        imageView.setLayoutY(-12.0);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(180.0);
        anchorPane.setPrefWidth(430.0);
        anchorPane.getChildren().add(userNameLabel);
        anchorPane.getChildren().add(userId);
        anchorPane.getChildren().add(passWordLabel);
        anchorPane.getChildren().add(passwordField);
        anchorPane.getChildren().add(imageView);

        AnchorPane.setBottomAnchor(anchorPane2, 200.0);
        AnchorPane.setLeftAnchor(anchorPane2, 0.0);
        AnchorPane.setRightAnchor(anchorPane2, 0.0);
        AnchorPane.setTopAnchor(anchorPane2,0.0);

        AnchorPane.setBottomAnchor(vBox, 0.0);
        AnchorPane.setLeftAnchor(vBox, 29.0);
        AnchorPane.setRightAnchor(vBox, 40.0);
        AnchorPane.setTopAnchor(vBox,0.0);

        AnchorPane.setLeftAnchor(userId,10.0);
        AnchorPane.setRightAnchor(userId, 0.0);

        AnchorPane.setLeftAnchor(passwordField,10.0);
        AnchorPane.setRightAnchor(passwordField, 0.0);

        AnchorPane.setBottomAnchor(login, 66.0);
        AnchorPane.setLeftAnchor(login, 40.0);
        AnchorPane.setRightAnchor(login, 40.0);

        AnchorPane.setBottomAnchor(hBox, 156.0);
        AnchorPane.setLeftAnchor(hBox, 41.0);
        AnchorPane.setRightAnchor(hBox, 41.0);

        vBox.getChildren().add(anchorPane);


        anchorPane2.getChildren().add(vBox);
        anchorPane2.getStyleClass().add("top-segment");


        setPrefHeight(500);
        setPrefWidth(500);
        getChildren().add(anchorPane2);
        getChildren().add(login);
        getChildren().add(hBox);
        getStyleClass().add("background");
    }

    private void processLogin(ActionEvent event) {
    }

}

