package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import intefarces.IPoint;
import model.Undefined;
import model.pokemon.Pokemon;
import model.pokemon.PokemonDataSet;

public class UndefinedTest {

	Undefined undefined;
	PokemonDataSet pokemonDataset;
	List<IPoint> list, pokeList;
	Pokemon poke1;
	
	@BeforeEach
	public void setup() {
		undefined=new Undefined();
		pokemonDataset=new PokemonDataSet();
		list=new ArrayList<IPoint>();
		pokeList=new ArrayList<IPoint>();
		poke1=new Pokemon();
		pokeList.add(poke1);
	}
	
	@Test
	public void addToCategoryDataSetTest() {
		assertEquals(list, undefined.addToCategory(pokemonDataset));
	}
	
	@Test
	public void addToCategoryIPointTest() {
		assertEquals(pokeList, undefined.addToCategory(poke1));
	}
	
	@Test
	public void addToCategoryIPointCategoryTest() {
		assertEquals(pokeList, undefined.addToCategory(poke1,new Undefined()));
	}
}
