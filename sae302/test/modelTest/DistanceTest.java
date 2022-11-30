package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.DistanceEuclidienne;
import model.DistanceManhattan;
import model.pokemon.Pokemon;
import model.pokemon.PokemonDataSet;

public class DistanceTest {

	@Test
	public void distanceEuclidienneTest() {
		
		PokemonDataSet dataset=new PokemonDataSet("test");
		dataset.loadFromFile("./res/pokemon_train.csv");
		Pokemon poke1=new Pokemon("test1",1000,30720,45, 0, 0, 0, 0, 0, "", "", 0, true);
		Pokemon poke2=new Pokemon("test2",1000,30720,3, 0, 0, 0, 0, 0, "", "", 0, true);
		
		DistanceEuclidienne distance=new DistanceEuclidienne();
		assertEquals(0.16989449312079544,distance.calculDistance(poke1, poke2,dataset.getColumnsList().get(1),dataset.getColumnsList().get(2) ),0.001);
	
	}
	
	@Test
	public void distanceManhatanTest() {
		PokemonDataSet dataset=new PokemonDataSet("test");
		dataset.loadFromFile("./res/pokemon_train.csv");
		Pokemon poke1=new Pokemon("test1",1000,30720,45, 0, 0, 0, 0, 0, "", "", 0, true);
		Pokemon poke2=new Pokemon("test2",1000,30720,3, 0, 0, 0, 0, 0, "", "", 0, true);
		
		DistanceManhattan distance=new DistanceManhattan();
		assertEquals(0.2063725490196078,distance.calculDistance(poke1, poke2,dataset.getColumnsList().get(1),dataset.getColumnsList().get(2) ),0.001);
	}
}
