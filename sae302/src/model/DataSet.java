package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


import intefarces.ICategory;
import intefarces.IColumn;
import intefarces.IMVCModel;
import intefarces.IPoint;

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

	@Override
	public abstract void loadFromString(String data); 

	@Override
	public abstract IColumn defaultXCol();

	@Override
	public abstract IColumn defaultYCol();

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

	public List<ICategory> getCategoriesList() {
		return categoriesList;
	}
	
	

	
}