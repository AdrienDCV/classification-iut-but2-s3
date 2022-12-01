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
	IrisDataSet iris;
	TitanicDataSet titanic;
	DataSetNull dataset;

	@BeforeEach
	public void setup() {
		pokemons=(PokemonDataSet) DataSetFactory.createDataSet("Pokemon");
		iris=(IrisDataSet) DataSetFactory.createDataSet("Iris");
		titanic=(TitanicDataSet) DataSetFactory.createDataSet("Titanic");
		dataset=(DataSetNull) DataSetFactory.createDataSet("dfed");
	}

	@Test
	public void createDataSetPokemonTest(){
		assertEquals("PokemonDataSet",pokemons.getTitle());
	}
	
	@Test
	public void createDataSetIrisTest() {
		assertEquals("IrisDataSet",iris.getTitle());
	}
	
	@Test
	public void createDataSetTitanicTest() {
		assertEquals("TitanicDataSet",titanic.getTitle());
	}
	
	@Test
	public void createDataSetNullTest() {
		assertEquals("",dataset.getTitle());
	}
	
}
