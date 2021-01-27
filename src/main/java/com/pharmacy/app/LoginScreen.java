package com.pharmacy.app;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class LoginScreen extends BorderPane {

	String user = "Pharma";
	
	String pwd = "password";

	private String checkUser;

	private String checkPw;

    private final Button btnLogin = new Button("Login");
    
	Label labelUserName = new Label("Username");
	
	private final TextField txtUserName = new TextField();
	
	private final Label labelPassword = new Label("Password");
	
	private final PasswordField pwdf = new PasswordField();
		
	private final Label labelMessage = new Label();    
    
	
	
	void addEvents() {
		btnLogin.setOnAction(e -> {
			checkUser = txtUserName.getText();
			checkPw = pwdf.getText();
			if (user.equals(checkUser) && pwd.equals(checkPw)) {
				labelMessage.setText("Congratulations!");
				labelMessage.setTextFill(Color.GREEN);
			} else {
				labelMessage.setText("Incorrect user or pw.");
				labelMessage.setTextFill(Color.RED);
			}
			txtUserName.setText("");
			pwdf.setText("");
		});
	}

	public LoginScreen() {

		setPadding(new Insets(10, 50, 50, 50));

		// Adding HBox
		HBox hb = new HBox();
		hb.setPadding(new Insets(20, 20, 20, 30));

		// Adding GridPane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.setHgap(5);
		gridPane.setVgap(5);

		/*// Implementing Nodes for GridPane
		Label labelUserName = new Label("Username");
		final TextField txtUserName = new TextField();
		Label labelPassword = new Label("Password");
		final PasswordField pwdf = new PasswordField();
		btnLogin = new Button("Login");
		final Label labelMessage = new Label();
		*/

		// Adding Nodes to GridPane layout
		gridPane.add(labelUserName, 0, 0);
		gridPane.add(txtUserName, 1, 0);
		gridPane.add(labelPassword, 0, 1);
		gridPane.add(pwdf, 1, 1);
		gridPane.add(btnLogin, 2, 1);
		gridPane.add(labelMessage, 1, 2);

		// Reflection for gridPane
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		gridPane.setEffect(r);

		// DropShadow effect
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(5);

		// Adding text and DropShadow effect to it
		Text text = new Text("Connexion");
		text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		text.setEffect(dropShadow);

		// Adding text to HBox
		hb.getChildren().add(text);

		// Add ID's to Nodes
		setId("bp");
		hb.setId("hbox");
		gridPane.setId("root");
		btnLogin.setId("btnLogin");
		text.setId("text");

		// Action for btnLogin
		addEvents();

		// Add HBox and GridPane layout to BorderPane Layout
		setTop(hb);
		setCenter(gridPane);

		// Adding BorderPane to the scene and loading CSS
		Scene scene = new Scene(this);
		scene.getStylesheets().add(getClass().getResource("/css/login.css").toExternalForm());
		Stage loginStage = new Stage();
		loginStage.setScene(scene);
		loginStage.initModality(Modality.APPLICATION_MODAL);
		loginStage.titleProperty()
				.bind(scene.widthProperty().asString().concat(" : ").concat(scene.heightProperty().asString()));
		// primaryStage.setResizable(false);
		loginStage.show();
	}
}
