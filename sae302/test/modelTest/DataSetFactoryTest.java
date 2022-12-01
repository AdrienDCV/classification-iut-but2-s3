package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.iris.IrisDataSet;
import model.DataSetFactory;
import model.DataSetNull;
import model.pokemon.PokemonDataSet;
import model.titanic.TitanicDataSet;

public class DataSetFactoryTest {

	PokemonDataSet pokemons;

	@BeforeEach
	public void setup() {
		pokemons=(PokemonDataSet) DataSetFactory.createDataSet("Pokemon");
	}

	@Test
	public void createDataSetPokemonTest(){
		assertEquals("PokemonDataSet",pokemons.getTitle());
	}
	
	@Test
	public void createDataSetIrisTest() {
		IrisDataSet iris=(IrisDataSet) DataSetFactory.createDataSet("Iris");
		assertEquals("IrisDataSet",iris.getTitle());
	}
	
	@Test
	public void createDataSetTitanicTest() {
		TitanicDataSet titanic=(TitanicDataSet) DataSetFactory.createDataSet("Titanic");
		assertEquals("TitanicDataSet",titanic.getTitle());
	}
	
	@Test
	public void createDataSetNullTest() {
		DataSetNull dataset=(DataSetNull) DataSetFactory.createDataSet("dfed");
		assertEquals("",dataset.getTitle());
	}
	
}
