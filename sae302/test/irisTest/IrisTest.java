package irisTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.iris.Iris;
import model.NumberColumn;

public class IrisTest {
	Iris iris;
	NumberColumn colSepalLength, colSepalWidth, colPetalLength, colPetalWidth, colVariety; 
	
	@BeforeEach
	public void setup() {
		iris=new Iris(0,0,0,0,"irisVariety");
		colSepalLength = new NumberColumn("sepal.length", null, null);
		colSepalWidth =  new NumberColumn("sepal.width", null, null);
		colPetalLength = new NumberColumn("petal.length", null, null);
		colPetalWidth = new NumberColumn("petal.width", null, null);
		colVariety = new NumberColumn("variety", null, null);
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Iris [sepalLength=0.0, sepalWidth=0.0, petalLength=0.0, petalWidth=0.0, variety=irisVariety]",iris.toString());
	}
	
	@Test
	public void getValueSepalLengthTest() {
		assertEquals(null,iris.getValue(colSepalLength));
	}
	
	@Test
	public void getValueSepalWidth() {
		assertEquals(null,iris.getValue(colSepalWidth));
	}
	
	@Test
	public void getValuePetalLengthTest() {
		assertEquals(null,iris.getValue(colPetalLength));
	}
	
	@Test
	public void getValuePetalWidth() {
		assertEquals(null,iris.getValue(colPetalWidth));
	}
	
	@Test
	public void getValueVarietyTest() {
		assertEquals(null,iris.getValue(colVariety));
	}
}
