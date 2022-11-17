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
//import main.ScatterTest;
import model.DataSet;

public class View extends Application{
	
	// class attributes
	Button confirmer=new Button("confirmer");
    Button parcourir=new Button("parcourir");
    //Button sauvegarde=new Button("sauvegarder");
    ComboBox premiereVar=new ComboBox();
    ComboBox deuxiemeVar=new ComboBox();
    TextField entrerK=new TextField();
    FileChooser fichierCsv=new FileChooser();
	HBox hboxVariables=new HBox();
	Canvas canvas=new Canvas();//changer en scaterChart
	DataSet data=new DataSet();
	Stage stage=new Stage();
	
	
    
    protected VBox vBox() {
    	
    	this.comboBox();
    	
    	entrerK.setPromptText("entrer k");
    	entrerK.setMaxWidth(100);
    	
    	parcourir.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(final ActionEvent e) {
                File file = fichierCsv.showOpenDialog(stage);
                System.out.println(file.toString());
                if (file != null) {
                	data.loadFromFile(file.toString());
                }
            }
    	});
    	
    	this.confirmer.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(final ActionEvent e) {
    			Object variableX=premiereVar.getValue();
    			Object variableY=deuxiemeVar.getValue();
    			int k=Integer.parseInt(entrerK.getText());
    			
    			if(variableX!=variableY) {
    				
    			}
    		}
    	});
    	
    	VBox vbox=new VBox();
    	vbox.setPadding(new Insets(80,10,100,10));
    	vbox.setSpacing(10);
    	vbox.setStyle("-fx-background-color: #101010;");
    	vbox.getChildren().addAll(parcourir,premiereVar,deuxiemeVar,entrerK,confirmer);
    	
    	
    	return vbox;
    	
    }
    
    protected void comboBox() {
    	
    	this.premiereVar.getItems().add("base egg steps");
    	this.premiereVar.getItems().add("capture rate");
    	this.premiereVar.getItems().add("experience growth");
    	this.premiereVar.getItems().add("speed");
    	
    	this.deuxiemeVar.getItems().add("base egg steps");
    	this.deuxiemeVar.getItems().add("capture rate");
    	this.deuxiemeVar.getItems().add("experience growth");
    	this.deuxiemeVar.getItems().add("speed");
    
    }
    
    public void start(Stage stage) throws Exception {
    	
    	   	
    	HBox hbox=new HBox();
    	hbox.getChildren().addAll(this.vBox(), canvas);
    	
    	MenuBarClass menuBarClass = new MenuBarClass();
    	VBox verticalPosition = new VBox();
    	verticalPosition.getChildren().addAll(menuBarClass.getMenuBar(), hbox);
    	//menuBarClass.saveScatterChart(scatter);
    	
    	Scene scene=new Scene(verticalPosition,1000,350);
    	stage.setTitle("test");
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    public static void main(String[] args) {
		launch(args);
	}


}
