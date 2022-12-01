package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.ColumnNull;

public class ColumnNullTest {

	ColumnNull columnNull;

	@BeforeEach
	public void setup() {
		columnNull = new ColumnNull();
	}

	
	@Test
	public void createColumnNullTest(){
		assertEquals("null",columnNull.getName());
	}
	
	@Test
	public void isNormalizableTest() {
		assert(!columnNull.isNormalizable());
	}
}
