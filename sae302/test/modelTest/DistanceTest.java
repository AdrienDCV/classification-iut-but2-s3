package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import intefarces.IPoint;
import model.Criteria;
import model.DistanceEuclidienne;
import model.NumberColumn;
import pokemon.Pokemon;
import pokemon.PokemonDataSet;

public class DistanceTest {

	@Test
	public void distaceEuclidienneTest() {
		
		PokemonDataSet dataset=new PokemonDataSet("test");
		dataset.loadFromFile("./res/pokemon_train.csv");
		Pokemon poke1=new Pokemon("test1",1000,30720,45, 0, 0, 0, 0, 0, "", "", 0, true);
		Pokemon poke2=new Pokemon("test2",1000,30720,3, 0, 0, 0, 0, 0, "", "", 0, true);
		
		DistanceEuclidienne distance=new DistanceEuclidienne();
		assertEquals(42,distance.calculDistance(poke1, poke2,dataset.getColumnsList().get(1),dataset.getColumnsList().get(2) ));
	
	}
}
