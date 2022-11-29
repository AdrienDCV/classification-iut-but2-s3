package view;

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
import javafx.stage.FileChooser;
import model.DataSet;

public class MenuBarClass {
	MenuBar menuBar = new MenuBar();
	FileChooser fileChooser = new FileChooser();
	DataSet data;
//	MenuItem loadItem;
	MenuItem saveItem;
	MenuItem exitItem;
	
	public MenuBarClass() {
		Menu fileMenu = new Menu("Fichier");
//		loadItem = new MenuItem("Charger fichier");
		saveItem = new MenuItem("Sauvegarder graphique");
		exitItem = new MenuItem("Quitter application");
		
		fileMenu.getItems().addAll(saveItem, exitItem);
		this.menuBar.getMenus().add(fileMenu);
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
	
//	public void loadFileName() {
//		File file = fileChooser.showOpenDialog(new View().getRealStage());
//		if (file != null) {
//			String fileName = file.getName();
//			String[] tabSplit = fileName.split("\\.");
//			fileName = tabSplit[0].toLowerCase();
//			String extension = tabSplit[tabSplit.length - 1].toLowerCase();
//			if(fileName.equals("pokemon") && extension.equals("csv")) {
//				this.data = new PokemonDataSet();
//				this.data.loadFromFile(file.toString());
//			} else if(fileName.equals("titanic") && extension.equals("csv")) {
//				this.data = new PokemonDataSet();
//				this.data.loadFromFile(file.toString());
//			} else if(fileName.equals("iris") && extension.equals("csv")) {
//				this.data = new PokemonDataSet();
//				this.data.loadFromFile(file.toString());
//			} else {
//				System.err.println("erreur: ce fichier n'appartient pas à la liste");
//			}
//		}
//	}
//    
//	
//	public void loadFile() {
//		this.fileChooser.setTitle("Charger votre fichier CSV");
//		this.loadItem.setOnAction(new EventHandler<ActionEvent>() {
//	        public void handle(final ActionEvent event) {
//	        	loadFileName();
//	        }
//	        	
//		});
//	}
	
	public void saveScatterChart() {
		this.saveItem.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String path;
				if(new File(System.getProperty("user.home") + "/Bureau").exists()) {
					path = System.getProperty("user.home") + "/Bureau/image.png";
				} else {
					path = System.getProperty("user.home") + "/Desktop/image.png";
				}
				File file = new File(path);
				WritableImage image = View.scatterChart.getScatterChart().snapshot(new SnapshotParameters(), null);
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