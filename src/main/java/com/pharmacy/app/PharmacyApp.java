package com.pharmacy.app;

import com.pharmacy.utils.PharmacyConstants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PharmacyApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Login(stage), 500, 450);
        scene.getStylesheets().add(getClass().getResource("/css/login.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle(PharmacyConstants.TITLE);
        stage.getIcons().add(new Image("/images/pharma-logo.png"));
        stage.setResizable(false);
        stage.show();
    }
}
