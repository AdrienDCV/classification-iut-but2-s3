package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import intefarces.IPoint;
import model.Column;
import model.DataSet;
import model.EnumColumn;
import model.EnumValueNormalizer;
import model.NumberColumn;
import model.NumberValueNormalizer;
import pokemon.PokemonDataSet;
import titanic.Embarked;
import titanic.Sex;
import titanic.Titanic;
import titanic.TitanicDataSet;

public class NumberValueNormalizerTest {
	

	Titanic point1, point2, point3;
	List<IPoint> pointsList;
	NumberColumn columnAge; 
	NumberValueNormalizer nvn;
	
    @BeforeEach
    void setup() {
    	pointsList = new ArrayList<>();
    	
        point1 = new Titanic( 1,0,3,"Braund, Mr. Owen Harris",Sex.MALE,22,1,0,"A/5 21171",7.25,"",Embarked.S);
        point2 = new Titanic(2,1,1,"Cumings, Mrs. John Bradley (Florence Briggs Thayer)",Sex.FEMALE,38,1,0,"PC 17599",71.2833,"C85",Embarked.C);
        point3 = new Titanic(17,0,3,"Rice, Master. Eugene",Sex.MALE,2,4,1,"382652",29.125,"",Embarked.Q);
        pointsList.add(point1); pointsList.add(point2); pointsList.add(point3);
        
        columnAge = new NumberColumn("Age", null, pointsList);
        
        nvn  = new NumberValueNormalizer(columnAge);  
    }
    
    @Test
    public void test_number_value_normalizer_constructor() {
    	// 
    }

    @Test
    public void test_number_value_normalizer_normalize() {
        assertEquals(1.0, nvn.normalize(25.0));
    }
    
//    @Test
//    public void test_number_value_normalizer_denormalize() {
//    	NumberColumn nColumn = new NumberColumn("base_egg_steps", new PokemonDataSet(), new ArrayList<>());
//        NumberValueNormalizer numberValueNormalizer = new NumberValueNormalizer(nColumn);
//        assertEquals(25.0, numberValueNormalizer.denormalize(1.0));
//    }
    

}
