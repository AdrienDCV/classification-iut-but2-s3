package irisTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.iris.Iris;
import model.NumberColumn;

public class IrisTest {
	Iris iris1;
	
	@BeforeEach
	public void setup() {
		iris1=new Iris(0,0,0,0,"c");
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Iris [sepalLength=0.0, sepalWidth=0.0, petalLength=0.0, petalWidth=0.0, variety=c]",iris1.toString());
	}
	
	@Test
	public void getValueSepalLengthTest() {
		NumberColumn col=new NumberColumn("sepal.length", null, null);
		assertEquals(null,iris1.getValue(col));
	}
	
	@Test
	public void getValueSepalWidth() {
		NumberColumn col=new NumberColumn("sepal.width", null, null);
		assertEquals(null,iris1.getValue(col));
	}
	
	@Test
	public void getValuePetalLengthTest() {
		NumberColumn col=new NumberColumn("petal.length", null, null);
		assertEquals(null,iris1.getValue(col));
	}
	
	@Test
	public void getValuePetalWidth() {
		NumberColumn col=new NumberColumn("petal.width", null, null);
		assertEquals(null,iris1.getValue(col));
	}
	
	@Test
	public void getValueVarietyTest() {
		NumberColumn col=new NumberColumn("variety", null, null);
		assertEquals(null,iris1.getValue(col));
	}
}
