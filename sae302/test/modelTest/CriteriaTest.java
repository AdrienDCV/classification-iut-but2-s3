package modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Criteria;

class CriteriaTest {
	
	Criteria criteria;;

	@BeforeEach
	void setup() {
		criteria = new Criteria("colonneX","colonneY");
	}
	
	@Test
	void getterTest() {
		assertEquals("colonneX", criteria.getCriteriaX());
		assertEquals("colonneY", criteria.getCriteriaY());
	}
	
	@Test
	void setterTest() {
		criteria.setCriteriaX("colonneX2");
		criteria.setCriteriaY("colonneY2");
		assertEquals("colonneX2", criteria.getCriteriaX());
		assertEquals("colonneY2", criteria.getCriteriaY());
	}
	
	
	

}
