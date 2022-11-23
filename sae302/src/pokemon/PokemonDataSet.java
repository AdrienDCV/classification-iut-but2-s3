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
import java.util.List;

import intefarces.IColumn;
import model.ColumnFactory;
import model.DataSet;

import com.opencsv.bean.CsvToBeanBuilder;

public class PokemonDataSet extends DataSet {
	
	public PokemonDataSet(String title) {
		super(title);
		this.addCategory(new LegendaryCategory("Legendary")); this.addCategory(new NotLegendaryCategory("NotLegendary"));
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
        	Pokemon p = pokemonList.get(0);
        	Field[] field = p.getClass().getDeclaredFields();
        	
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
		 	this.columnsList.add(ColumnFactory.createColumn(this, this.columnsList, columnType.get(j), columnName[j]));
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