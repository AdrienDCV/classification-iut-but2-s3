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

public class CreateNewPoint extends Application {
	DataSet dataSet;
	String result;
	List<TextField> listTextField = new ArrayList<>();
	Button button = new Button("Submit");
	VBox vbox = new VBox();
	Label error = new Label("error");
	List<String> labelList = new ArrayList<String>();
	List<IColumn> columnList = new ArrayList<IColumn>();
	
	@Override
	public void start(Stage stage) throws Exception {
		dataSetFile();
		vbox.getChildren().add(new Label("Ajouter informations d'un " + dataSet.getTitle()));
		textField();
		vbox.getChildren().addAll(button, error);
		buttonSubmit();
		
		Scene scene = new Scene(this.vbox, 300, 400);
		stage.setScene(scene);
		stage.show();
	}
	
	protected void dataSetFile() {
//		this.dataSet = View.getDataSet() ?;
//		this.dataSet = new TitanicDataSet("Titanic");
//		dataSet.loadFromFile("/home/infoetu/younes.bendhiab.etu/Bureau/equipe-I2/sae302/res/titanic.csv");
		this.dataSet = new PokemonDataSet("Pokemon");
		dataSet.loadFromFile("/home/infoetu/younes.bendhiab.etu/Bureau/equipe-I2/sae302/res/pokemon_train.csv");
//		this.dataSet = new PokemonDataSet("Pokemon");
//		dataSet.loadFromFile("/home/infoetu/younes.bendhiab.etu/Bureau/equipe-I2/sae302/res/pokemon_train.csv");
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
			this.result = "";
			if(buttonPressedValeurNull()) {
				for(int i = 0; i < listTextField.size(); i++) {
					this.result += listTextField.get(i).getText() + ", ";
				}
				this.result = this.result.substring(0, result.length() - 2);
				this.error.setText(dataSet.getTitle() + " ajouté à la liste");
				DataSet dataSetPokemon = new PokemonDataSet("Pokemon");
				dataSetPokemon.loadFromString(result);
				
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
