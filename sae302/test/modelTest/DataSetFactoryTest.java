package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import iris.IrisDataSet;
import model.DataSetFactory;
import model.DataSetNull;
import pokemon.PokemonDataSet;
import titanic.TitanicDataSet;

public class DataSetFactoryTest {

	@Test
	public void createDataSetPokemonTest(){
		
		PokemonDataSet pokemons=(PokemonDataSet) DataSetFactory.createDataSet("Pokemon");
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
