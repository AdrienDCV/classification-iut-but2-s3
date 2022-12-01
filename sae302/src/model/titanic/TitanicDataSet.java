package model.titanic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

public class TitanicDataSet extends DataSet{
    
    public TitanicDataSet(String title) {
		super(title);
		this.addCategory(new Survived());
		this.addCategory(new Died());
		this.addCategory(new Undefined());
	}

	public TitanicDataSet() {
		this("");
	}
	
	@Override
	public void loadFromFile(String datafile) {
		try {
        	List<Titanic> titanicPassengersList = new CsvToBeanBuilder<Titanic>(Files.newBufferedReader(Paths.get(datafile)))
                    .withSeparator(',')
                    .withType(Titanic.class)
                    .build().parse();
        	// Ajout des passagers dans IPoint
        	this.pointsList.addAll(titanicPassengersList);
        	//nom des cols
        	BufferedReader columnReader = new BufferedReader(new FileReader(datafile));
        	String[] columnName = columnReader.readLine().split(",");
        	
        	//type de la classe Titanic
        	Titanic titanicPassenger = titanicPassengersList.get(0);
        	Field[] field = titanicPassenger.getClass().getDeclaredFields();
        	
        	List<String> columnType = getFieldType(field);
        	//init des col
			initColumns(columnName, columnType);
			this.categoryInit();
			columnReader.close();

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
		Titanic passenger = new Titanic(Integer.parseInt(dataList[0]),Integer.parseInt(dataList[1]),Integer.parseInt(dataList[2]),dataList[3],Sex.valueOf(dataList[4]),Double.parseDouble(dataList[5]),Integer.parseInt(dataList[6]),Integer.parseInt(dataList[7]),
				dataList[8],Double.parseDouble(dataList[9]),dataList[10],Embarked.valueOf(dataList[11]));
		this.addLine(passenger);
		this.categoriesList.get(this.getCategoriesList().size()-1).addToCategory(passenger);
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
