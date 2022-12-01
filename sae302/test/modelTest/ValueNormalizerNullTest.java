package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import intefarces.IPoint;
import model.NumberColumn;
import model.ValueNormalizerNull;
import model.pokemon.PokemonDataSet;

public class ValueNormalizerNullTest {

	List<IPoint> list;
	NumberColumn colone;
	ValueNormalizerNull vnn;
	
	@BeforeEach
	public void setup() {
		list=new ArrayList<IPoint>();
		colone=new NumberColumn("test",new PokemonDataSet(),list);
		vnn=new ValueNormalizerNull(colone);
	}
	
	@Test
	public void valueNormalizerNullConstructorTest() {
		assertEquals("NULL",vnn.getValueNormalizer());
	}
	
	@Test
	public void valueNormalizerNullNormalizeTest() {
		assertEquals(0,vnn.normalize(0));
	}
	
	@Test
	public void valueNormalizerNullDenormalizeTest() {
		assertEquals("",vnn.denormalize(0));
	}
}
