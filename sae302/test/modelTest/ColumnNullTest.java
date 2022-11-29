package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.ColumnNull;

public class ColumnNullTest {

	
	@Test
	public void createColumnNullTest(){
		ColumnNull column=new ColumnNull();
		assertEquals("null",column.getName());
	}
	
	@Test
	public void isNormalizableTest() {
		ColumnNull column=new ColumnNull();
		assert(!column.isNormalizable());
	}
}
