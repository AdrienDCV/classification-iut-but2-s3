package pokemon;

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

import intefarces.ICategory;
import intefarces.IColumn;
import intefarces.IMVCModel;
import intefarces.IPoint;
import model.EnumColumn;
import model.NumberColumn;

import com.opencsv.bean.CsvToBeanBuilder;

public class PokemonDataSet implements IMVCModel {
	
	private String title;
	private List<Pokemon> pointsList;
	private List<IColumn> columnsList;
	private List<ICategory> categoriesList;
	
	public PokemonDataSet(String title, List<IColumn> columnsList) {
		this.title = title;
		this.columnsList = columnsList;
		this.pointsList = new ArrayList<>();
		this.categoriesList = new ArrayList<>();
	}

	public PokemonDataSet() {
		this("", new ArrayList<>());
	}

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
		this.pointsList.clear();
		for(int i = 0; i < lines.size(); i ++) {
			this.pointsList.add((Pokemon) lines.get(i));
		}
	}

	@Override
	public void addLine(IPoint element) {
		this.pointsList.add((Pokemon) element);
	}

	@Override
	public void addAllLine(List<IPoint> element) {
		for(int i = 0; i < element.size(); i ++) {
			this.pointsList.add((Pokemon) element.get(i));
		}
	}

	@Override
	public Iterator<IPoint> iterator() {
		return null;
	}

	@Override
	public void loadFromFile(String datafile) {
		try {
        	this.pointsList = new CsvToBeanBuilder<Pokemon>(Files.newBufferedReader(Paths.get(datafile)))
                    .withSeparator(',')
                    .withType(Pokemon.class)
                    .build().parse();
        	// Création colonnes
        	
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
        			List<IPoint> points = new ArrayList<>();
        			points.addAll(this.pointsList);
        			this.columnsList.add(new NumberColumn(columnName[j], this, points));
        		} else {
        			List<IPoint> points = new ArrayList<>();
        			points.addAll(this.pointsList);
        			this.columnsList.add(new EnumColumn(columnName[j], this, points));
        		}
        	}
        	
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
		this.pointsList = new CsvToBeanBuilder<Pokemon>(new StringReader(data))
                .withSeparator(',')
                .withType(Pokemon.class)
                .build().parse();
	}

	@Override
	public IColumn defaultXCol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IColumn defaultYCol() {
		// TODO Auto-generated method stub
		return null;
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

	public List<Pokemon> getPointsList() {
		return pointsList;
	}
	

}
