package model;

import java.io.IOException;
import java.io.StringReader;
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

/**
 * 
 * @author adrien.dacostaveiga
 * 
 */
public class DataSet implements IMVCModel {

	// class attributes
	private String title;
	private List<IPoint> pointsList;
	private List<IColumn> columnsList;
	private List<ICategory> categoriesList;

	// constructor(s)
	public DataSet(String title, List<IColumn> columnsList) {
		this.title = title;
		this.columnsList = columnsList;
		this.pointsList = new ArrayList<>();
		this.categoriesList = new ArrayList<>();
	}

	public DataSet() {
		this("", new ArrayList<>());
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

	@Override
	public Iterator<IPoint> iterator() {
		return this.pointsList.iterator();
	}

	@Override
	public void loadFromFile(String datafile) {
		try {
        	this.pointsList = new CsvToBeanBuilder<IPoint>(Files.newBufferedReader(Paths.get(datafile)))
                    .withSeparator(',')
                    .withType(IPoint.class)
                    .build().parse();
        } catch (InvalidPathException e) {
        	System.out.println("Le fichier n'existe pas");
        } catch(IllegalStateException e) {
        	System.out.println("Java n'a pas pu executer la requête");
        } catch(IOException e) {
        	System.out.println("Ioexception");
        }	
	}

	@Override
	public void loadFromString(String data) {
		this.pointsList = new CsvToBeanBuilder<IPoint>(new StringReader(data))
                .withSeparator(',')
                .withType(IPoint.class)
                .build().parse();
	}

	@Override
	public IColumn defaultXCol() {
		return this.columnsList.get(1);
	}

	@Override
	public IColumn defaultYCol() {
		return this.columnsList.get(2);
	}

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


	
}
