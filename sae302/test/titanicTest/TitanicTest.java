package titanicTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import titanic.Embarked;
import titanic.Sex;
import titanic.Titanic;

public class TitanicTest {
	Titanic tita;
	Titanic tita2;
	
	@BeforeEach
	public void setup(){
		tita=new Titanic(0, 0, 0, "jean", Sex.MALE, 0, 0, 0, "test", 0, "luxe", Embarked.C);
		tita2=new Titanic(0, 0, "jane", Sex.FEMALE, 0, 0, 0, "test", 0, "luxe", Embarked.C);
	}
	
	@Test
	public void getPassengerIDTest() {
		assertEquals(0,tita.getPassengerID());
	}
	
	@Test
	public void getpClassTest() {
		assertEquals(0,tita.getpClass());
	}
	
	@Test
	public void getSurvivedTest() {
		assertEquals(0,tita2.getSurvived());
	}
	
	@Test
	public void getNameTest() {
		assertEquals("jean",tita.getName());
	}
	
	@Test
	public void getSexTest() {
		assertEquals(Sex.MALE,tita.getSex());
	}
	
	@Test
	public void getAgeTest() {
		assertEquals(0,tita.getAge());
	}
	
	@Test
	public void getSibSpTest() {
		assertEquals(0,tita.getSibSp());
	}
	
	@Test
	public void getParchTest() {
		assertEquals(0,tita.getParch());
	}
	
	@Test
	public void getTicketTest() {
		assertEquals("test",tita.getTicket());
	}
	
	@Test
	public void getFareTest() {
		assertEquals(0.0,tita.getFare());
	}
	
	@Test
	public void getCabinTest() {
		assertEquals("luxe",tita.getCabin());
	}
	
	@Test
	public void getEmbarkedTest() {
		assertEquals(Embarked.C,tita.getEmbarked());
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Titanic [passengerID=0, survived=0, pClass=0, name=jean, sex=MALE, age=0.0, sibSp=0, parch=0, ticket=test, fare=0.0, cabin=luxe, embarked=C]",tita.toString());
	}
	
}
