package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import intefarces.IPoint;
import model.NumberColumn;
import model.ValueNormalizerNull;
import model.pokemon.PokemonDataSet;

public class ValueNormalizerNullTest {

	
	@Test
	public void valueNormalizerNullConstructorTest() {
		List<IPoint> list=new ArrayList<IPoint>();
		NumberColumn colone=new NumberColumn("test",new PokemonDataSet(),list);
		ValueNormalizerNull vnn=new ValueNormalizerNull(colone);
		assertEquals("NULL",vnn.getValueNormalizer());
	}
	
	@Test
	public void valueNormalizerNullNormalizeTest() {
		List<IPoint> list=new ArrayList<IPoint>();
		NumberColumn colone=new NumberColumn("test",new PokemonDataSet(),list);
		ValueNormalizerNull vnn=new ValueNormalizerNull(colone);
		assertEquals(0,vnn.normalize(0));
	}
	
	@Test
	public void valueNormalizerNullDenormalizeTest() {
		List<IPoint> list=new ArrayList<IPoint>();
		NumberColumn colone=new NumberColumn("test",new PokemonDataSet(),list);
		ValueNormalizerNull vnn=new ValueNormalizerNull(colone);
		assertEquals("",vnn.denormalize(0));
	}
}
