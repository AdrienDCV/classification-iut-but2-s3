package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import intefarces.IPoint;
import model.Category;
import pokemon.LegendaryCategory;
import pokemon.Pokemon;

public class CategoryTest {

	
	@Test
	public void getCategoryNameTest() {
		assertEquals("Legendary",new LegendaryCategory().getCategoryName());
	}
	
	@Test
	public void getCategoryElementsTest() {
		ArrayList<IPoint> list=new ArrayList<IPoint>();
		LegendaryCategory categoryTest=new LegendaryCategory();
		assertEquals(list,categoryTest.getCategoryElements());
		Pokemon pokemon3 = new Pokemon("Dialga", 120, 30720, 3.0, 120, 1250000, 100, 100, 90, "steel", "dragon", 683.0, true);
		list.add(pokemon3);
		categoryTest.addToCategory(pokemon3);
		assertEquals(list,categoryTest.getCategoryElements());
		
	}
}
