package main;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.WritableImage;

public class MenuBarClass {
	MenuBar menuBar = new MenuBar();
	MenuItem loadItem;
	MenuItem saveItem;
	MenuItem exitItem;
	
	public MenuBarClass() {
		Menu fileMenu = new Menu("Fichier");
		loadItem = new MenuItem("Charger fichier");
		saveItem = new MenuItem("Sauvegarder graphique");
		exitItem = new MenuItem("Quitter application");
		
		fileMenu.getItems().addAll(loadItem, saveItem, exitItem);
		this.menuBar.getMenus().add(fileMenu);
		exitApplication();
	}
	
	public MenuBar getMenuBar() {
		return this.menuBar;
	}
	

	public void exitApplication() {
		this.exitItem.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
	}	
	
	public void saveScatterChart(Scatter scatterChart) {
		this.saveItem.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String path;
				if(new File(System.getProperty("user.home") + "/Bureau").exists()) {
					path = System.getProperty("user.home") + "/Bureau/image.png";
				} else {
					path = System.getProperty("user.home") + "/Desktop/image.png";
				}
				File file = new File(path);
				WritableImage image = scatterChart.getScatterChart().snapshot(new SnapshotParameters(), null);
				try {
				  ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
				} catch (IOException e) {
					System.err.println(e.getMessage());
					e.getStackTrace();
				}
			}
		});
	}

}
