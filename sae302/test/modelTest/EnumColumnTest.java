package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import intefarces.IColumn;
import intefarces.IPoint;
import model.BooleanColumn;
import model.Column;
import model.EnumColumn;
import model.EnumValueNormalizer;
import pokemon.PokemonDataSet;
import titanic.Embarked;
import titanic.Sex;
import titanic.Titanic;
import titanic.TitanicDataSet;

public class EnumColumnTest {
	List<IPoint> pointsList;
	TitanicDataSet dataSet;
	
    @BeforeEach
    void setup() {
    	dataSet=new TitanicDataSet("test");
    	dataSet.loadFromFile("./res/titanic.csv");
    	pointsList = dataSet.getPointsList(); 
    }
    
    @Test
    public void test_enum_column_constructor() {
       assertEquals("Embarked", new EnumColumn("Embarked", dataSet, pointsList).getName());
    }

}
