package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.WritableImage;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.DataSet;

public class MenuBarClass {
	MenuBar menuBar = new MenuBar();
	FileChooser fileChooser = new FileChooser();
	DataSet data;
	MenuItem saveItem;
	MenuItem exitItem;
	MenuItem saveAsCSV;
	
	public MenuBarClass() {
		Menu fileMenu = new Menu("Fichier");
		saveAsCSV = new MenuItem("Sauvegarder fichier");
		saveItem = new MenuItem("Sauvegarder graphique");
		exitItem = new MenuItem("Quitter application");
		
		fileMenu.getItems().addAll(saveAsCSV, saveItem, exitItem);
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
	
	public void saveAsCSVFile() {
		this.saveAsCSV.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				SaveAs saveAs = new SaveAs();
            	try {
					saveAs.start(saveAs.stage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void saveScatterChart() {
		this.saveItem.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				DirectoryChooser directoryChooser = new DirectoryChooser();
				directoryChooser.setTitle("Select a folder");
				String path = directoryChooser.showDialog(new Stage()).getAbsolutePath() + "/" + View.model.getTitle();
				File file = new File(path);
				WritableImage image = View.scatterChart.getScatterChart().snapshot(new SnapshotParameters(), null);
				try {
				  ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}
		});
	}

}