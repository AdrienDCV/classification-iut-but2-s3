package view;

import java.util.ArrayList;
import java.util.List;

import intefarces.IColumn;
import iris.IrisDataSet;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DataSet;
import pokemon.Pokemon;
import pokemon.PokemonDataSet;
import titanic.TitanicDataSet;

public class CreateNewPoint extends Application{
	DataSet dataSet;
	List<TextField> listTextField = new ArrayList<>();
	Button button = new Button("Submit");
	VBox vbox = new VBox();
	Label error = new Label("error");
	List<String> labelList = new ArrayList<String>();
	List<IColumn> columnList = new ArrayList<IColumn>();
	List<String> listNewPoint = new ArrayList<String>();

	
	protected CreateNewPoint() {
	}
	
	@Override
	public void start(Stage args) throws Exception {
		dataSetFile();
		vbox.getChildren().add(new Label("Ajouter informations d'un " + dataSet.getTitle()));
		textField();
		vbox.getChildren().addAll(button, error);
		buttonSubmit();
		Stage stage = new Stage();
		Scene scene = new Scene(this.vbox, 300, 400);
		stage.setScene(scene);
		stage.show();
		
	}
	
	protected void dataSetFile() {
		this.dataSet = View.dataSet;
		this.columnList = dataSet.getColumnsList();
	}
	
	protected void textField() {
    	if(columnList != null) {
    		for(int i = 0; i < columnList.size(); i++) {
    			HBox hbox = new HBox();
    			Label label = new Label(columnList.get(i).getName() + ":");
    			labelList.add(columnList.get(i).getName());
    			TextField categorieTextField = new TextField();
    			this.listTextField.add(categorieTextField);
    			hbox.getChildren().addAll(label, categorieTextField);
    			this.vbox.getChildren().add(hbox);
    		}
    	}
	}
	
//	protected void buttonPressed() {
//		button.setOnMouseClicked(e -> {
//			error.setText("Valeurs ajoutés avec succés");
//				for(int i = 0; i < listTextField.size(); i++) {
//				if(!listTextField.get(i).getText().equals("")) {
//					listRecup.add(listTextField.get(i).getText());
//					System.out.println(listRecup.get(i));
//				} else {
//					protectionValeurs();
//				}
//		    }
//		});
//	}
	
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
					result += listTextField.get(i).getText() + ", ";
				}
				this.error.setText(dataSet.getTitle() + " ajouté à la liste");
				result = result.substring(0, result.length() - 2);
				listNewPoint.add(result);
				
			} else {
				protectionValeurs();
			}
		});
	}
	
	protected void protectionValeurs() {
		this.error.setText("Erreur: remplir les informations des cases: \n");
		for(int l  = 0; l < listTextField.size(); l++) {
			if(listTextField.get(l).getText().equals("")) {
				error.setText(error.getText() + labelList.get(l) + "\n");
			}
		}
	}



	public static void main(String[] args) {
		launch(args);
	}
	
}
