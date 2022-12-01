package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import intefarces.IPoint;
import model.pokemon.LegendaryCategory;
import model.pokemon.Pokemon;

public class CategoryTest {

	ArrayList<IPoint> list;
	LegendaryCategory categoryTest;
	Pokemon pokemon;

	@BeforeEach
	public void setup() {
		list=new ArrayList<IPoint>();
		categoryTest = new LegendaryCategory();
		pokemon = new Pokemon("Dialga", 120, 30720, 3.0, 120, 1250000, 100, 100, 90, "steel", "dragon", 683.0, true);
		list.add(pokemon);
		categoryTest.addToCategory(pokemon);
	}
	
	@Test
	public void getCategoryNameTest() {
		assertEquals("Legendary",new LegendaryCategory().getCategoryName());
	}
	
	@Test
	public void getCategoryElementsTest() {
		assertEquals(list,categoryTest.getCategoryElements());
		assertEquals(list,categoryTest.getCategoryElements());
	}
}
