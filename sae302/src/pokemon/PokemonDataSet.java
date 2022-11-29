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

import model.Column;
import model.ColumnFactory;
import model.DataSet;
import model.Undefined;

import com.opencsv.bean.CsvToBeanBuilder;

public class PokemonDataSet extends DataSet {
	
	public PokemonDataSet(String title) {
		super(title);
		this.addCategory(new LegendaryCategory()); 
		this.addCategory(new NotLegendaryCategory());
		this.addCategory(new Undefined());
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
		System.out.println(data);
		String[] dataList = data.split(",");
		Pokemon pokemon = new Pokemon(dataList[0],Integer.parseInt(dataList[1]),Integer.parseInt(dataList[2]),Double.parseDouble(dataList[3]),Integer.parseInt(dataList[4]),Integer.parseInt(dataList[5]),Integer.parseInt(dataList[6]),Integer.parseInt(dataList[7]),
				Integer.parseInt(dataList[8]),dataList[9],dataList[10],Double.parseDouble(dataList[11]));
		this.addLine(pokemon);
		this.categoriesList.get(this.getCategoriesList().size()-1).addToCategory(pokemon);

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