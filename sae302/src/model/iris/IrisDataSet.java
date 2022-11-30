package model.iris;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import model.Column;
import model.ColumnFactory;
import model.DataSet;
import model.Undefined;

public class IrisDataSet extends DataSet {

    public IrisDataSet(String title) {
		super(title);
		this.addCategory(new Setosa());
		this.addCategory(new Versicolor());
		this.addCategory(new Virginica());
		this.addCategory(new Undefined());
	}

	public IrisDataSet() {
		this("");
	}
	
	@Override
	public void loadFromFile(String datafile) {
		try {
        	List<Iris> irisList = new CsvToBeanBuilder<Iris>(Files.newBufferedReader(Paths.get(datafile)))
                    .withSeparator(',')
                    .withType(Iris.class)
                    .build().parse();
        	// Ajout des Iris dans IPoint
        	this.pointsList.addAll(irisList);
        	//nom des cols
        	BufferedReader columnReader = new BufferedReader(new FileReader(datafile));
        	String[] columnName = columnReader.readLine().split(",");
        	
        	//type de la classe Iris
        	Iris iris = irisList.get(0);
        	Field[] field = iris.getClass().getDeclaredFields();
        	
        	List<String> columnType = getFieldType(field);

        	//init des col
			initColumns(columnName, columnType);
			this.categoryInit();

        } catch (InvalidPathException e) {
        	System.out.println("Le fichier n'existe pas");
        } catch(IllegalStateException e) {
        	System.out.println("Java n'a pas pu executer la requête");
        } catch(IOException e) {
        	System.out.println("Ioexception");
        }
	}

	protected void initColumns(String[] columnName, List<String> columnType) {
		for(int j = 0; j < columnType.size(); j++) {
			Column column = ColumnFactory.createColumn(this, this.pointsList, columnType.get(j), columnName[j]);
		 	if(!column.getName().equals("null")) {
		 		this.columnsList.add(column);
		 	}
		}
	}

	protected List<String> getFieldType(Field[] field) {
		List<String> columnType = new ArrayList<String>();
		for(int i = 0; i < field.length; i ++) {
			String[] type = field[i].toString().split(" ");
			columnType.add(type[1]);
		}
		return columnType;
	}

	@Override
	public void loadFromString(String data) {
		String[] dataList = data.split(",");
		Iris iris = new Iris(Double.parseDouble(dataList[0]),Double.parseDouble(dataList[1]),Double.parseDouble(dataList[2]),Double.parseDouble(dataList[3]),dataList[4]);
		this.addLine(iris);
		this.categoriesList.get(this.getCategoriesList().size()-1).addToCategory(iris);
	}

	@Override
	public Column defaultXCol() {
		return this.getColumnsList().get(0);
	}

	@Override
	public Column defaultYCol() {
		return this.getColumnsList().get(1);
	}
    
}
