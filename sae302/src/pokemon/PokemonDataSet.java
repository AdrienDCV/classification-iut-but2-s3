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
import model.BooleanColumn;
import model.DataSet;
import model.EnumColumn;
import model.NumberColumn;

import com.opencsv.bean.CsvToBeanBuilder;

public class PokemonDataSet extends DataSet {
	
	public PokemonDataSet(String title) {
		super(title);
	}

	public PokemonDataSet() {
		this("");
	}
	@Override
	public void loadFromFile(String datafile) {
		try {
        	List<Pokemon> pokemonList = new CsvToBeanBuilder<Pokemon>(Files.newBufferedReader(Paths.get(datafile)))
                    .withSeparator(',')
                    .withType(Pokemon.class)
                    .build().parse();
        	// Ajout des pokemon dans IPoint
        	this.pointsList.addAll(pokemonList);
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
        		} else if (columnType.get(j).equals("boolean")){
        			List<IPoint> points = new ArrayList<>();
        			points.addAll(this.pointsList);
        			this.columnsList.add(new BooleanColumn(columnName[j], this, points));
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
		List<Pokemon> pokemonList = new CsvToBeanBuilder<Pokemon>(new StringReader(data))
                .withSeparator(',')
                .withType(Pokemon.class)
                .build().parse();
		this.pointsList.addAll(pokemonList);
	}

	@Override
	public IColumn defaultXCol() {
		return this.getColumnsList().get(0);
	}

	@Override
	public IColumn defaultYCol() {
		return this.getColumnsList().get(1);
	}

	

}