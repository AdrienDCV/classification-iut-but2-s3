package view;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.MenuBarClass;
import main.ScatterTest;
import model.DataSet;
import pokemon.PokemonDataSet;

public class View extends Application{
	
	// class attributes
	Button confirmer=new Button("confirmer");
    Button parcourir=new Button("parcourir");
    //Button sauvegarde=new Button("sauvegarder");
    ComboBox premiere_var=new ComboBox();
    ComboBox deuxieme_var=new ComboBox();
    TextField entrer_k=new TextField();
    FileChooser fichier_csv=new FileChooser();
	HBox hbox_variables=new HBox();
	Canvas canvas=new Canvas();//changer en scaterChart
	PokemonDataSet dataset = new PokemonDataSet("Pokemon");
	Stage stage=new Stage();
	
	
    
    protected VBox vBox() {
    	
    	
    	
    	this.comboBox();
    	HBox var1=new HBox();
    	HBox var2=new HBox();
    	
    	
    	
    	var1.getChildren().add(premiere_var);
    	var2.getChildren().add(deuxieme_var);
    	
    	
    	entrer_k.setPromptText("entrer k");
    	entrer_k.setMaxWidth(100);
    	
    	hbox_variables.setSpacing(10);
    	
    	
    	hbox_variables.getChildren().addAll(var1,var2);
    	
    	
    	parcourir.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(final ActionEvent e) {
                File file = fichier_csv.showOpenDialog(stage);
                System.out.println(file.toString());
                if (file != null) {
                	dataset.loadFromFile(file.toString());
                }
                
            }
    	});
    	
    	this.confirmer.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(final ActionEvent e) {
    			Object variableX=premiere_var.getValue();
    			Object variableY=deuxieme_var.getValue();
    			int k=Integer.parseInt(entrer_k.getText());
    			
    			if(variableX!=variableY) {
    				
    			}
    		}
    	});
    	
    	VBox vbox=new VBox();
    	vbox.setPadding(new Insets(100,10,100,10));
    	vbox.setSpacing(10);
    	vbox.setStyle("-fx-background-color: #101010;");
    	vbox.getChildren().addAll(parcourir,hbox_variables,entrer_k,confirmer);
    	
    	
    	return vbox;
    	
    }
    
    protected void comboBox() {
    	
    	this.premiere_var.getItems().add("base egg steps");
    	this.premiere_var.getItems().add("capture rate");
    	this.premiere_var.getItems().add("experience growth");
    	this.premiere_var.getItems().add("speed");
    	
    	this.deuxieme_var.getItems().add("base egg steps");
    	this.deuxieme_var.getItems().add("capture rate");
    	this.deuxieme_var.getItems().add("experience growth");
    	this.deuxieme_var.getItems().add("speed");
    
    }
    
    public void start(Stage stage) throws Exception {
    	
    	   	
    	HBox hbox=new HBox();
    	ScatterTest scatter = new ScatterTest();
    	hbox.getChildren().addAll(this.vBox(), scatter.getScatterChart());
    	
    	MenuBarClass menuBarClass = new MenuBarClass();
    	VBox verticalPosition = new VBox();
    	verticalPosition.getChildren().addAll(menuBarClass.getMenuBar(), hbox);
    	menuBarClass.saveScatterChart(scatter);
    	
    	Scene scene=new Scene(verticalPosition,1000,350);
    	stage.setTitle("test");
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    public static void main(String[] args) {
		launch(args);
	}


}
