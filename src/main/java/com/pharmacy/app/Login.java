/*
package com.pharmacy.app;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Login extends AnchorPane implements Initializable {


    private final Label userNameLabel;
    private final TextField userId;

    private final Label passWordLabel;
    private final PasswordField passwordField;
    private final Button login;

    private final Label errorMessage;

    private Main application;

    public Login() {
        userNameLabel = new Label();
        userId = new TextField();
        passWordLabel = new Label();
        passwordField = new PasswordField();
        login = new Button();
        errorMessage = new Label();


        login.setOnAction(this::processLogin);
        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setPrefHeight(300.0);
        anchorPane2.setPrefWidth(500.0);

        VBox vBox = new VBox();


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(180.0);
        anchorPane.setPrefWidth(430.0);

        anchorPane.getChildren().add(userNameLabel);
        anchorPane.getChildren().add(userId);
        anchorPane.getChildren().add(passWordLabel);
        anchorPane.getChildren().add(passwordField);

        vBox.getChildren().add(anchorPane);

        ImageView imageView = new ImageView();

        HBox hBox = new HBox();
        hBox.getChildren().add(errorMessage);

        anchorPane2.getChildren().add(vBox);

        getChildren().add(anchorPane2);
        getChildren().add(login);
        getChildren().add(hBox);
    }

    public void setApp(Main application){
        this.application = application;
    }

    public void processLogin(ActionEvent event) {
        if (application == null){
            // We are running in isolated FXML, possibly in Scene Builder.
            // NO-OP.
            errorMessage.setText("Hello " + userId.getText());
        } else {
            if (!application.userLogging(userId.getText(), passwordField.getText())){
                errorMessage.setText("Username/Password is incorrect");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorMessage.setText("");
        userId.setPromptText("Username");
        passwordField.setPromptText("Password");
    }
}

*/
