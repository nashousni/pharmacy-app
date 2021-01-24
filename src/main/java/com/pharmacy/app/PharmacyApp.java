package com.pharmacy.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PharmacyApp extends Application {

    @Override
    public void start(Stage primarystage) throws Exception {
        Scene scene = new Scene(new PharmacyMainPage(), 700, 670);
        scene.getStylesheets().add(getClass().getResource("/css/pharma.css").toExternalForm());
        primarystage.setScene(scene);
        primarystage.setTitle("Pharma management");
        primarystage.setResizable(false);
        primarystage.show();
    }
}
