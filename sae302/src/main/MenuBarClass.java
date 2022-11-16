package main;

import javafx.application.Application;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MenuBarClass extends Application {
	MenuItem loadItem;
	MenuItem saveItem;
	MenuItem exitItem;
	
	@Override
	public void start(Stage arg0) throws Exception {
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu("Fichier");
		loadItem = new MenuItem("Charger fichier");
		saveItem = new MenuItem("Sauvegarder graphique");
		exitItem = new MenuItem("Quitter application");
		
		fileMenu.getItems().addAll(loadItem, saveItem, exitItem);
		menuBar.getMenus().add(fileMenu);
		
	}
	
//	public void exitApplication() {
//		this.exitItem.setOnAction(new EventHandler<ActionEvent>() {
//			public void handle(ActionEvent event) {
//				System.exit(0);
//			}
//		});
//	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
