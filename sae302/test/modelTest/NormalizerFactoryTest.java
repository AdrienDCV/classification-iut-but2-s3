package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import intefarces.IPoint;
import model.BooleanColumn;
import model.Column;
import model.ColumnNull;
import model.EnumColumn;
import model.NormalizerFactory;
import model.NumberColumn;
import model.titanic.Titanic;

public class NormalizerFactoryTest {
	
	NumberColumn numberColumn;
	NormalizerFactory normFact;
	BooleanColumn booleanColumn;
	EnumColumn enumColumn;
	ColumnNull nullColumn;
	List<IPoint> list;
	
		
	@BeforeEach
	public void setup() {
		normFact=new NormalizerFactory();
		numberColumn=new NumberColumn("test", null, null);
		booleanColumn=new BooleanColumn("test", null, null);
		list=new ArrayList<IPoint>();
		list.add(new Titanic());
		enumColumn=new EnumColumn("Sex", null, list);
		nullColumn=new ColumnNull();
	}
	
	@Test
	public void normalizerFactoryNumberTest() {
		assertEquals("NN",normFact.creatValueNormalizer(numberColumn).getValueNormalizer());
	}
	
	@Test
	public void normalizerFactoryBooleanTest() {
		assertEquals("BN",normFact.creatValueNormalizer(booleanColumn).getValueNormalizer());
	}
	
	@Test
	public void normalizerFactoryEnumTest() {
		assertEquals("EN",normFact.creatValueNormalizer(enumColumn).getValueNormalizer());
	}
	
	@Test
	public void normalizerFactoryNullTest() {
		assertEquals("NULL",normFact.creatValueNormalizer(nullColumn).getValueNormalizer());
	}
}
