package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

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

	 private static String getColumClassName(Column column) {
	        String[] columnClassName = column.getClass().getName().split("\\.");
	        int idxClassName = (columnClassName.length)-1;
	        return columnClassName[idxClassName];
	    }
	
	@Test
	public void normalizerFactoryNumberTest() {
		NumberColumn col=new NumberColumn("test", null, null);
		NormalizerFactory fact=new NormalizerFactory();
		assertEquals("NN",fact.creatValueNormalizer(col).getValueNormalizer());
	}
	
	@Test
	public void normalizerFactoryBooleanTest() {
		BooleanColumn col1=new BooleanColumn("test", null, null);
		NormalizerFactory fact=new NormalizerFactory();
		System.out.println(getColumClassName(col1));
		assertEquals("BN",fact.creatValueNormalizer(col1).getValueNormalizer());
	}
	
	@Test
	public void normalizerFactoryEnumTest() {
		List<IPoint> list=new ArrayList<IPoint>();
		list.add(new Titanic());
		EnumColumn col=new EnumColumn("Sex", null, list);
		NormalizerFactory fact=new NormalizerFactory();
		assertEquals("EN",fact.creatValueNormalizer(col).getValueNormalizer());
	}
	
	@Test
	public void normalizerFactoryNullTest() {
		ColumnNull col=new ColumnNull();
		NormalizerFactory fact=new NormalizerFactory();
		assertEquals("NULL",fact.creatValueNormalizer(col).getValueNormalizer());
	}
}
