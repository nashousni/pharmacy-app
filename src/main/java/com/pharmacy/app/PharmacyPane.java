package com.pharmacy.app;

import com.pharmacy.utils.Glyph;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.util.ResourceBundle;

public class PharmacyPane extends BorderPane {

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("lang.PharmacyPane");
	
	MenuItem connexion = new MenuItem("Connexion");
	Menu newMenuItem = new Menu("New");
	MenuItem userGuide = new MenuItem(RESOURCE_BUNDLE.getString("UserGuide"));
	SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
	MenuItem exitMenuItem = new MenuItem("Exit");


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
		//Creating menu items for the sub item edit
		MenuItem userItem = new MenuItem("User", Glyph.createAwesomeFont('\uf120').size("1.2em"));
		MenuItem supplierItem = new MenuItem("supplier");
		MenuItem productItem = new MenuItem("product");

		//Adding toggle group to the view menu item
		newMenuItem.getItems().addAll(userItem, supplierItem, productItem);

		file.getItems().addAll(newMenuItem, userGuide, separatorMenuItem, exitMenuItem);
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
		exitMenuItem.setOnAction(event -> System.exit(0));
    	connexion.setOnAction(e -> new LoginScreen());
    	
    }
	PharmacyPane() {
		createMenu();
		addEvents();
	}

}
