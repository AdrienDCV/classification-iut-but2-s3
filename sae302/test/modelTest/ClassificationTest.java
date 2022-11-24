package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Classification;
import model.Criteria;
import pokemon.Pokemon;
import pokemon.PokemonDataSet;

public class ClassificationTest {
	Criteria criteria;
	PokemonDataSet dataset;
	Classification classi;
	Pokemon poke1;
	Pokemon poke2;

	
	
	@Test
	public void distanceEuclidieneTest() {
		criteria=new Criteria("base_egg_steps", "capture_rate");
		dataset=new PokemonDataSet("test");
		dataset.loadFromFile("./res/pokemon_test.csv");

		classi=new Classification(dataset.getColumnsList(),criteria, null);
		poke1=new Pokemon("test1",1000,30720,45, 0, 0, 0, 0, 0, "", "", 0, true);
		poke2=new Pokemon("test2",1000,30720,3, 0, 0, 0, 0, 0, "", "", 0, true);
		//assertEquals(42,classi.euclidianDistance(poke1, poke2));
	}
	
	@Test
	public void distanceManhatanTest() {
		//assertEquals(42,classi.manhatanDistance(poke1, poke2));
	}
	
	

}
