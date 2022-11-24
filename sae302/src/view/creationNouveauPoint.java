package view;

import java.util.ArrayList;
import java.util.List;

import intefarces.IColumn;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DataSet;
import pokemon.PokemonDataSet;

public class creationNouveauPoint extends Application {
	DataSet dataSet = new PokemonDataSet("Pokemon");
	List<String> listRecup = new ArrayList<>();
	List<TextField> listTextField = new ArrayList<>();
	Button button = new Button("Submit");
	VBox vbox = new VBox();
	
	@Override
	public void start(Stage stage) throws Exception {
		textField();
		Scene scene = new Scene(this.vbox, 500, 1000);
		stage.setScene(scene);
		stage.show();
	}
	
	protected void textField() {
		dataSet.loadFromFile("/home/infoetu/younes.bendhiab.etu/Bureau/equipe-I2/sae302/res/pokemon_train.csv");
		List<IColumn> columns = dataSet.getColumnsList();
		for(int i=0;i<columns.size();i++) {
			System.out.println(columns.get(i).getName());
		}
    	if(columns != null) {
    		for(int i=0;i<columns.size();i++) {
    			HBox hbox = new HBox();
    			Label label = new Label(columns.get(i).getName() + ":");
    			TextField categorieTextField = new TextField();
    			this.listTextField.add(categorieTextField);
    			hbox.getChildren().addAll(label, categorieTextField);
    			this.vbox.getChildren().add(hbox);
    		}
    	}
	}
	
	protected void textFieldCreation() {
//		if(comboBox.getText() == pokemon) {
//			dataSet = new PokemonDataSet("Pokemon");
//		} else if(comboBox.getText() == Titanic) {
//			dataSet = new TitanicDataSet("Titanic");
//		} else if(comboBox.getText() == Iris) {
//			dataSet = new IrisDataSet("Iris");
//		}
	}
    	
    	
//    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
//    	public void handle(ActionEvent e) {
//    		for(int i = 0; i < listTextField.size(); i++) {
//    			listRecup.add(listRecup.get(i));
//            }
//        }
//    };

	
	public static void main(String[] args) {
		launch(args);
	}
	
}
