package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import intefarces.IPoint;
import model.Category;
import model.Column;
import model.pokemon.Pokemon;
import model.pokemon.PokemonDataSet;

public class DataSetTest {

	PokemonDataSet pokemons;
	List<IPoint> list;
	List<Column> columnList;
	List<Category> categoryList;
	Pokemon pokemon1, pokemon2;

	@BeforeEach
	public void setup() {
		pokemons =new PokemonDataSet();
		pokemons.loadFromFile("./res/pokemon_train.csv");
		columnList = pokemons.getColumnsList();
		list =new ArrayList<IPoint>();
		pokemon1 = new Pokemon("Swablu", 40, 5120, 255.0, 60, 600000, 45, 75, 50, "normal", "flying", 1.2, false);
		pokemon2 = new Pokemon("Budew", 30, 5120, 255.0, 35, 1059860, 40, 70, 55, "grass", "poison", 1.2, false);
		list.add(pokemon1); list.add(pokemon2);
		pokemons.setLines(list); 
		pokemons.addAllLine(list);
		pokemons.addLine(pokemon1); pokemons.addLine(pokemon2);
		categoryList = pokemons.getCategoriesList();
	}

	@Test
	public void getNbLinesTest() {
		assertEquals(6,pokemons.getNbLines());
	}
	
	@Test
	public void getNbColumnTest() {
		assertEquals(10,pokemons.nbColumns());
	}
	
	@Test
	public void setLinesTest() {
		assertEquals(list, pokemons.getPointsList());
	}
	
	@Test
	public void addLineTest() {
		assertEquals(list, pokemons.getPointsList());
	}
	
	@Test
	public void addAllLineTest() {
		assertEquals(list, pokemons.getPointsList());
	}
	
	@Test
	public void getColumnListTest() {
		assertEquals(columnList,pokemons.getColumnsList());
	}
	
	@Test
	public void getCategoryListTest() {
		assertEquals(categoryList,pokemons.getCategoriesList());
	}
	
	@Test
	public void getNormalizableColumnListTest() {
		assertEquals("attack",pokemons.getNormalizableColumns().get(0).getName());
	}
	
	
	
}
