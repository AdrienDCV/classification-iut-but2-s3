package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.BooleanColumn;
import model.BooleanValueNormalizer;
import model.pokemon.PokemonDataSet;

public class BooleanValueNormalizerTest {

	
	@Test
	public void testBooleanValueNormalizerConstructor() {
		BooleanColumn bcolumn=new BooleanColumn("nColumn", new PokemonDataSet(), new ArrayList<>());
		BooleanValueNormalizer booleanValueNormalizer=new BooleanValueNormalizer(bcolumn);
		
		assertEquals("BN",booleanValueNormalizer.getValueNormalizer());
		assertNotEquals("NN",booleanValueNormalizer.getValueNormalizer());
		assertNotEquals("EN",booleanValueNormalizer.getValueNormalizer());
		assertNotEquals(null,booleanValueNormalizer.getValueNormalizer());
		
	}
	
	@Test
	public void testBooleanValueNormalizerNormalize() {
		BooleanColumn bcolumn=new BooleanColumn("nColumn", new PokemonDataSet(), new ArrayList<>());
		BooleanValueNormalizer booleanValueNormalizer=new BooleanValueNormalizer(bcolumn);
		
		assertEquals(1.0,booleanValueNormalizer.normalize(true));
		assertEquals(0.0,booleanValueNormalizer.normalize(false));
	}
	
	@Test
	public void testBooleanValueNormalizerDenormalize() {
		BooleanColumn bcolumn=new BooleanColumn("nColumn", new PokemonDataSet(), new ArrayList<>());
		BooleanValueNormalizer booleanValueNormalizer=new BooleanValueNormalizer(bcolumn);
		assertEquals(true,booleanValueNormalizer.denormalize(1));
		assertEquals(false,booleanValueNormalizer.denormalize(0));
	}
}

