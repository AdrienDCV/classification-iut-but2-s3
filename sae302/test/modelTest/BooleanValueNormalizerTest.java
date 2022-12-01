package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.BooleanColumn;
import model.BooleanValueNormalizer;
import model.pokemon.PokemonDataSet;

public class BooleanValueNormalizerTest {

	BooleanColumn bcolumn;
	BooleanValueNormalizer booleanValueNormalizer;

	@BeforeEach
	public void setup() {
		bcolumn=new BooleanColumn("nColumn", new PokemonDataSet(), new ArrayList<>());
		booleanValueNormalizer=new BooleanValueNormalizer(bcolumn);
	}

	
	@Test
	public void testBooleanValueNormalizerConstructor() {			
		assertEquals("BN",booleanValueNormalizer.getValueNormalizer());
		assertNotEquals("NN",booleanValueNormalizer.getValueNormalizer());
		assertNotEquals("EN",booleanValueNormalizer.getValueNormalizer());
		assertNotEquals(null,booleanValueNormalizer.getValueNormalizer());
		
	}
	
	@Test
	public void testBooleanValueNormalizerNormalize() {		
		assertEquals(1.0,booleanValueNormalizer.normalize(true));
		assertEquals(0.0,booleanValueNormalizer.normalize(false));
	}
	
	@Test
	public void testBooleanValueNormalizerDenormalize() {
		assertEquals(true,booleanValueNormalizer.denormalize(1));
		assertEquals(false,booleanValueNormalizer.denormalize(0));
	}
}

