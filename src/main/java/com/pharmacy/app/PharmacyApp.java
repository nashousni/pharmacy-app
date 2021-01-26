package com.pharmacy.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PharmacyApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Login(), 700, 570);
        scene.getStylesheets().add(getClass().getResource("/css/login.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Pharma management");
        stage.setResizable(false);
        stage.show();
    }
}
