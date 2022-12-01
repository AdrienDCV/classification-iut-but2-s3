package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import intefarces.IPoint;
import model.ColumnFactory;
import model.pokemon.PokemonDataSet;

public class ColumnFactoryTest {

	PokemonDataSet pokemonDataSet;
	List<IPoint> pokemons;
	ColumnFactory factory;

	@BeforeEach
	public void setup() {
		pokemonDataSet=new PokemonDataSet();
		pokemons=new ArrayList<IPoint>();
		factory=new ColumnFactory();
	}

	@Test
	public void NumberColumnFactoryTest() {
		assertEquals("test",factory.createColumn(pokemonDataSet, pokemons, "int", "test").getName());
	}
	
	@Test
	public void EnumColumnFactoryTest() {
		assertEquals("null",factory.createColumn(pokemonDataSet, pokemons, "java.lang.String", "test").getName());
	}
	
	@Test
	public void BooleanColumnFactoryTest() {
		assertEquals("test",factory.createColumn(pokemonDataSet, pokemons, "boolean", "test").getName());
	}
}
