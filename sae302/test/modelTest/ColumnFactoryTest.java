package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import intefarces.IPoint;
import model.ColumnFactory;
import model.pokemon.PokemonDataSet;

public class ColumnFactoryTest {


	@Test
	public void NumberColumnFactoryTest() {
		PokemonDataSet pokemons=new PokemonDataSet();
		List<IPoint> points=new ArrayList<IPoint>();
		ColumnFactory factory=new ColumnFactory();
		assertEquals("test",factory.createColumn(pokemons, points, "int", "test").getName());
	}
	
	@Test
	public void EnumColumnFactoryTest() {
		PokemonDataSet pokemons=new PokemonDataSet();
		List<IPoint> points=new ArrayList<IPoint>();
		ColumnFactory factory=new ColumnFactory();
		assertEquals("null",factory.createColumn(pokemons, points, "java.lang.String", "test").getName());
	}
	
	@Test
	public void BooleanColumnFactoryTest() {
		PokemonDataSet pokemons=new PokemonDataSet();
		List<IPoint> points=new ArrayList<IPoint>();
		ColumnFactory factory=new ColumnFactory();
		assertEquals("test",factory.createColumn(pokemons, points, "boolean", "test").getName());
	}
}
