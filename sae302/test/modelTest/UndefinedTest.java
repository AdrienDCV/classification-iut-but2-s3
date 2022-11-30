package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import intefarces.IPoint;
import model.Undefined;
import pokemon.Pokemon;
import pokemon.PokemonDataSet;

public class UndefinedTest {

	@Test
	public void addToCategoryDataSetTest() {
		Undefined unde=new Undefined();
		PokemonDataSet dataset=new PokemonDataSet();
		List<IPoint> list=new ArrayList<IPoint>();
		assertEquals(list, unde.addToCategory(dataset));
	}
	
	@Test
	public void addToCategoryIPointTest() {
		Undefined unde=new Undefined();
		PokemonDataSet dataset=new PokemonDataSet();
		List<IPoint> list=new ArrayList<IPoint>();
		Pokemon poke1=new Pokemon();
		list.add(poke1);
		assertEquals(list, unde.addToCategory(poke1));
	}
	
	@Test
	public void addToCategoryIPointCategoryTest() {
		Undefined unde=new Undefined();
		PokemonDataSet dataset=new PokemonDataSet();
		List<IPoint> list=new ArrayList<IPoint>();
		Pokemon poke1=new Pokemon();
		list.add(poke1);
		assertEquals(list, unde.addToCategory(poke1,new Undefined()));
	}
}
