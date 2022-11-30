package irisTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iris.IrisDataSet;

public class IrisDataSetTest {
	IrisDataSet dataset;
	
	@BeforeEach
	public void setup() {
		dataset=new IrisDataSet();
		dataset.loadFromFile("./res/iris.csv");
	}
	
	@Test
	public void defaultXColTest() {
		assertEquals("\"sepal.length\"",dataset.defaultXCol().getName());
	}
	
	@Test
	public void defaultYColTest() {
		assertEquals("\"sepal.width\"",dataset.defaultYCol().getName());
	}

}
