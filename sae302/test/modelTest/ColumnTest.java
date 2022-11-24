package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import model.BooleanColumn;
import model.BooleanValueNormalizer;
import model.Column;
import model.DataSet;
import model.EnumValueNormalizer;
import model.NumberValueNormalizer;


public class ColumnTest {
	
  @Test
  public void getDatasetTest() {
	  assertEquals(null,new BooleanColumn("bColumn", null , new ArrayList<>()).getDataset());
  }
  
  @Test
  public void getValueNormalizerTest() {
	  BooleanColumn columnTest=new BooleanColumn("bColumn", null , new ArrayList<>());
	  BooleanValueNormalizer valueNormalizerTest=(BooleanValueNormalizer) columnTest.getNormalizer();
	  assertEquals(valueNormalizerTest,columnTest.getNormalizer());
  }
}
