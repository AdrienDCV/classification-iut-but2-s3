package view;

import java.io.File;
import java.util.List;

import intefarces.IPoint;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.beans.value.*;
import main.ScatterChartObject;
import model.Category;
import model.Classification;
import model.Column;
import model.Criteria;
import model.DataSet;
import model.DataSetFactory;
import utils.Observer;
import utils.Subject;
import javafx.scene.control.*;

public class View extends Stage implements Observer{
	
	// class attributes
	static Button confirmer, parcourir, classifier, ajouter;
    static ComboBox<String> criteriaX, criteriaY, typeDataSet, typeDistance;
    //TextField entrerK=new TextField();

    static FileChooser fichierCsv;
	static HBox hboxVariables;
	static Canvas canvas;//changer en scaterChart
	static DataSet model;
	static Criteria criteria;
	static Classification classification;
	static ScatterChartObject scatterChart;
	static Slider slider;
	static VBox sliderVBox;
	//static VBox verticalPosition;
	static HBox hbox;
	static VBox vbox;
	static File file;
	static String newPoint;
	static Label labelK;
	static int k;
	/*
	 * A supprimer
	 
	static Pokemon p;
	*/
	
	public View() {
		initWidget();
		
		
		
		hbox=new HBox();
    	hbox.getChildren().addAll(this.vBox(), canvas);
    	MenuBarClass menuBarClass = new MenuBarClass();
    	VBox verticalPosition = new VBox();
        verticalPosition.getChildren().addAll(menuBarClass.getMenuBar(), hbox);
       
        
    	dataSetComboBox();
    	distanceComboBox();
    	
//    	menuBarClass.loadFile();
    	menuBarClass.exitApplication();
    	menuBarClass.saveScatterChart();
    	
    	Scene scene=new Scene(verticalPosition,1000,500);
    	this.setTitle("test");
    	this.setScene(scene);
    	this.show();

	}

	private static void initWidget() {
		initButton();
	    //Button sauvegarde=new Button("sauvegarder");
	    initComboBox();
	    sliderVBox = initSlider();
	    //TextField entrerK=new TextField();
	    fichierCsv=new FileChooser();
		hboxVariables=new HBox();
		canvas=new Canvas();//changer en scaterChart
//		dataSet = new PokemonDataSet("Ratio");
	}

	private static void initComboBox() {
		criteriaX=new ComboBox<>();
	    criteriaY=new ComboBox<>();
	    typeDataSet = new ComboBox<>();
	    typeDistance = new ComboBox<>();
	}
	
	  protected void dataSetComboBox() {
	    	typeDataSet.getItems().add("Pokemon");
	    	typeDataSet.getItems().add("Iris");
	    	typeDataSet.getItems().add("Titanic");
	    	typeDataSet.getSelectionModel().selectFirst();
	    }
	    protected void distanceComboBox() {
	    	typeDistance.getItems().add("Euclidienne");
	    	typeDistance.getItems().add("Manhattan");
	    	typeDistance.getSelectionModel().selectFirst();
	    }
	    

	private static void initButton() {
		confirmer=new Button("confirmer");
	    parcourir=new Button("parcourir");
	    classifier= new Button("Classifier Point");
	    ajouter=new Button("Ajouter point");
	}
	
	private static VBox initSlider() {
//		slider = new Slider(1, 10, 1);
		slider = new Slider();
		slider.setMin(1);
		slider.setMax(10);
		slider.setPrefWidth(150);
        slider.setShowTickLabels(true);
        slider.setBlockIncrement(1);
        View.k = 1;
        labelK = new Label("Choisir valeur de k: " + View.k);
        
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {
            	View.k = newValue.intValue();
            	labelK.setText("Choisir valeur de k: " + k);
            }
        });
        
       
		labelK.setTextFill(Color.WHITE);

        VBox root = new VBox();
        root.setPadding(new Insets(20));
        root.setSpacing(10);
        root.getChildren().addAll(labelK, slider);
        return root;
    }
	
    protected VBox vBox() {
    	
    	
    	//entrerK.setPromptText("entrer k");
    	//entrerK.setMaxWidth(100);
    	Stage stage = this;
    	View view = this;
    	parcourir.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(final ActionEvent e) {
/*<<<<<<< HEAD
                File file = fichierCsv.showOpenDialog(stage);
           
                dataSet.loadFromFile(file.toString());
                comboBox();  
=======*/
                file = fichierCsv.showOpenDialog(stage);
                System.out.println(file.toString());
                if (file != null) {
                	View.model = DataSetFactory.createDataSet(typeDataSet.getValue());
                	model.loadFromFile(file.toString());
                	View.model.attach(view);
                	if(criteriaX != null && criteriaY != null && criteriaX.getItems().size() == 0) {
                		comboBox();
                	}else {
                		criteriaX.getItems().clear();
                		criteriaY.getItems().clear();
                		comboBox();
                	}
                }
            }
            
    	});
    	confirmer.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(final ActionEvent e) {
    			//int k=Integer.parseInt(entrerK.getText());
    			if(criteriaX != null && criteriaY != null) {
    				if(!criteriaX.equals(criteriaY)) {
    					if(View.scatterChart != null) {
    						updateScatter();
    					} else {
    						createScatter();
    					}
    					View.classification = new Classification(model.getColumnsList(), criteria, typeDistance.getValue());
        			} else {
        				System.out.println("Selectionne des paramètres différents !");
        			}
    			}
    			
    		}
    	});
    	
    	classifier.setOnMouseClicked(e -> {
    		Category undefined = View.model.getCategoriesList().get(View.model.getCategoriesList().size() -1);
    		System.out.println(undefined.getCategoryElements());
    		for(IPoint point : undefined.getCategoryElements()) {
    			Category category = classification.classifyPoint(k, point, model.getPointsList());
    			category.addToCategory(point, category);
    		}
    		undefined.getCategoryElements().clear();
    		updateScatter();
    	});
    	
    	ajouter.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(final ActionEvent e) {
            	CreateNewPoint cnp = new CreateNewPoint();
            	try {
					cnp.start(stage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
    	});
    	
    	vbox=new VBox();
    	vbox.setPadding(new Insets(80,10,100,10));
    	vbox.setSpacing(10);
    	vbox.setStyle("-fx-background-color: #101010;");
    	vbox.getChildren().addAll(typeDataSet,typeDistance,parcourir,criteriaX,criteriaY,confirmer, classifier, ajouter, sliderVBox);
    	return vbox;
    }
    
    public void createScatter() {
    	View.criteria = new Criteria(criteriaX.getValue(), criteriaY.getValue());
		View.scatterChart = new ScatterChartObject(criteria, View.model);
		View.scatterChart.initScatter();
		hbox.getChildren().addAll(scatterChart.getScatterChart());
    }
    
    public void updateScatter() {
    	hbox.getChildren().remove(scatterChart.getScatterChart());
    	createScatter();
    }

    
   
    protected void comboBox() {
    	List<Column> columns=model.getColumnsList();
    	if(criteriaY.getItems().size()!=0 && criteriaX.getItems().size()!=0) {
    		criteriaX=new ComboBox<>();
    	    criteriaY=new ComboBox<>();
    	}
    	for(Column column : columns) {
    		if(!column.getName().equals("null")) {
    			criteriaX.getItems().add(column.getName());
            	criteriaY.getItems().add(column.getName());
    		}
    	}
    }
   


	@Override
	public void update(Subject subj) {
		updateScatter();
	}

	@Override
	public void update(Subject subj, Object data) {
		updateScatter();
	}

}
