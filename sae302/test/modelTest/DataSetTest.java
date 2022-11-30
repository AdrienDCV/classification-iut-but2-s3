package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import intefarces.IPoint;
import model.Category;
import model.Column;
import pokemon.LegendaryCategory;
import pokemon.NotLegendaryCategory;
import pokemon.Pokemon;
import pokemon.PokemonDataSet;

public class DataSetTest {

	@Test
	public void getNbLinesTest() {
		PokemonDataSet pokemons=new PokemonDataSet();
		assertEquals(0,pokemons.getNbLines());
	}
	
	@Test
	public void getNbColumnTest() {
		PokemonDataSet pokemons=new PokemonDataSet();
		assertEquals(0,pokemons.nbColumns());
	}
	
	@Test
	public void setLinesTest() {
		List<IPoint> list =new ArrayList<IPoint>();
		Pokemon pokemon1 = new Pokemon("Swablu", 40, 5120, 255.0, 60, 600000, 45, 75, 50, "normal", "flying", 1.2, false);
		list.add(pokemon1);
		Pokemon pokemon2 = new Pokemon("Budew", 30, 5120, 255.0, 35, 1059860, 40, 70, 55, "grass", "poison", 1.2, false);
		list.add(pokemon2);
		PokemonDataSet pokemons=new PokemonDataSet();
		pokemons.setLines(list);
		assertEquals(list, pokemons.getPointsList());
	}
	
	@Test
	public void addLineTest() {
		List<IPoint> list =new ArrayList<IPoint>();
		Pokemon pokemon1 = new Pokemon("Swablu", 40, 5120, 255.0, 60, 600000, 45, 75, 50, "normal", "flying", 1.2, false);
		list.add(pokemon1);
		Pokemon pokemon2 = new Pokemon("Budew", 30, 5120, 255.0, 35, 1059860, 40, 70, 55, "grass", "poison", 1.2, false);
		list.add(pokemon2);
		PokemonDataSet pokemons=new PokemonDataSet();
		pokemons.addLine(pokemon1);
		pokemons.addLine(pokemon2);
		assertEquals(list, pokemons.getPointsList());
	}
	
	@Test
	public void addAllLineTest() {
		List<IPoint> list =new ArrayList<IPoint>();
		Pokemon pokemon1 = new Pokemon("Swablu", 40, 5120, 255.0, 60, 600000, 45, 75, 50, "normal", "flying", 1.2, false);
		list.add(pokemon1);
		Pokemon pokemon2 = new Pokemon("Budew", 30, 5120, 255.0, 35, 1059860, 40, 70, 55, "grass", "poison", 1.2, false);
		list.add(pokemon2);
		PokemonDataSet pokemons=new PokemonDataSet();
		pokemons.addAllLine(list);;
		assertEquals(list, pokemons.getPointsList());
	}
	
	@Test
	public void getColumnListTest() {
		List<Column> list=new ArrayList<Column>();
		PokemonDataSet pokemons=new PokemonDataSet();
		assertEquals(list,pokemons.getColumnsList());
	}
	
	@Test
	public void getCategoryListTest() {
		List<Category> list=new ArrayList<Category>();
		PokemonDataSet pokemons=new PokemonDataSet();
		list=pokemons.getCategoriesList();
		assertEquals(list,pokemons.getCategoriesList());
	}
	
	@Test
	public void getNormalizableColumnListTest() {
		Pokemon pokemon1 = new Pokemon("Swablu", 40, 5120, 255.0, 60, 600000, 45, 75, 50, "normal", "flying", 1.2, false);
		PokemonDataSet pokemons=new PokemonDataSet();
		pokemons.loadFromFile("./res/pokemon_train.csv");
		assertEquals("attack",pokemons.getNormalizableColumns().get(0).getName());
	}
	
	
	
}
