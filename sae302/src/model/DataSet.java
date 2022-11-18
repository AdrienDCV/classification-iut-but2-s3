package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import intefarces.ICategory;
import intefarces.IColumn;
import intefarces.IMVCModel;
import intefarces.IPoint;
import pokemon.Pokemon;

/**
 * 
 * @author adrien.dacostaveiga
 * 
 */
public abstract class DataSet implements IMVCModel {

	// class attributes
	protected String title;
	protected List<IPoint> pointsList;
	protected List<IColumn> columnsList;
	protected List<ICategory> categoriesList;

	// constructor(s)
	public DataSet(String title) {
		this.title = title;
		this.columnsList = new ArrayList<>();
		this.pointsList = new ArrayList<>();
		this.categoriesList = new ArrayList<>();
	}

	public DataSet() {
		this("");
	}

	// methods
	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public int getNbLines() {
		return this.pointsList.size();
	}

	@Override
	public void setLines(List<IPoint> lines) {
		this.pointsList = lines;
	}

	@Override
	public void addLine(IPoint element) {
		this.pointsList.add(element);		
	}

	@Override
	public void addAllLine(List<IPoint> elements) {
		this.pointsList.addAll(elements);
	}

	public Iterator<IPoint> iterator() {
		return this.pointsList.iterator();
	}

	@Override
	public abstract  void loadFromFile(String datafile);
	/*{
		try {
        	this.pointsList = new CsvToBeanBuilder<IPoint>(Files.newBufferedReader(Paths.get(datafile)))
                    .withSeparator(',')
                    .withType(IPoint.class)
                    .build().parse();

        	//nom des cols
        	BufferedReader columnReader = new BufferedReader(new FileReader(datafile));
        	String[] columnName = columnReader.readLine().split(",");
        	
        	//type de la classe pokemon
        	IPoint p = this.pointsList.get(0);
        	Field[] field = p.getClass().getDeclaredFields();
        	List<String> columnType = new ArrayList<String>();
        	for(int i = 0; i < field.length; i ++) {
        		String[] type = field[i].toString().split(" ");
        		columnType.add(type[1]);
        	}
        	
        	//init des col
        	for(int j = 0; j < columnType.size(); j++) {
        		if(columnType.get(j).equals("java.lang.String"));
        		else if(columnType.get(j).equals("int") || columnType.get(j).equals("double")) {
        			this.columnsList.add(new NumberColumn(columnName[j], this, this.pointsList));
        		} else {
        			this.columnsList.add(new EnumColumn(columnName[j], this, this.pointsList));
        		}
        	}
        	
        } catch (InvalidPathException e) {
        	System.out.println("Le fichier n'existe pas");
        } catch(IllegalStateException e) {
        	System.out.println("Java n'a pas pu executer la requête");
        } catch(IOException e) {
        	System.out.println("Ioexception");
        }	
	}*/

	@Override
	public abstract void loadFromString(String data); 
	/*{
		this.pointsList = new CsvToBeanBuilder<IPoint>(new StringReader(data))
                .withSeparator(',')
                .withType(IPoint.class)
                .build().parse();
	}*/

	@Override
	public abstract IColumn defaultXCol();
	/*{
		return this.columnsList.get(1);
	}*/

	@Override
	public abstract IColumn defaultYCol();
	/*{
		return this.columnsList.get(2);
	}*/

	@Override
	public void addCategory(ICategory classe) {
		this.categoriesList.add(classe);
	}

	@Override
	public Collection<ICategory> allCategories() {
		return this.categoriesList;
	}

	@Override
	public int nbColumns() {
		return this.columnsList.size();
	}

	@Override
	public List<IColumn> getNormalizableColumns() {
		List <IColumn> normalizableColumns = new ArrayList<>();
		for (IColumn column : this.columnsList) {
			if (column.isNormalizable()) {
				normalizableColumns.add(column);
			}
		}
		return normalizableColumns;
	}

	public List<IPoint> getPointsList() {
		return pointsList;
	}

	public List<IColumn> getColumnsList() {
		return columnsList;
	}
	


	
}