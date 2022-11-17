package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import intefarces.IPoint;
import model.Column;
import model.EnumColumn;
import model.EnumValueNormalizer;
import titanic.Embarked;
import titanic.Sex;
import titanic.Titanic;

public class EnumValueNormalizerTest {
    
    public static List<IPoint> pointsList = new ArrayList<>();

    private void initDataToTest() {
        Titanic point1 = new Titanic( 1,0,3,"Braund, Mr. Owen Harris",Sex.M,22,1,0,"A/5 21171",7.25,"",Embarked.S);
        Titanic point2 = new Titanic(2,1,1,"Cumings, Mrs. John Bradley (Florence Briggs Thayer)",Sex.F,38,1,0,"PC 17599",71.2833,"C85",Embarked.C);
        Titanic point3 = new Titanic(17,0,3,"Rice, Master. Eugene",Sex.M,2,4,1,"382652",29.125,"",Embarked.Q);
        pointsList.add(point1); pointsList.add(point2); pointsList.add(point3);
    }

    @Test
    public void test_enum_value_normalizer_consstrcutor() {
        initDataToTest();
        EnumColumn column1 = new EnumColumn("Embarked", null, this.pointsList);
        EnumValueNormalizer evn = new EnumValueNormalizer(column1);
        assertEquals("Embarked", ((Column) evn.getNormalizerTarget()).getName());

        EnumColumn column2 = new EnumColumn("Sex", null, this.pointsList); 
        EnumValueNormalizer evn2 = new EnumValueNormalizer(column2);
        assertEquals("Sex", ((Column) evn2.getNormalizerTarget()).getName());
    }

    @Test
    public void test_enum_value_normalizer_normalize() {
        initDataToTest();
        EnumColumn column = new EnumColumn("Sex", null, this.pointsList); 
        assertEquals(0, column.getNormalizedValue(this.pointsList.get(0)));
        assertEquals(1, column.getNormalizedValue(this.pointsList.get(1)));

    }
    
}
