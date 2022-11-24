package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.DataSetNull;

public class DataSetNullTest {

	@Test
	public void createDataSetNullTest() {
		DataSetNull dataset=new DataSetNull();
		assertEquals("",dataset.getTitle());
	}
	
	@Test
	public void defaultXColTest() {
		DataSetNull dataset=new DataSetNull();
		assertEquals("",dataset.defaultXCol().getName());
	}
	
	@Test
	public void defaultYColTest() {
		DataSetNull dataset=new DataSetNull();
		assertEquals("",dataset.defaultYCol().getName());
	}
}
