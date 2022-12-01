package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DataSetNull;

public class DataSetNullTest {

	DataSetNull dataset;

	@BeforeEach
	public void setup() {
		dataset=new DataSetNull();
	}

	@Test
	public void createDataSetNullTest() {
		assertEquals("",dataset.getTitle());
	}
	
	@Test
	public void defaultXColTest() {
		assertEquals("null",dataset.defaultXCol().getName());
	}
	
	@Test
	public void defaultYColTest() {
		assertEquals("null",dataset.defaultYCol().getName());
	}
}
