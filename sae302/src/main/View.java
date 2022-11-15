package main;

import javafx.application.Application;
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

public class View extends Application{
	Button confirmer=new Button("confirmer");
    Button parcourir=new Button("parcourir");
    //Button sauvegarde=new Button("sauvegarder");
    ComboBox premiere_var=new ComboBox();
    ComboBox deuxieme_var=new ComboBox();
    TextField entrer_k=new TextField();
    FileChooser fichier_csv=new FileChooser();
	HBox hbox_variables=new HBox();
	Canvas canvas=new Canvas();//changer en scaterChart
	
	
    
    protected VBox vBox() {
    	
    	
    	
    	HBox var1=new HBox();
    	HBox var2=new HBox();
    	
    	var1.getChildren().add(premiere_var);
    	var2.getChildren().add(deuxieme_var);
    	
    	entrer_k.setPromptText("entrer k");
    	entrer_k.setMaxWidth(100);
    	hbox_variables.setSpacing(10);
    	
    	
    	hbox_variables.getChildren().addAll(var1,var2);
    	
    	VBox vbox=new VBox();
    	vbox.setPadding(new Insets(10,10,10,10));
    	vbox.setSpacing(10);
    	vbox.setStyle("-fx-background-color: #101010;");
    	vbox.getChildren().addAll(parcourir,hbox_variables,entrer_k,confirmer);
    	
    	
    	return vbox;
    	
    }
    
    
    public void start(Stage stage) throws Exception {
    	   	
    	HBox hbox=new HBox();
    	hbox.getChildren().addAll(this.vBox(), new Scatter().getScatterChart());
    	Scene scene=new Scene(hbox,900,900);
    	stage.setTitle("test");
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    public static void main(String[] args) {
		launch(args);
	}


}
