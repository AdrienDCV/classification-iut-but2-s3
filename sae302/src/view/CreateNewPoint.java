package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Column;
import java.io.FileReader;
import java.io.IOException;

public class CreateNewPoint extends Application {
	protected String result;
	protected List<TextField> listTextField = new ArrayList<>();
	protected Button button = new Button("Ajouter");
	protected VBox vbox = new VBox();
	protected Label label = new Label("");
	protected List<String> labelList = new ArrayList<>();
	protected List<Column> columnList = new ArrayList<>();
	protected static List<String[]> lineSave = new ArrayList<>();
	protected Stage stage;
	protected Scene scene;
	
	
	@Override
	public void start(Stage args) throws Exception {
		columnList = View.model.getColumnsList();
		textField();
		vbox.getChildren().addAll(button, label);
		vbox.setAlignment(Pos.CENTER);
		buttonSubmit();
		stage = new Stage();
		scene = new Scene(vbox);
		button.setMinWidth(20);
		button.setMinHeight(10);
		vbox.setSpacing(0);
		stage.setTitle(View.model.getTitle());
		stage.setScene(scene);
		stage.show();
	}
	
	public List<String> getCSVFirstLine() {
		FileReader fileReader;
		try {
			fileReader = new FileReader(View.file.getAbsolutePath());
			CSVReader csvReader = new CSVReader(fileReader);
			List<String> list = new ArrayList<String>();
			String[] nextRecord;
			nextRecord = csvReader.readNext();
			for(int i = 0; i < nextRecord.length; i++) {
				list.add(nextRecord[i]);
			}
			fileReader.close();
			csvReader.close();
			return list;
		} catch(IOException | CsvValidationException e) {
			System.out.println(e.getMessage());
		}
		return Collections.emptyList();
	}
	
	protected int textField() {
		List<String> list = getCSVFirstLine();
		vbox.getChildren().clear();
		int res = 0;
    	if(list != null) {
    		for(int i = 0; i < list.size(); i++) {
	    		HBox hbox = new HBox();
	    		Label label = new Label(list.get(i)+ ":");
	    		labelList.add(list.get(i));
	    		TextField categorieTextField = new TextField();
	    		vbox.setMargin(hbox, new Insets(0, 0, 3, 20));
	    		listTextField.add(categorieTextField);
	    		hbox.getChildren().addAll(label, categorieTextField);
	    		vbox.getChildren().add(hbox);
	    		res = i;
    		}
    	}
    	return res;
	}
	
	protected boolean buttonPressedValeurNull() {
		for(int i = 0; i < listTextField.size(); i++) {
			if(listTextField.get(i).getText().equals("")) {
				return false;
			}
		}
		return true;
	}

	protected void buttonSubmit() {
		button.setOnMouseClicked(e -> {
			String result = "";
			if(buttonPressedValeurNull()) {
				for(int i = 0; i < listTextField.size(); i++) {
					result += listTextField.get(i).getText() + ",";
				}
				result = result.substring(0, result.length() - 1);
				label.setText(View.model.getTitle() + " ajouté à la liste");
				View.model.loadFromString(result);
				lineSave.add(result.split(","));
				stage.close();
				View.model.notifyObservers();
			} else {
				verifAllTextFieldFulfilled();
			}
		});
	}
	
	protected void verifAllTextFieldFulfilled() {
		label.setText("Erreur: remplir toutes les cases \n");
		
	}
	
}