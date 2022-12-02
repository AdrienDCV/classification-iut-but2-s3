package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

import com.opencsv.CSVWriter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class SaveAs extends Application {
	protected static File filePath;
	protected Stage stage;

	@Override
	public void start(Stage arg0) throws Exception {
		stage = new Stage();
		stage.setTitle("Save as");
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Select a folder");
		String selectedDirectory = directoryChooser.showDialog(stage).getAbsolutePath();
		    
		TextField tf = new TextField();
		Button bt = new Button("Submit");
		VBox vbox= new VBox();
		vbox.getChildren().addAll(tf, bt);
		bt.setOnMouseClicked(e -> {
			SaveAs.filePath = new File(selectedDirectory + '/' + tf.getText() + ".csv");
		    System.out.println(SaveAs.filePath);
		    try {
				if(filePath.createNewFile()) {
					System.out.println("Fichier enregistré: " + filePath.getName());
					copyFileChannel(View.file, SaveAs.filePath);
					saveFile();
				} else {
					System.out.println("Fichier existe déjà");
				}
				stage.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		Scene scene = new Scene(vbox);
		stage.setScene(scene);
		stage.show();
	}
		
	public void saveFile() {
		try {
			FileWriter fileWriter = new FileWriter(SaveAs.filePath, true);
		    CSVWriter writer = new CSVWriter(fileWriter, ',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
		    List<String[]> list = CreateNewPoint.lineSave;
		    for(int i = 0; i < list.size(); i++) {
		        writer.writeNext(list.get(i));
		    }
		    fileWriter.close();
		    
		} catch (IOException e) {
			System.out.println(e.getMessage());
		    e.printStackTrace();
		}
		
	}
		
	private static void copyFileChannel(File source, File dest) throws IOException {
		FileChannel sourceChannel = null;
		FileChannel destinationChannel = null;
		try {
		    sourceChannel = new FileInputStream(source).getChannel();
		    destinationChannel = new FileOutputStream(dest).getChannel();
		    destinationChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		} finally {
		    sourceChannel.close();
		    destinationChannel.close();
		}
	}
}
