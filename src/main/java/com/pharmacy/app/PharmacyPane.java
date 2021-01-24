package com.pharmacy.app;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

import java.util.ResourceBundle;

public class PharmacyPane extends BorderPane {

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("lang.PharmacyPane");
	
	MenuItem connexion = new MenuItem("Connexion");
	MenuItem userGuide = new MenuItem(RESOURCE_BUNDLE.getString("UserGuide"));

	private void createMenu() {
		MenuBar menuBar = new MenuBar();

		Menu file = new Menu(RESOURCE_BUNDLE.getString("File"));
		Menu suppliers = new Menu("Fournisseurs");
		Menu products = new Menu(RESOURCE_BUNDLE.getString("Products"));
		Menu vente = new Menu("Vente");
		Menu personnel = new Menu("Personnel");
		Menu comptabilite = new Menu("Comptabilité");
		Menu admin = new Menu("Administration");
		Menu help = new Menu("Help?");

		// add MenuItem

		// Vente items
		MenuItem ajoutClient = new MenuItem("Ajout client");
		MenuItem operaVente = new MenuItem("Op�ration vente");
		MenuItem fichePrix = new MenuItem("Fiche prix");
		MenuItem produitsVendus = new MenuItem("Produits vendus");
		MenuItem sav = new MenuItem("Retour sur vente");

		// Fichier items
		// Vente items
		
		// Ajout des items aux menus
		file.getItems().addAll(connexion, userGuide);
		vente.getItems().addAll(ajoutClient, operaVente, fichePrix, produitsVendus, sav);
		/*
		 * suppliers.getItems().addAll(ajoutClient, operaVente, fichePrix,
		 * produitsVendus, sav); help.getItems().addAll(ajoutClient, operaVente,
		 * fichePrix, produitsVendus, sav); products.getItems().addAll(ajoutClient,
		 * operaVente, fichePrix, produitsVendus, sav);
		 * personnel.getItems().addAll(ajoutClient, operaVente, fichePrix,
		 * produitsVendus, sav); comptabilite.getItems().addAll(ajoutClient, operaVente,
		 * fichePrix, produitsVendus, sav); admin.getItems().addAll(ajoutClient,
		 * operaVente, fichePrix, produitsVendus, sav);
		 */

		//
		menuBar.getMenus().addAll(file, suppliers, products, vente, personnel, comptabilite, admin, help);

		// set menuBar to top
		setTop(menuBar);

	}
    void addEvents( ) {
    	connexion.setOnAction(e -> {
    		new LoginScreen();
    	});
    	
    }
	PharmacyPane() {
		createMenu();
		addEvents();
	}

}
