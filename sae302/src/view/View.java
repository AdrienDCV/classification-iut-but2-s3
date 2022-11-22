package view;

import java.io.File;
import java.util.List;

import intefarces.IColumn;
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
//import main.ScatterTest;
import pokemon.PokemonDataSet;

public class View extends Stage{
	
	// class attributes
	static Button confirmer, parcourir;
    //Button sauvegarde=new Button("sauvegarder");
    static ComboBox<String> criteriaX, criteriaY;
    //TextField entrerK=new TextField();

    static FileChooser fichierCsv;
	static HBox hboxVariables;
	static Canvas canvas;//changer en scaterChart
	static PokemonDataSet dataSet;
	ScatterTest scatterChart = new ScatterTest();
	public View() {
		initWidget();
		
		HBox hbox=new HBox();
    	hbox.getChildren().addAll(this.vBox(), canvas);
    	
    	MenuBarClass menuBarClass = new MenuBarClass();
    	VBox verticalPosition = new VBox();
    	verticalPosition.getChildren().addAll(menuBarClass.getMenuBar(), hbox);
    	//menuBarClass.saveScatterChart(scatter);
    	
    	menuBarClass.loadFile();
    	menuBarClass.exitApplication();
    	menuBarClass.saveScatterChart(this.scatterChart);
    	
    	Scene scene=new Scene(verticalPosition,1000,350);
    	this.setTitle("test");
    	this.setScene(scene);
    	this.show();
		
		this.show();
	}


	

	
	private static void initWidget() {
		initButton();
	    //Button sauvegarde=new Button("sauvegarder");
	    initComboBox();
	    //TextField entrerK=new TextField();
	    fichierCsv=new FileChooser();
		hboxVariables=new HBox();
		canvas=new Canvas();//changer en scaterChart
		dataSet = new PokemonDataSet("Ratio");
	}

	private static void initComboBox() {
		criteriaX=new ComboBox<>();
	    criteriaY=new ComboBox<>();
	}

	private static void initButton() {
		confirmer=new Button("confirmer");
	    parcourir=new Button("parcourir");
	}
	
    protected VBox vBox() {
    	
    	
    	//entrerK.setPromptText("entrer k");
    	//entrerK.setMaxWidth(100);
    	Stage stage = this;
    	parcourir.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(final ActionEvent e) {
/*<<<<<<< HEAD
                File file = fichierCsv.showOpenDialog(stage);
           
                dataSet.loadFromFile(file.toString());
                comboBox();  
=======*/
                File file = fichierCsv.showOpenDialog(stage);
                System.out.println(file.toString());
                if (file != null) {
                	dataSet.loadFromFile(file.toString());
                	comboBox();
                }
                
            }
    	});
    	
    	confirmer.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(final ActionEvent e) {
    			Object variableX=criteriaX.getValue();
    			Object variableY=criteriaY.getValue();
    			//int k=Integer.parseInt(entrerK.getText());
    			
    			if(!variableX.equals(variableY)) {
    				System.out.println("ça marche, attribut selectionné :");
    				System.out.println("X = " + variableX);
    				System.out.println("Y = " + variableY);
    			} else {
    				System.out.println("Selectionne des paramètres différents !");
    			}
    		}
    	});
    	
    	VBox vbox=new VBox();
    	vbox.setPadding(new Insets(80,10,100,10));
    	vbox.setSpacing(10);
    	vbox.setStyle("-fx-background-color: #101010;");
    	vbox.getChildren().addAll(parcourir,criteriaX,criteriaY,confirmer);
    	
    	
    	return vbox;
    	
    }
    
    protected void comboBox() {
    	List<IColumn> columns=dataSet.getColumnsList();
    	if(columns!=null) {
    		for(int i=0;i<columns.size();i++) {
    			criteriaX.getItems().add(columns.get(i).getName());
    			criteriaY.getItems().add(columns.get(i).getName());
    		}
    	}
    }
 
    
	public Stage getRealStage() {
		return this;
	}


}
