package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.BooleanColumn;
import model.BooleanValueNormalizer;


public class ColumnTest {
	
  BooleanValueNormalizer valueNormalizerTest;
  BooleanColumn columnTest;

  @BeforeEach
  public void setup() {
    columnTest=new BooleanColumn("bColumn", null , new ArrayList<>());
	  valueNormalizerTest=(BooleanValueNormalizer) columnTest.getNormalizer();
  }

  @Test
  public void getDatasetTest() {
	  assertEquals(null,new BooleanColumn("bColumn", null , new ArrayList<>()).getDataset());
  }
  
  @Test
  public void getValueNormalizerTest() {
	  assertEquals(valueNormalizerTest,columnTest.getNormalizer());
  }
}
